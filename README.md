Get started with ClojureScript

1 Install Leiningen (a Clojure build tool)
  a With homebrew (OS X)
    $ brew install leiningen
  b Manually (https://github.com/technomancy/leiningen/blob/master/README.md)
    1 curl https://raw.github.com/technomancy/leiningen/stable/bin/lein > ~/bin/lein
    2 Check ~/.bin is in your path by running
        $ echo $PATH
    3 Set the lein script to be executable
        $ chmod 755 ~/bin/lein
    4 Install
        $ lein
    5 Check it works
        $ lein repl
        $ (+ 2 2)

2 Install Java JDK 6 or later
  a Manually
      http://www.java.com/en/download/help/index_installing.xml

3 Make a simple ClojureScript project
  a Manually
    1 Make this directory structure
      barecljs/
        src-cljs/
          bare/
            bare.cljs
        project.clj

    2 Make these files

      project.clj
        (defproject barecljs "0.1.0"
          :source-paths ["src-clj"]
          :dependencies [[org.clojure/clojure "1.5.1"]
                        [org.clojure/clojurescript "0.0-1859"
                         :exclusions [org.apache.ant/ant]]]
          :plugins [[lein-cljsbuild "0.3.4"]]
          :cljsbuild {
                      :builds [{:source-paths ["src-cljs"]
                                :compiler {:output-to "js/main.js"
                                           :optimizations :simple
                                           :pretty-print true}}]})

      bare.cljs
        (ns example.core)
        (console/log (+ 2 2))

    3 Install the dependencies for the example project
      $ lein deps
        Installs the jars required to run the project into a local jar folder.
    4 Compile cljs code to JS, save to disk. If cljs changes, recompiles automatically.
      $ lein cljsbuild auto
    5 Open js/main.js and check it has 2 + 2 on the last line
    6 Change the cljs code `(+ 2 2)` to something else, save, check the JS changes

4 Run your JS code
  a node
    1 Install node
      a With homebrew
        $ brew install node
      b Manually
        Go to nodejs.org and click the Install button
    2 Run the JS
      $ cd barecljs
      $ node js/main.js
