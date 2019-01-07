(ns co.uk.redpixel.clock.core-test
  (:require [clojure.test :refer :all]
            [co.uk.redpixel.clock.core :refer :all])
  (:import (java.time LocalTime)))

(deftest speaking-time
  (testing "the outcome of speak time function"
    (are [time pronunciation] (= (speak time) pronunciation)
                              LocalTime/NOON "It's noon"
                              LocalTime/MIDNIGHT "It's midnight"
                              (LocalTime/of 1 0) "It's one o'clock"
                              (LocalTime/of 0 1) "It's one past midnight"
                              (LocalTime/of 11 0) "It's eleven o'clock"
                              (LocalTime/of 9 12) "It's twelve past nine"
                              (LocalTime/of 6 13) "It's thirteen past six"
                              (LocalTime/of 3 14) "It's fourteen past three"
                              (LocalTime/of 3 15) "It's quarter past three"
                              (LocalTime/of 4 16) "It's sixteen past four"
                              (LocalTime/of 17 17) "It's seventeen past five"
                              (LocalTime/of 20 18) "It's eighteen past eight"
                              (LocalTime/of 21 19) "It's nineteen past nine"
                              (LocalTime/of 10 20) "It's twenty past ten"
                              (LocalTime/of 6 25) "It's twenty five past six"
                              (LocalTime/of 8 30) "It's half past eight"
                              (LocalTime/of 6 33) "It's twenty seven to seven"
                              (LocalTime/of 3 50) "It's ten to four"
                              (LocalTime/of 1 45) "It's quarter to two")))
