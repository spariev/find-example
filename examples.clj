;; Based on examples from Clojure wikibooks (http://en.wikibooks.org/wiki/Clojure_Programming),
;; licensed under the Creative Commons Attribution/Share-Alike License - http://creativecommons.org/licenses/by-sa/3.0/ 

[
#^{:example "loop" :doc "computes the factorial of 5 with loop/recur"}
(loop [cnt 5 acc 1]
  (if (zero? cnt)
    acc
    (recur (dec cnt) (* acc cnt))))

#^{:example "reduce, range" :doc "(range 1 100 2) creates a lazy sequence of numbers 1 3 5 7 ... 99. 1 is the starting point, 100 is the end point, 2 is the step. reduce calls the + function."}
(reduce + (range 1 100 2))

#^{:example "nth,random" :doc "nth selects a value from the vector of words we supplied, in this case we called rand to get a number between 0 (inclusive) and 5 (exclusive)."}
(nth ["hello" "bye" "foo" "bar" "baz"] (rand 5))


#^{:example "get"}
(get {:a 1 :b 2} :a)

#^{:example "get" :doc "get also accepts an optional third argument, which is returned if key is not found in map"}
(get {:a 1 :b 2} :e 0)

#^{:example "assoc-in"}
(let [nested-structure { :level 0 :nested1
			{ :level 1 :final-data "initial data"}}]
 (assoc-in nested-structure [:nested1 :final-data] "new data")) 

#^{:example "merge" :doc "Combine two maps into a more massive map"}
(merge {:a 1} {:b 2})

#^{:example "merge-with"}
(merge-with + {:a 1} {:a 2, :b 3})

#^{:example "union"}
(clojure.set/union #{1 2 3} #{1 4 7})

#^{:example "zipmap"}
(let [ks [1 3 4]] (zipmap ks (map inc ks)))


#^{:example "filter"}
(filter nil? [:a :b nil nil :a]) 

#^{:example "filter"}
(filter (fn[x](= x :b)) [:a :b nil nil :a])

#^{:example "remove"}
(remove nil? [:a :b nil nil :a]) 

#^{:example "some"}
(some #{:a} [:a :b])

#^{:example "every"}
(every? #{:a :b} [:a :b :c])

#^{:example "every"}
(every? #{:a :b} [:a :b])


#^{:example "interpose"}
(apply str (interpose "|" ["hi" "mum" "and" "dad"]))

#^{:example "interleave" :result (1 :a 2 :b 3 :c)}
(interleave [1 2 3] [:a :b :c])

#^{:example "apply,interpose,reverse"}
(apply str (interpose " " (reverse (.split "I am cold" " "))))

#^{:example "butlast"}
(butlast "hello")

#^{:example "replace"}
(apply str (replace {\l ""} "hello world"))

#^{:example "conj"}
(conj [1 2 3] 4)

#^{:example "conj"}
(conj '(:a :b :c) \d)

#^{:example "map"}
(map + [1 2 3 4] [1 2 3 4])

#^{:example "reduce,filter,range" :doc "sum the odd numbers to 100"}
(reduce + (filter odd? (range 100)))

#^{:example "->"}
(-> "abc" .toUpperCase (.replace "B" "-"))

#^{:example "->"}
(-> true (if inc dec) (map [1 2 3]))

#^{:example "cond"}
(#(cond (= 1 %) 1 (> % 1) 100 :else 0) 5)

#^{:example "condp"}
(let [a 5]
  (condp = a
    1 "hi"
    5 "fun"))

]
