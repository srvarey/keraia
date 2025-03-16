;; ******************************************************************
;; KERAIA Naval Scenario - Full CLIPS Implementation
;; Implements Rule-Based Systems Matching the KERAIA Naval Framework
;; ******************************************************************

;; ***************************************
;; FACT DEFINITIONS (17): KS-TR1 to KS-FC3
;; ***************************************
(deftemplate Threat
  (slot id)
  (slot type)
  (slot status)
  (slot confidence)
  (slot location))

(deftemplate Fleet
  (slot id)
  (slot readiness)
  (slot deploymentStatus)
  (slot position))

(deftemplate Sensor
  (slot id)
  (slot type)
  (slot reliability)
  (slot detectionStatus))

(deftemplate Command
  (slot id)
  (slot action))

(deftemplate Intelligence
  (slot id)
  (slot confidence)
  (slot verificationStatus))

;; ***************************************
;; INITIAL FACTS (17): KS-TR1 to KS-FC3
;; ***************************************
(deffacts initial-facts
  ;; Threats (KS-TR1 to KS-TR5)
  (Threat (id KS-TR1) (type Submarine) (status Unconfirmed) (confidence 40) (location ZoneA))
  (Threat (id KS-TR2) (type Aircraft) (status Confirmed) (confidence 75) (location ZoneB))
  (Threat (id KS-TR3) (type SurfaceShip) (status Confirmed) (confidence 85) (location ZoneC))
  (Threat (id KS-TR4) (type Missile) (status Unconfirmed) (confidence 50) (location ZoneD))
  (Threat (id KS-TR5) (type UAV) (status Confirmed) (confidence 90) (location ZoneE))

  ;; Fleets (KS-TR6 to KS-TR8)
  (Fleet (id KS-TR6) (readiness High) (deploymentStatus Active) (position Forward))
  (Fleet (id KS-TR7) (readiness Medium) (deploymentStatus Standby) (position Defensive))
  (Fleet (id KS-TR8) (readiness Low) (deploymentStatus AwaitingOrders) (position Retreating))

  ;; Sensors (KS-TR9 to KS-TR11)
  (Sensor (id KS-TR9) (type Radar) (reliability 90) (detectionStatus Active))
  (Sensor (id KS-TR10) (type Sonar) (reliability 85) (detectionStatus Active))
  (Sensor (id KS-TR11) (type Infrared) (reliability 80) (detectionStatus Passive))

  ;; Commands (KS-TR12 to KS-TR14)
  (Command (id KS-TR12) (action AwaitingOrders))
  (Command (id KS-TR13) (action WeaponsSafe))
  (Command (id KS-TR14) (action EngagementApproved))

  ;; Intelligence Reports (KS-TR15 to KS-TR17)
  (Intelligence (id KS-TR15) (confidence High) (verificationStatus Verified))
  (Intelligence (id KS-TR16) (confidence Medium) (verificationStatus Pending))
  (Intelligence (id KS-TR17) (confidence Low) (verificationStatus Unverified))
)

;; ***************************************
;; RULE DEFINITIONS (15)
;; ***************************************
(defrule classify-submarine ;; Rule #1
  (Threat (id ?id) (type Submarine) (confidence ?c&:(< ?c 50)))
  =>
  (modify ?id (status HighRisk)))

(defrule classify-aircraft ;; Rule #2
  (Threat (id ?id) (type Aircraft))
  =>
  (modify ?id (status ModerateRisk)))

(defrule escalate-threat ;; Rule #3
  (Threat (id ?id) (status HighRisk) (confidence ?c&:(> ?c 80)))
  =>
  (modify ?id (status Critical)))

(defrule verify-intelligence ;; Rule #4
  (Intelligence (id ?id) (verificationStatus Unverified))
  =>
  (modify ?id (verificationStatus Verified)))

(defrule update-fleet-status ;; Rule #5
  (Fleet (id ?fid) (readiness Low))
  =>
  (modify ?fid (deploymentStatus AwaitingOrders)))

