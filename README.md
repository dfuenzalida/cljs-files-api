
HTML5 Files API demo using [shadow-cljs](https://github.com/thheller/shadow-cljs)
----

### Development

Run in developmeent:

```bash
yarn run html
yarn shadow-cljs watch app
```

`shadow-cljs` will be installed in `node_modules/` when you run `yarn`.

`:dev-http` specifies that `target/` will be served at http://localhost:8080 .

Click on the file selector to feed the page a file. The code will display the filename, size, mime-type and the first 100 bytes of the file.

### REPL

After page is loaded, you may also start a REPL connected to browser with:

```bash
yarn shadow-cljs cljs-repl app
```

### Release

Compile with optimizations with `release` sub-command:

```bash
yarn shadow-cljs release app
mkdir -p target && cp assets/index.html target/
yarn serve # serving target/ on http://localhost:8080
```

Read docs for more http://doc.shadow-cljs.org/ .

### License

MIT
