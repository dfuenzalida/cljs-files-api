(ns app.main
  (:require [reagent.core :as r]
            [reagent.dom :as rdom]))

(defonce file-info (r/atom nil))

(defn example-app []
  [:div
   (if @file-info
     (let [{:keys [name size contents type]} @file-info]
       [:div "File info:"
        [:ul
         [:li (str "Name: " name)]
         [:li (str "Size: " size " bytes")]
         [:li (str "Filetype: " type)]
         [:li (str "First 100 bytes: " contents)]]])
     [:div "File not selected"])
   [:hr]
   [:div "Select a file:"
    [:input {:type "file" :id "input"}]]])

(defn handle-files [fs]
  (let [file (aget (.-files fs) 0)
        slice (.slice file 0 100)]
    (-> slice .text (.then #(swap! file-info assoc-in [:contents] %)))
    (reset! file-info {:name (.-name file)
                       :size (.-size file)
                       :type (.-type file)})))

;; App initialization

(defn mount-root []
  (rdom/render [example-app] (.getElementById js/document "app"))

  ;; register fn to check on the file[s]
  (-> (.getElementById js/document "input")
      (.addEventListener "change" #(handle-files (.-target %)) false)))

(defn main! []
  (mount-root)
  (println "[core]: loading"))

(defn reload! []
  (mount-root)
  (println "[core] reloaded"))