(defrule radar-detection ;; Rule #6
  (Sensor (id ?sid) (type Radar) (detectionStatus Active))
  =>
  (assert (Threat (id NewThreat) (type Unknown) (status Detected))))

(defrule intelligence-correlation ;; Rule #7
  (Intelligence (id ?id) (confidence High))
  =>
  (assert (Threat (id VerifiedThreat) (type Classified) (status Confirmed))))

(defrule classify-missile ;; Rule #8
    (Threat (id ?id) (type Missile))
    =>
    (modify ?id (status HighAlert))
)

(defrule update-fleet-position ;; Rule #9
    (Fleet (id ?fid) (deploymentStatus Active) (position Defensive))
    =>
    (modify ?fid (position Patrol))
)

(defrule sonar-detection ;; Rule #10
    (Sensor (id ?sid) (type Sonar) (detectionStatus Active))
    =>
    (assert (Threat (id NewThreat2) (type Underwater) (status Detected)))
)

(defrule correlate-threat-location ;; Rule #11
    (Threat (id ?tid) (status Detected) (location ?loc))
    (Threat (id ?tid2) (status Unconfirmed) (location ?loc))
    =>
    (modify ?tid2 (status Confirmed))
)

(defrule adjust-fleet-readiness ;; Rule #12
    (Fleet (id ?fid) (readiness Medium) (deploymentStatus Active))
    =>
    (modify ?fid (readiness High))
)

(defrule handle-uav-threat ;; Rule #13
    (Threat (id ?tid) (type UAV) (status Confirmed))
    =>
    (assert (Command (id IssueCommand) (action DeployCountermeasures)))
)

(defrule approve-engagement ;; Rule #14
    (Command (id ?cid) (action EngagementApproved))
    (Threat (id ?tid) (status Critical))
    =>
    (assert (Command (id ExecuteEngagement) (action Engage)))
)

(defrule process-intelligence ;; Rule #15
    (Intelligence (id ?iid) (confidence Medium) (verificationStatus Pending))
    =>
    (modify ?iid (verificationStatus Verified))
)

;; ***************************************
;; INFERENCE STEPS (18)
;; ***************************************
(defrule inference-step-1 ;; Step #1
  (Sensor (id ?id) (detectionStatus Active))
  =>
  (printout t "Inference Step #1: Sensor activation confirmed." crlf))

(defrule inference-step-2 ;; Step #2
  (Threat (id ?id) (confidence ?c&:(> ?c 60)))
  =>
  (printout t "Inference Step #2: Threat above confidence threshold." crlf))

(defrule inference-step-3 ;; Step #3
  (Threat (id ?id) (status HighRisk))
  =>
  (printout t "Inference Step #3: Threat escalation evaluated." crlf))

(defrule inference-step-4 ;; Step #4
    (Threat (id ?id) (type Submarine))
    =>
    (printout t "Inference Step #4: Submarine threat identified." crlf)
)

(defrule inference-step-5 ;; Step #5
    (Fleet (id ?id) (readiness Medium))
    =>
    (printout t "Inference Step #5: Fleet readiness check." crlf)
)

(defrule inference-step-6 ;; Step #6
    (Sensor (id ?id) (type Sonar))
    =>
    (printout t "Inference Step #6: Sonar sensor check." crlf)
)

(defrule inference-step-7 ;; Step #7
    (Intelligence (id ?id) (confidence Medium))
    =>
    (printout t "Inference Step #7: Intelligence confidence check." crlf)
)

(defrule inference-step-8 ;; Step #8
    (Threat (id ?id) (status Confirmed))
    =>
    (printout t "Inference Step #8: Threat confirmation step." crlf)
)

(defrule inference-step-9 ;; Step #9
    (Fleet (id ?id) (deploymentStatus Active))
    =>
    (printout t "Inference Step #9: Fleet deployment status check." crlf)
)

