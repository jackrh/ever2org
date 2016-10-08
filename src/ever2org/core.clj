(ns ever2org.core
  (:require [clojure.tools.cli :refer [parse-opts]]
            [clojure.java.io :as io])
  (:gen-class))

(def cli-options
  [["-e" "--evernote FILE" "Evernote enex file"]
   ["-o" "--output DIR" "Output directory"]])

(defn xml-reader "produce a Reader from a text file"
  [filename]
  (-> filename
      io/file
      io/input-stream
      io/reader))

(defn -main [& args]
  (let [options (parse-opts args cli-options)]
    (println options)))
