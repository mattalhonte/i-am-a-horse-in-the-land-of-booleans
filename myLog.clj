; CIDER 0.9.0snapshot (package: 20150407.1104) (Java 1.8.0_40, Clojure 1.5.1, nREPL 0.2.7)
user> (if "foo" "truthy" "falsey")
"truthy"
user> (if 0 "truthy" "falsey")
"truthy"
user> (if [] "truthy" "falsey")
"truthy"
user> (if false "truthy" "falsey")
"falsey"
user> (if nil "truthy" "falsey")
"falsey"
user> (boolean "foo")
true
user> (boolean nil)
false
user> (boolean false)
false
user> (= "foo" "foo")
true
user> (= "foo" "bar")
false
user> (== 42 42)
true
user> (= 42 42)
true
user> (== 5.0 5)
true
user> (= 5.0 5)
false
user> (< 1 2)
true
user> (> 1 2)
false
user> (<= 52 2)
false
user> (= x y z)
CompilerException java.lang.RuntimeException: Unable to resolve symbol: x in this context, compiling:(C:\Users\Matt\AppData\Local\Temp\form-init9073661385164023487.clj:1:1) 
user> (< 1 6 8)
true
user> (defn teen? [age]
  (and (=> age 13) (=< age 19)))
CompilerException java.lang.RuntimeException: Unable to resolve symbol: => in this context, compiling:(C:\Users\Matt\AppData\Local\Temp\form-init9073661385164023487.clj:2:8) 
user> (defn teen? [age] (and (=> age 13) (=< age 19)))
CompilerException java.lang.RuntimeException: Unable to resolve symbol: => in this context, compiling:(C:\Users\Matt\AppData\Local\Temp\form-init9073661385164023487.clj:1:24) 
user> (defn teen? [age]
  (and (=> age 13) (=< age 19)) true false)
CompilerException java.lang.RuntimeException: Unable to resolve symbol: => in this context, compiling:(C:\Users\Matt\AppData\Local\Temp\form-init9073661385164023487.clj:2:8) 
user> (defn teen? [age]
  (and (>= age 13) (<= age 19)) true false)
#'user/teen?
user> (teen 9)
CompilerException java.lang.RuntimeException: Unable to resolve symbol: teen in this context, compiling:(C:\Users\Matt\AppData\Local\Temp\form-init9073661385164023487.clj:1:1) 
user> (teen? 9)
false
user> (teen? 15)
false
user> (defn teen? [age]
  (and (>= age 13) (<= age 19)))
#'user/teen?
user> (teen? 15)
true
user> (teen? 9)
false
user> (defn sign [x]
        (if (< x 0)
          "-"
          "+"))
#'user/sign
user> (sign 2)
"+"
user> (sign -2)
"-"
user> (sign 0)
"+"
user> (if true
        42
        (/ 1 0))
42
user> (- -5)
5
user> (defn abs [x]
  if (< x 0)
  (- x)
     x)
CompilerException java.lang.RuntimeException: Unable to resolve symbol: if in this context, compiling:(C:\Users\Matt\AppData\Local\Temp\form-init9073661385164023487.clj:1:1) 
user> (defn abs [x]
  (if (< x 0)
  (- x)
     x))
#'user/abs
user> (abs -5)
5
user> (abs 6)
6
user> (defn divides? [divisor n]
  (== (mod n divisor) 0))
#'user/divides?
user> (divides? 15 5)
false
user> (divides? 5 15)
true
user> (neg? 5)
false
user> (defn super-sign [number]
        (cond
          (neg? number) "negative"
          (pos? number) "positive"
          :else         "zero"))
#'user/super-sign
user> (super-sign -5)
"negative"
user> (defn fizzbuzz [n]
  (cond
    (== (mod n 3) 0) "fizz"
    (== (mod n 5) 0) "buzz"
    (== (mod n 15) 0) "gotcha!"
    :else            "") )
#'user/fizzbuzz
user> (fizzbuzz 15)
"fizz"
user> (fizzbuzz 9)
"fizz"
user> (fizzbuzz 25)
"buzz"
user> (fizzbuzz 30)
"fizz"
user> (fizzbuzz 17)
""
user> (defn generic-doublificate [x]
  (cond
    (number? x) (* 2 x)
    (empty? x)  nil
    (list? x)   (* 2 (count x)) 
    :else        true))
#'user/generic-doublificate
user> (generic-doublificate 5)
10
user> (and true true)
true
user> (and true false)
false
user> (or true false)
true
user> (or false false)
false
user> (not true)
false
user> (not false)
true
user> (and true true true)
true
user> (and true true true true false)
false
user> (or false false false false false true)
true
user> (or false false false)
false
user> (or)
nil
user> (and)
true
user> (and true
           false
           true)
false
user> (and "foo" "bar")
"bar"
user> (and "foo" false)
false
user> (defn not-teen? [age]
  (not (teen? age)))
#'user/not-teen?
user> (not-teen? 9)
true
user> (not-teen? 15)
false
user> (fn [year] (and (==(mod year 100) 0)  (== (mod year 400) 0) ) )
#<user$eval7259$fn__7260 user$eval7259$fn__7260@7d2df71e>
user> (== (mod 800 400) 0)
true
user> (and 
       (== (mod 80 4) 0)
       (not (== (mod 80 100) 0)))
true
user> (or
       (== (mod 800 400) 0)
       (and 
       (== (mod 800 4) 0)
       (not (== (mod 800 100) 0))))
true
user> (defn leap-year? [year]
  (cond
    (and (== (mod year 4) 0)
         (not (== (mod year 100) 0))) true
         (== (mod year 400) 0) true
         :else false))
