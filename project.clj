(defproject barecljs "0.1.0"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2014"
                  :exclusions [org.apache.ant/ant]]]
  :source-paths ["src"]

  :plugins [[lein-cljsbuild "1.0.0-alpha1"]]

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
