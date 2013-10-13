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
