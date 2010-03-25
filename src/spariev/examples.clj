(ns spariev.examples)

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
]