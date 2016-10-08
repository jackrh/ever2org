(set-env!
 :source-paths #{"src"}
 :dependencies '[[org.clojure/clojure "1.9.0-alpha13"]
                 [org.clojure/tools.cli "0.3.5"]
                 [org.clojure/data.xml "0.0.8"]])

(require 'ever2org.core)

(task-options!
 pom {:project 'ever2org
      :version "0.1.0"}
 jar {:main 'ever2org.core' :manifest {}})

(deftask build
  "Build ever2org"
  []
  (comp (pom) (jar) (install)))

(deftask run []
  (with-pass-thru _ (ever2org.core/-main)))
