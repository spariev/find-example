(ns spariev.find-example
  (:use [clojure.contrib.http.agent :as http :only [string http-agent]]
	[clojure.contrib.pprint :as pp]))

(def *all-examples* (ref []))

(def *examples-url*
     "http://github.com/spariev/find-example/raw/master/examples.clj")

(defn- load-examples
  [refetch]
  (when (or (= 0 (count @*all-examples*)) refetch)
    (let [new-examples
	  (read (java.io.PushbackReader.
		 (java.io.StringReader.
		  (http/string (http/http-agent *examples-url*)))))]
      (dosync
       (ref-set *all-examples* new-examples))))
  @*all-examples*)


(defn- print-example
  [v]
  (println "-------------------------")
  (println "Example for" (:example (meta v)))
  (println (:doc (meta v)))
  (binding [*print-right-margin* 40]
    (with-pprint-dispatch *code-dispatch* (pprint v)))
  (print "=> ")
  (pprint (eval v)))

(defn find-example
  "Finds and prints example which :example or :doc metadata contains a match for re-string-or-pattern. If refetch is true, refetches examples file from github."
  ([re-string-or-pattern]
    (find-example re-string-or-pattern false))
  ([re-string-or-pattern refetch]
    (let [re (re-pattern re-string-or-pattern)]
      (doseq [example (load-examples refetch)
              :when (and (:example (meta example))
			 (or (re-find (re-matcher re (or (:doc (meta example)) "")))
                             (re-find (re-matcher re (:example (meta example))))))]
               (print-example example)))))
