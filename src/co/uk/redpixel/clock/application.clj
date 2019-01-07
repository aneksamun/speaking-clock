(ns co.uk.redpixel.clock.application
  (:require [co.uk.redpixel.clock.core :refer :all])
  (:import (java.time LocalTime)
           (java.time.format DateTimeFormatter DateTimeParseException))
  (:gen-class))

(def time-format "HH:mm")

(defn- parse-time
  [arg]
  (let [format (DateTimeFormatter/ofPattern time-format)]
    (LocalTime/parse arg format)))

(defn -main
  [& args]
  (if-let [arg (first args)]
    (try
      (println (speak (parse-time arg)))
      (catch DateTimeParseException _
        (printf "The '%s' is not valid time. Requires a value of %s format." arg time-format))
      (catch Exception e (printf "An error occurred: %s" (.getMessage e))))
    (do
      (println "usage: speaking-clock [time]")
      (println (str "\n" "arguments:"))
      (println (str "\t" "time: time in format of " time-format)))))
