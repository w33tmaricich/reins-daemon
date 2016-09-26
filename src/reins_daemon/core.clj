(ns reins-daemon.core
  (:require [reins-daemon.configuration :as c])
  (:import [java.net ServerSocket]
           [java.io DataInputStream BufferedInputStream])
  (:gen-class))

(def config (atom nil))

(defn incoming-connection
  "Retrieves information coming over a port."
  [socket]
  (-> socket .accept .getInputStream BufferedInputStream. DataInputStream.))

(defn extract-agent
  "Retrieves an agent from a connection."
  [connection]
  (-> connection .readUTF read-string eval))

(defn -main
  "Listen for agents and act on them if they have the proper credentials."
  [& args]
  ; Create the application state and setup a server socket.
  (let [state (c/create-state)
        socket (ServerSocket. (:port state))]
    ; Listen for data coming over a given port number.
    (loop [connection (incoming-connection socket)]
      ; TODO: Create a new thread when data is recieved.
      ; Extract the agent from the message.
      (if-let [mobile-agent (extract-agent connection)]
      ; TODO: Check to see if the agent has privledges to run.
      ; TODO: Run the agent.
        (.close connection)
        (.close connection))
      (recur (incoming-connection socket)))))
