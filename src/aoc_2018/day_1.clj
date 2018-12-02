(ns aoc-2018.day-1
  (require [clojure.string :as str]
           [clojure.set :as set]
           [clojure.data :as data]))

(defn problem-1 []
(reduce + (map #(Integer/parseInt %) (str/split (slurp "input.txt") #"\n")))

(defn problem-2 []
(let [input (map #(Integer/parseInt %) (str/split (slurp "input.txt") #"\n"))]
    (loop [input          (cycle input)
           freq 0
           freq-occurence (set [])]
      ;(when (= (mod (count freq-occurence) 5) 0) (println (count freq-occurence)))
      (if (contains? freq-occurence freq)
        (println freq)
        (recur
          (rest input)
          (+ freq (first input))
          (conj freq-occurence freq))))))


