(ns reins-daemon.configuration
  (:import [java.net NetworkInterface]))

(def config (create-struct :host :port))

(def host-ip
  (let [ifc (NetworkInterface/getNetworkInterfaces)
        ifsq (enumeration-seq ifc)
        ifmp (map #(bean %) ifsq)
        ipsq (filter #(false? (% :loopback)) ifmp)
        ipa (map :interfaceAddresses ipsq)
        ipaf (nth ipa 0)
        ipafs (.split (str ipaf) " ")
        ips (first (nnext ipafs))]
    (str (second (.split ips "/")))))

(defn create-state
  "Creates a hashmap that holds configuration information."
  ([]
   (create-state host-ip 1612))
  ([host port]
   (struct config host port)))
