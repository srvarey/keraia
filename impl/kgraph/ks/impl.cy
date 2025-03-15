CREATE (:KnowledgeSource {name: "KS-TR1", type: "knowledge source", status: "active", 
                          detection_capability: "radar", range: "100 nautical miles"}),

       (:KnowledgeSource {name: "KS-TR2", type: "knowledge source", sensor_range: "5 nautical miles", 
                          detection_mode: "passive/active"}),

       (:KnowledgeSource {name: "KS-TR3", type: "knowledge source", confirmed_tracks: 3, 
                          tracking_algorithm: "Kalman filter"}),

       (:KnowledgeSource {name: "KS-TR4", type: "knowledge source", recent_sightings: "enemy submarine detected", 
                          confidence_level: "80%"}),

       (:KnowledgeSource {name: "KS-TR5", type: "knowledge source", rules_of_engagement: "Engage if confirmed hostile"}),

       (:KnowledgeSource {name: "KS-OR1", type: "knowledge source", status: "combat ready",
                          fuel_levels: "80%", ammunition: "90%"}),

       (:KnowledgeSource {name: "KS-OR2", type: "knowledge source", radar: "operational", 
                          sonobuoy_network: "functional"}),

       (:KnowledgeSource {name: "KS-OR3", type: "knowledge source", fatigue_level: "low", 
                          crew_rotation: "scheduled"}),

       (:KnowledgeSource {name: "KS-SF1", type: "knowledge source", detection: "acoustic anomaly", confidence: "50%"}),

       (:KnowledgeSource {name: "KS-SF2", type: "knowledge source", detection: "object at 50m depth", 
                          classification: "unknown"}),

       (:KnowledgeSource {name: "KS-SF3", type: "knowledge source", fusion_algorithm: "Bayesian Inference",
                          combined_confidence: "75%"}),

       (:KnowledgeSource {name: "KS-EC1", type: "knowledge source", known_signatures: "Type-212 Submarine, Kilo-Class"}),

       (:KnowledgeSource {name: "KS-EC2", type: "knowledge source", acoustic_signature: "unknown", depth: "300m"}),

       (:KnowledgeSource {name: "KS-EC3", type: "knowledge source", classification: "pending", decision_threshold: "90%"}),

       (:KnowledgeSource {name: "KS-FC1", type: "knowledge source", current_formation: "defensive perimeter"}),

       (:KnowledgeSource {name: "KS-FC2", type: "knowledge source", threat_level: "high", recommended_action: "disperse"}),


