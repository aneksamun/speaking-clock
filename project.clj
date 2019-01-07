(defproject speaking-clock "1.0.0"
  :description "Tells time in English"
  :url "https://github.com/aneksamun/speaking-clock"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :aot [co.uk.redpixel.clock.application]
  :main co.uk.redpixel.clock.application)
