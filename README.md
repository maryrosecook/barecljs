# Get started with ClojureScript

### Install Leiningen (a Clojure build tool)

#### With homebrew (OS X)

    $ brew install leiningen

#### Manually

Download the script.

    $ curl https://raw.github.com/technomancy/leiningen/stable/bin/lein > ~/bin/lein

Check ~/.bin is in your path by running:

    $ echo $PATH

Set the lein script to be executable.

    $ chmod 755 ~/bin/lein

Install.

    $ lein

Check it works.

    $ lein repl
    $ (+ 2 2)

### Install Java JDK 6 or later

Follow the instructions at http://www.java.com/en/download/help/index_installing.xml

### Make a simple ClojureScript project

Make this directory structure:

    barecljs/
      src/
        bare/
          core.cljs
      project.clj

Make these files:

project.clj

    (defproject barecljs "0.1.0"
      :dependencies [[org.clojure/clojure "1.5.1"]
                     [org.clojure/clojurescript "0.0-1934"
                      :exclusions [org.apache.ant/ant]]]
      :source-paths ["src"]

      :plugins [[lein-cljsbuild "0.3.4"]]

      :cljsbuild
      {:builds
       [{:id "dev"
         :source-paths ["src"]
         :compiler {:output-to "out/browser/main.js"
                    :output-dir "out/browser"
                    :optimizations :none}}
        {:id "node"
         :source-paths ["src"]
         :compiler {:output-to "out/node/main.js"
                    :optimizations :simple
                    :pretty-print true}}] })

bare.cljs

    (ns bare.core)
    (js/console.log (+ 2 2))

Install the dependencies for the example project.

Installs the jars required to run the project into a local jar folder.

    $ lein deps

Compile cljs code to JS. If the cljs changes it will be recompiled automatically.

    $ lein cljsbuild auto

Open `out/node/main.js` and check it has `console.log(4);` on the last line

Change the cljs code `(+ 2 2)` to something else, save and check that the JS changes.

### Run your JS code

#### node

##### Install node

###### With homebrew

    $ brew install node

###### Manually

Go to [nodejs.org](http://nodejs.org) and click the Install button

##### Run the JS

    $ cd barecljs
    $ node out/node/main.js

#### Browser

##### Run the JS

In the root of your project, make an `index.html` file that will load your JS code

    <html>
        <body>
            <script src="out/browser/goog/base.js" type="text/javascript"></script>
            <script src="out/browser/main.js" type="text/javascript"></script>
            <script type="text/javascript">goog.require("bare.core");</script>
        </body>
    </html>

Open `index.html` in your browser.  Open the browser console.
