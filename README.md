# find-example

find-example is a small utility inspired by clojure.core/find-doc. Given an regexp or string, it searches through examples repository from http://github.com/spariev/find-examples/blob/master/examples.clj and returns example snippets with matching :example and :doc metadata values.


By default, examples file is fetched the first time find-example is called, all subsequent calls do not make network requests. You may explicitly request find-example to refresh example snippets list by setting second parameter to true. 

## Usage

   (use '([spariev.find-example :as fe]))

   user> (fe/find-example "loop")
   -------------------------
   Example for loop
   computes the factorial of 5 with loop/recur
   (loop [cnt 5 acc 1] (if (zero? cnt) acc (recur (dec cnt) (* acc cnt))))
   => 120
   nil

   user> (spariev.find-example/find-example "nth" true) ;; refetches recent version of examples from github
   -------------------------
   Example for nth,random
   nth selects a value from the vector of words we supplied, in this case we called rand to get a number between 0 (inclusive) and 5 (exclusive).
   (nth ["hello" "bye" "foo" "bar" "baz"] (rand 5))
   => hello
   nil
   
  
## Installation

Will be available at clojar very soon

## License

Examples (which are mostly based on examples from Clojure wikibooks (http://en.wikibooks.org/wiki/Clojure_Programming)) and code are licensed under the Creative Commons Attribution/Share-Alike License - http://creativecommons.org/licenses/by-sa/3.0
 
