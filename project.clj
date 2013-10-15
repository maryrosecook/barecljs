(defproject barecljs "0.1.0"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-1934"]]

  :source-paths ["src"]

  :plugins [[lein-cljsbuild "0.3.4"]]

  :cljsbuild
  {:builds
    [{:id "dev"
      :source-paths ["src"]
      :compiler {:output-to "main.js"
                 :output-dir "out"
                 :optimizations :none}}
     {:id "node"
      :source-paths ["src"]
      :compiler {:output-to "main.js"
                 :optimizations :simple
                 :pretty-print true}}] })
