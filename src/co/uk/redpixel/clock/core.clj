(ns co.uk.redpixel.clock.core
  (:import (java.time LocalTime)))

(def ^:private ones-placed-words {0  nil
                                  1  "one"
                                  2  "two"
                                  3  "three"
                                  4  "four"
                                  5  "five"
                                  6  "six"
                                  7  "seven"
                                  8  "eight"
                                  9  "nine"
                                  10 "ten"
                                  11 "eleven"
                                  12 "twelve"
                                  13 "thirteen"
                                  14 "fourteen"
                                  15 "quarter"
                                  16 "sixteen"
                                  17 "seventeen"
                                  18 "eighteen"
                                  19 "nineteen"})

(def ^:private tens-placed-words {20 "twenty" 30 "half"})

(defn- split-tens
  [minutes]
  (let [remainder (mod minutes 10)
        quotient (- minutes remainder)
        tens (get tens-placed-words quotient)
        ones (get ones-placed-words remainder)]
    (cond-> tens
            (not (nil? ones)) (str " " ones))))

(defn- map-minutes
  [minutes]
  (if-let [value (get ones-placed-words minutes)]
    value
    (split-tens minutes)))

(defn- map-hour
  [hour]
  (let [twelve-hour-clock-hour (cond-> hour (> hour 12) (- 12))]
    (if-let [value (get ones-placed-words twelve-hour-clock-hour)]
      value
      "midnight")))

(defn- is-half-past?
  [minutes]
  (> minutes 30))

(defn- calculate-remaining-minutes
  [past-minutes]
  (let [total-minutes-in-hour 60]
    (- total-minutes-in-hour past-minutes)))

(defn- calculate-next-hour
  [current-hour]
  (cond-> 0
          (not= current-hour 12) (+ current-hour)
          :always inc))

(defn speak
  "Says the time in English"
  [time]
  (str "It's "
       (cond
         (= time LocalTime/MIDNIGHT) "midnight"
         (= time LocalTime/NOON) "noon"
         :else (do
                 (let [minutes (.getMinute time)
                       hour (.getHour time)]
                   (cond
                     (zero? minutes) (format "%s o'clock" (map-hour hour))
                     (is-half-past? minutes)
                     (format "%s to %s"
                             (map-minutes (calculate-remaining-minutes minutes))
                             (map-hour (calculate-next-hour hour)))
                     :else (format "%s past %s"
                                   (map-minutes minutes)
                                   (map-hour hour))))))))