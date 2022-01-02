(ns ld3)

(require '[clojure.string :as str])

;; 1. Find the last element of a list.
(defn my-last [xs]
  (if (empty? (rest xs))
    (first xs)
    (my-last (rest xs))))

(assert (= :d
           (my-last '(:a :b :c :d))))

;; 2. Find the N-th element of a list.
(defn get-nth [xs n]
  (loop [cnt n tmp-list xs]
    (if (zero? cnt)
      (first tmp-list)
      (recur (dec cnt) (rest tmp-list)))))

(assert (= :c
           (get-nth '(:a :b :c :d) 2)))

;; 3. Find the length of a list
(defn my-length [xs]
  nil)

(assert (= 4
           (my-length '(:a :b :c :d))))

;; 4. Reverse a list.
(defn my-reverse [xs]
  (loop [[r & more :as all] (seq xs)
         acc '()]
    (if all
      (recur more (cons r acc))
      acc)))

(assert (= '(:d :c :b :a)
           (my-reverse '(:a :b :c :d))))

;; 5. Find out whether a list is a palindrome.
(defn is-palindrome? [xs]
  (if (= (seq xs) (into '() (seq xs)))
    true
    false))

(assert (= true
           (is-palindrome? '(:a :b :c :b :a))))

;; 6. Duplicate the elements of a list.
(defn duplicate [xs]
  (fn [xs] (sort (take (* 2 (count xs)) (cycle xs)))))

(assert (= '(:a :a :b :b :c :c)
           (duplicate '(:a :b :c))))

;; 7. Eliminate consecutive duplicates of a list.
(defn compress [xs]
   (into (list (into (sorted-set) [xs]))))

(assert (= '(:a :b :c)
           (compress '(:a :a :b :b :c :c))))

;; 8. Remove the N-th element of a list
(defn remove-at [xs n]
  (keep-indexed #(if (not= %1 n) %2) xs))

(assert (= '(:a :b :d :e)
           (remove-at '(:a :b :c :d :e) 2)))

;; 9. Insert a new element at the N-th position of a list.
(defn insert-at [x xs n]
  nil)

(assert (= '(:a :b :x :c :d)
           (insert-at :x '(:a :b :c :d) 2)))

;; 10. Create a list containing all integers within a given range.
(defn my-range [a b]
  (if (= a b)
    (cons a nil)
    (cons a (my-range (+ a 1) b))))

(assert (= '(3 4 5 6 7)
           (my-range 3 7)))

;; 11. Concatenate two lists
(defn my-concat [xs ys]
   (if (empty? (rest xs))
     (do
       (conj [xs] (first ys))
       (my-concat [xs] (rest ys))
       )
     (conj [xs] (first ys))))

(print (my-concat '(:a :b :c) '(:d :e :f)))
(assert (= '(:a :b :c :d :e :f)
           (my-concat '(:a :b :c) '(:d :e :f))))

;; 12. Split a list into two parts; the length of the first part is given.
(defn my-drop [xs n]
  nil)

(assert (= '(:d :e)
           (my-drop '(:a :b :c :d :e) 3)))

;; 13. Split a list into two parts; the length of the first part is given.
(defn my-take [xs n]
  nil)

(assert (= '(:a :b :c)
           (my-take '(:a :b :c :d :e) 3)))

;; 14. Implement the filtering function
(defn my-filter [p xs]
  (keep #(if (p %) %) xs))

(print (my-filter odd? '(1 2 3 4 5)))
(assert (= '(1 3 5)
           (my-filter odd? '(1 2 3 4 5))))

;; 15. Implement the mapping function
(defn my-map [f xs]
  nil)

(assert (= '(2 3 4 5 6)
           (my-map inc '(1 2 3 4 5))))

;; 16. Implement the reducing function
(defn my-reduce [f acc xs]
  nil)

(assert (= 15
           (my-reduce + 0 '(1 2 3 4 5))))

;; 17. Implement the flattening function
(defn my-flatten [xs]
  nil)

(assert (= '(:a :b :c :d :e)
           (my-flatten '(:a (:b (:c :d) :e)))))