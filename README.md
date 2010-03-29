# find-example

find-example is a small utility inspired by clojure.core/find-doc. Given an regexp or string, it searches through examples repository at [http://github.com/spariev/find-examples/blob/master/examples.clj] and returns example snippets with matching :example and :doc metadata values.


By default, <code>examples.clj</code> file is fetched the first time <code>find-example</code> is called, all subsequent calls do not make network requests. You may explicitly request find-example to refresh example snippets list by setting second parameter to true. 

## Usage
<pre><code>
	(use 'spariev.find-example)
        
	user> (find-example "loop")
	-------------------------
	 Example for loop
	computes the factorial of 5 with loop/recur
	(loop [cnt 5 acc 1] (if (zero? cnt) acc (recur (dec cnt) (* acc cnt))))
	=> 120
	nil
		
	user> (find-example "nth" true) ;; refetches recent version of examples from github
	-------------------------
	Example for nth,random
	nth selects a value from the vector of words we supplied, in this case we called rand to get a number between 0 (inclusive) and 5 (exclusive).
	(nth ["hello" "bye" "foo" "bar" "baz"] (rand 5))
	=> hello
	nil
</pre></code>


## Installation

Just add
     [find-example "0.1"]
to :dev-dependencies in your project.clj, or, if you're not using leiningen, download latest version of find-example.jar from (http://clojars.org/repo/find-example/find-example) and add it to your classpath.

More info on installation can be found at the [clojars page](http://clojars.org/find-example)

## Contributions are welcomed!

I've added a few examples from Clojure Wikibooks, but as we all know, there is no such thing as too much examples. 
You can submit new examples by the usual github means, or send me a message if you want to be added as a collaborator.


## License

Examples (which are mostly based on examples from [Clojure wikibooks](http://en.wikibooks.org/wiki/Clojure_Programming)) and code are licensed under the [Creative Commons Attribution/Share-Alike License](http://creativecommons.org/licenses/by-sa/3.0)
