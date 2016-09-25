(ns reins-daemon.core-test
  (:require [clojure.test :refer :all]
            [reins-daemon.configuration :as config]
            [reins-daemon.core :refer :all]))

(def daemon-test {:host "10.0.0.8"
                  :port 1612})

(deftest configuration-test
  (testing "Grabbing the ip address of the current machine."
    (is (= "10.0.0.8"
           config/host-ip)))
  (testing "Creating a configuration atom."
    (is (= daemon-test
           (config/create-state)))))
