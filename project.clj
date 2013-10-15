(defproject barecljs "0.1.0"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-1934"
                  :exclusions [org.apache.ant/ant]]]
  :source-paths ["src"]

  :plugins [[lein-cljsbuild "0.3.4"]]
  :cljsbuild {
              :builds [{:source-paths ["src-cljs"]
                        :compiler {:output-to "js/node/main.js"
                                   :optimizations :simple
                                   :pretty-print true}}
                       {:source-paths ["src-cljs"]
                        :compiler {:output-to "js/browser/main.js"
                                   :optimizations :whitespace
                                   :pretty-print true}}]})
