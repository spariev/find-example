(ns spariev.find-example
  (:require clojure.contrib.http.agent))

(def *all-examples* (ref []))

(def *examples-url*
     "http://github.com/spariev/find-example/raw/master/examples.clj")

(defn- load-examples
  [refetch]  
  (when (or (= 0 (count @*all-examples*)) refetch)
    (let [new-examples
	  (read (java.io.PushbackReader.
		 (java.io.StringReader.
		  (clojure.contrib.http.agent/string (clojure.contrib.http.agent/http-agent *examples-url*)))))]
      (dosync
       (ref-set *all-examples* new-examples))))
  @*all-examples*)
      
	  
(defn- print-example
  [v]
  (println "-------------------------")
  (println "Example for" (:example (meta v)))
  (println (:doc (meta v)))
  (prn v)
  (println "=>" (:result (meta v))))

(defn find-example
  "Finds and prints example which :example or :doc metadata contains a match for re-string-or-pattern. If refetch is true, refetches examples file from github."
  ([re-string-or-pattern]
    (find-example re-string-or-pattern false))
  ([re-string-or-pattern refetch]
    (let [re (re-pattern re-string-or-pattern)]
      (doseq [example (load-examples refetch)
              :when (and (:example (meta example))
			 (:doc (meta example))
                         (or (re-find (re-matcher re (:doc (meta example))))
                             (re-find (re-matcher re (:example (meta example))))))]
               (print-example example)))))