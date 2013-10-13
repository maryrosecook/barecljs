# Get started with ClojureScript

### Install Leiningen (a Clojure build tool)

#### With homebrew (OS X)

    $ brew install leiningen

#### Manually

Download the script

    $ curl https://raw.github.com/technomancy/leiningen/stable/bin/lein > ~/bin/lein

Check ~/.bin is in your path by running

    $ echo $PATH

Set the lein script to be executable

    $ chmod 755 ~/bin/lein

Install

    $ lein

Check it works

    $ lein repl
    $ (+ 2 2)

### Install Java JDK 6 or later

Follow the instructions at http://www.java.com/en/download/help/index_installing.xml

### Make a simple ClojureScript project

Make this directory structure

    barecljs/
      src-cljs/
        bare/
          bare.cljs
      project.clj

Make these files

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

Install the dependencies for the example project

Installs the jars required to run the project into a local jar folder.

    $ lein deps

Compile cljs code to JS, save to disk. If cljs changes, recompiles automatically.

    $ lein cljsbuild auto

Open js/main.js and check it has `2 + 2` on the last line

Change the cljs code `(+ 2 2)` to something else, save, check that the JS changes

### Run your JS code

#### node

##### Install node

###### With homebrew

    $ brew install node

###### Manually

Go to [nodejs.org](http://nodejs.org) and click the Install button

##### Run the JS

    $ cd barecljs
    $ node js/main.js
