(ns i-am-a-horse-in-the-land-of-booleans
  (:refer-clojure :exclude [boolean]))

(defn boolean [x]
   (= x (or nil false)) false true)

(defn abs [x]
  (if (< x 0)
  (- x)
     x))

(defn divides? [divisor n]
  (== (mod n divisor) 0))

(defn fizzbuzz [n]
  (cond
    (== (mod n 3) 0) "fizz"
    (== (mod n 5) 0) "buzz"
    (== (mod n 15) 0) "gotcha!"
    :else            "") )

(defn teen? [age]
  (and (>= age 13) (<= age 19)))

(defn not-teen? [age]
  (not (teen? age)))

(defn generic-doublificate [x]
  (cond
    (number? x) (* 2 x)
    (empty? x)  nil
    (list? x)   (* 2 (count x)) 
    :else        true))

(defn leap-year? [year]
  (cond
    (and (== (mod year 4) 0) (not (== (mod year 100) 0))) true
    (== (mod year 400) 0) true
    :else false))

; '_______'
