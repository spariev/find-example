;; Based on examples from Clojure wikibooks (http://en.wikibooks.org/wiki/Clojure_Programming),
;; licensed under the Creative Commons Attribution/Share-Alike License - http://creativecommons.org/licenses/by-sa/3.0/ 

[
#^{:example "loop" :result 120 :doc "computes the factorial of 5 with loop/recur"}
(loop [cnt 5 acc 1]
  (if (zero? cnt)
    acc
    (recur (dec cnt) (* acc cnt))))

#^{:example "reduce, range" :result 2500 :doc "(range 1 100 2) creates a lazy sequence of numbers 1 3 5 7 ... 99. 1 is the starting point, 100 is the end point, 2 is the step. reduce calls the + function."}
(reduce + (range 1 100 2))

#^{:example "nth,random" :result "hello" :doc "nth selects a value from the vector of words we supplied, in this case we called rand to get a number between 0 (inclusive) and 5 (exclusive)."}
(nth ["hello" "bye" "foo" "bar" "baz"] (rand 5))


#^{:example "get" :result 1 :doc ""}
(get {:a 1 :b 2} :a)

#^{:example "get" :result 0 :doc "get also accepts an optional third argument, which is returned if key is not found in map"}
(get {:a 1 :b 2} :e 0)

#^{:example "assoc-in" :result {:level 0, :nested1 {:level 1, :final-data "new data"}} :doc ""}
(let [nested-structure { :level 0 :nested1
			{ :level 1 :final-data "initial data"}}]
 (assoc-in nested-structure [:nested1 :final-data] "new data")) 

#^{:example "merge" :result {:a 1, :b 2} :doc "Combine two maps into a more massive map"}
(merge {:a 1} {:b 2})

#^{:example "merge-with" :result {:a 3 :b 3} :doc ""}
(merge-with + {:a 1} {:a 2, :b 3})

#^{:example "union" :result #{1 2 3 4 7} :doc ""}
(clojure.set/union #{1 2 3} #{1 4 7})

#^{:example "zipmap" :result {4 5, 3 4, 1 2}  :doc ""}
(let [ks [1 3 4]] (zipmap ks (map inc ks)))


#^{:example "filter" :result (nil nil)  :doc ""}
(filter nil? [:a :b nil nil :a]) 

#^{:example "filter" :result (:b) :doc ""}
(filter (fn[x](= x :b)) [:a :b nil nil :a])

#^{:example "remove" :result (:a :b :a) :doc ""}
(remove nil? [:a :b nil nil :a]) 

#^{:example "some" :result :a :doc ""}
(some #{:a} [:a :b])

#^{:example "every" :result false :doc ""}
(every? #{:a :b} [:a :b :c])

#^{:example "every" :result true :doc ""}
(every? #{:a :b} [:a :b])

]
