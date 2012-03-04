(ns toplinked.core
  (:use [linkedin-connections.core :as linkedin :only [get-emails]])
  (:use [clojure.set :as set])
  (:require [clojure.java.io :as io])
  (:gen-class :main true))


;; the toplinked list is simply an email address on each line
;; so we only have to doall on our results
(defn get-toplinked-emails [file]
  (with-open [rdr (io/reader file)]
    (doall (line-seq rdr))))


;; return the seat of values that are in the toplinked list but not
;; in the linkedin list
(defn get-new [toplinked linkedin]
  (let [t (get-toplinked-emails toplinked)
        l (linkedin/get-emails linkedin)]
    (difference (set t) (set l))))


(defn print-usage []
  (println "toplinked TOPLINKED.csv LINKEDIN.csv"))

(defn -main [& args]
  (if (and args (= (count args) 2))
    (let [new (get-new (first args) (second args))]
      (doseq [email new]
        (println email)))
    (print-usage)))
