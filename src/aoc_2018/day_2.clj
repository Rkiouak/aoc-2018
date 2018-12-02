(ns aoc-2018.day-2
  (require [clojure.string :as str]
           [clojure.set :as set]
           [clojure.data :as data]))

(defn problem-1 []
  (let [input (str/split (slurp "resources/inputs/day-2-input.txt") #"\n")]
    (reduce * (reduce #(conj [] (+ (first %2) (first %1)) (+ (second %2) (second %1))) [0 0] (map #(conj [] (if (contains? (set %) 2) 1 0) (if (contains? (set %) 3) 1 0)) (map vals (map frequencies input)))))))

(defn problem-2 []
  (let [input (str/split (slurp "resources/inputs/day-2-input.txt") #"\n")]
    (loop [id-one (first input)
           to-compare (rest input)]
      (println (count to-compare))
      (let [result (filter #(= 25 (count (filter some? (map-indexed (fn [idx elem] (when (= (get id-one idx) elem) elem)) %)))) to-compare)]
        (if (not-empty result)
          (println "result: " result "\n id-one: " id-one "\n common (problem answer): " (reduce str "" (last (data/diff (seq (reduce str "" result)) (seq id-one)))))
          (if (< 0 (count to-compare))
            (recur (first to-compare) (rest to-compare))
            (println "none found")))))))