(defrule inference-step-10 ;; Step #10
    (Command (id ?id) (action AwaitingOrders))
    =>
    (printout t "Inference Step #10: Command status check." crlf)
)

(defrule inference-step-11 ;; Step #11
    (Threat (id ?id) (type Missile))
    =>
    (printout t "Inference Step #11: Missile threat identified." crlf)
)

(defrule inference-step-12 ;; Step #12
    (Fleet (id ?id) (position Defensive))
    =>
    (printout t "Inference Step #12: Fleet position check." crlf)
)

(defrule inference-step-13 ;; Step #13
    (Sensor (id ?id) (type Infrared))
    =>
    (printout t "Inference Step #13: Infrared sensor check." crlf)
)

(defrule inference-step-14 ;; Step #14
    (Intelligence (id ?id) (verificationStatus Verified))
    =>
    (printout t "Inference Step #14: Intelligence verification check." crlf)
)

(defrule inference-step-15 ;; Step #15
    (Threat (id ?id) (type UAV))
    =>
    (printout t "Inference Step #15: UAV threat identified." crlf)
)

(defrule inference-step-16 ;; Step #16
    (Fleet (id ?id) (readiness High))
    =>
    (printout t "Inference Step #16: High fleet readiness check." crlf)
)

(defrule inference-step-17 ;; Step #17
    (Command (id ?id) (action WeaponsSafe))
    =>
    (printout t "Inference Step #17: Weapons status check." crlf)
)

(defrule inference-step-18 ;; Step #18
    (Threat (id ?id) (location ZoneA))
    =>
    (printout t "Inference Step #18: Threat location check." crlf)
)

;; ***************************************
;; RULE-TO-FACT LINKS (6)
;; ***************************************
(defrule update-threat-status ;; Link #1
  (Threat (id ?id) (status HighRisk))
  =>
  (modify ?id (status Critical)))

(defrule update-fleet-deployment ;; Link #2
  (Fleet (id ?fid) (readiness Medium))
  =>
  (modify ?fid (deploymentStatus Active)))

(defrule link-threat-to-command ;; Link #3
    (Threat (id ?tid) (status Critical))
    =>
    (assert (Command (id IssueAttack) (action Attack)))
)

(defrule link-sensor-to-threat ;; Link #4
    (Sensor (id ?sid) (detectionStatus Active))
    =>
    (assert (Threat (id SensorThreat) (type Unknown) (status Detected)))
)

(defrule link-intelligence-to-threat ;; Link #5
    (Intelligence (id ?iid) (confidence High))
    =>
    (assert (Threat (id IntelThreat) (type Classified) (status Confirmed)))
)

(defrule link-fleet-to-command ;; Link #6
    (Fleet (id ?fid) (deploymentStatus Active))
    =>
    (assert (Command (id FleetCommand) (action Deploy)))
)

;; ***************************************
;; SELF-OPTIMIZING THREAT IDENTIFICATION (3)
;; ***************************************
(defrule adjust-threat-confidence ;; Self-Optimizing #1
  (Threat (id ?id) (status Critical))
  =>
  (modify ?id (confidence (+ (confidence ?id) 10))))

(defrule refine-sensor-weights ;; Self-Optimizing #2
  (Sensor (id ?id) (reliability ?r&:(< ?r 80)))
  =>
  (modify ?id (reliability (+ ?r 5))))

(defrule optimize-intelligence ;; Self-Optimizing #3
  (Intelligence (id ?id) (verificationStatus Verified))
  =>
  (modify ?id (confidence (+ (confidence ?id) 5))))

;; ***************************************
;; GRAPH-BASED DECISION ADAPTATION (2)
;; ***************************************
(defrule adapt-fleet-movement ;; Adaptation #1
  (Fleet (id ?id))
  =>
  (modify ?id (position AdjustedDeployment)))

(defrule modify-patrol-strategy ;; Adaptation #2
  (Fleet (id ?id))
  =>
  (modify ?id (position ModifiedPatrolRoute))):wq

