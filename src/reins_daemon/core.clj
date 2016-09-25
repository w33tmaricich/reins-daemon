(ns reins-daemon.core
  (:gen-class))

(def config (atom {}))

(defn -main
  "Listen for agents and act on them if they have the proper credentials."
  [& args]
  ; TODO: Configure the daemon based upon a config file.
  ; TODO: Listen for data coming over a given port number.
  ; TODO: Create a new thread when data is recieved.
  ; TODO: Extract the agent from the message.
  ; TODO: Check to see if the agent has privledges to run.
  ; TODO: Run the agent.
  (println "Hello, World!"))
