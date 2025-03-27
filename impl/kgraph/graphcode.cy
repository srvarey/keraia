// Knowledge Sources (KS) Nodes
CREATE (:KnowledgeSource {id:"KS-TR1", type:"KS", description:"Radar detection capability"}) // Object #1
CREATE (:KnowledgeSource {id:"KS-TR2", type:"KS", description:"Sonobuoy detection mode"}) // Object #2
CREATE (:KnowledgeSource {id:"KS-TR3", type:"KS", description:"Tracking algorithms"}) // Object #3
CREATE (:KnowledgeSource {id:"KS-TR4", type:"KS", description:"Confirmed sightings"}) // Object #4
CREATE (:KnowledgeSource {id:"KS-TR5", type:"KS", description:"Rules of engagement"}) // Object #5
CREATE (:KnowledgeSource {id:"KS-OR1", type:"KS", description:"Fleet operational status"}) // Object #6
CREATE (:KnowledgeSource {id:"KS-OR2", type:"KS", description:"Equipment readiness"}) // Object #7
CREATE (:KnowledgeSource {id:"KS-OR3", type:"KS", description:"Crew fatigue and rotation"}) // Object #8
CREATE (:KnowledgeSource {id:"KS-SF1", type:"KS", description:"Sensor fusion acoustic anomaly"}) // Object #9
CREATE (:KnowledgeSource {id:"KS-SF2", type:"KS", description:"Sensor fusion depth detection"}) // Object #10
CREATE (:KnowledgeSource {id:"KS-SF3", type:"KS", description:"Bayesian sensor fusion"}) // Object #11
CREATE (:KnowledgeSource {id:"KS-EC1", type:"KS", description:"Known enemy signatures"}) // Object #12
CREATE (:KnowledgeSource {id:"KS-EC2", type:"KS", description:"Unknown acoustic signature"}) // Object #13
CREATE (:KnowledgeSource {id:"KS-EC3", type:"KS", description:"Pending classification threshold"}) // Object #14
CREATE (:KnowledgeSource {id:"KS-FC1", type:"KS", description:"Fleet current formation"}) // Object #15
CREATE (:KnowledgeSource {id:"KS-FC2", type:"KS", description:"Recommended fleet action"}) // Object #16
CREATE (:KnowledgeSource {id:"KS-FC3", type:"KS", description:"Tactical decision model"}) // Object #17
// === CLOUD NODES ===

// Cloud #1: Threat Response Cloud
CREATE (cloud1:Cloud {id: "Threat Response Cloud", description: "Dynamic cluster of KS for threat response"}) // Object #18

// Cloud #2: Operational Readiness Cloud
CREATE (cloud2:Cloud {id: "Operational Readiness Cloud", description: "Cluster of KS for operational readiness"}) // Object #19

// Cloud #3: Sensor Fusion Cloud
CREATE (cloud3:Cloud {id: "Sensor Fusion Cloud", description: "Cluster of KS for sensor fusion processes"}) // Object #20

// Cloud #4: Enemy Classification Cloud
CREATE (cloud4:Cloud {id: "Enemy Classification Cloud", description: "Cluster of KS for enemy classification"}) // Object #21

// Cloud #5: Fleet Coordination Cloud
CREATE (cloud5:Cloud {id: "Fleet Coordination Cloud", description: "Cluster of KS for fleet coordination"}) // Object #22

// === CLOUD RELATIONSHIPS ===

// Threat Response Cloud to KS (Objects #23 to #27)
MATCH (c:Cloud {id: "Threat Response Cloud"})
MATCH (ks1:KS {id: "KS-TR1"}), (ks2:KS {id: "KS-TR2"}), (ks3:KS {id: "KS-TR3"}),
      (ks4:KS {id: "KS-TR4"}), (ks5:KS {id: "KS-TR5"})
CREATE (c)-[:INCLUDES_KS]->(ks1),   // Relation #1
       (c)-[:INCLUDES_KS]->(ks2),   // Relation #2
       (c)-[:INCLUDES_KS]->(ks3),   // Relation #3
       (c)-[:INCLUDES_KS]->(ks4),   // Relation #4
       (c)-[:INCLUDES_KS]->(ks5)    // Relation #5

// Operational Readiness Cloud to KS (Objects #28 to #30)
MATCH (c:Cloud {id: "Operational Readiness Cloud"})
MATCH (ks1:KS {id: "KS-OR1"}), (ks2:KS {id: "KS-OR2"}), (ks3:KS {id: "KS-OR3"})
CREATE (c)-[:INCLUDES_KS]->(ks1),   // Relation #6
       (c)-[:INCLUDES_KS]->(ks2),   // Relation #7
       (c)-[:INCLUDES_KS]->(ks3)    // Relation #8

// Sensor Fusion Cloud to KS (Objects #31 to #33)
MATCH (c:Cloud {id: "Sensor Fusion Cloud"})
MATCH (ks1:KS {id: "KS-SF1"}), (ks2:KS {id: "KS-SF2"}), (ks3:KS {id: "KS-SF3"})
CREATE (c)-[:INCLUDES_KS]->(ks1),   // Relation #9
       (c)-[:INCLUDES_KS]->(ks2),   // Relation #10
       (c)-[:INCLUDES_KS]->(ks3)    // Relation #11

// Enemy Classification Cloud to KS (Objects #34 to #36)
MATCH (c:Cloud {id: "Enemy Classification Cloud"})
MATCH (ks1:KS {id: "KS-EC1"}), (ks2:KS {id: "KS-EC2"}), (ks3:KS {id: "KS-EC3"})
CREATE (c)-[:INCLUDES_KS]->(ks1),   // Relation #12
       (c)-[:INCLUDES_KS]->(ks2),   // Relation #13
       (c)-[:INCLUDES_KS]->(ks3)    // Relation #14

// Fleet Coordination Cloud to KS (Objects #37 to #39)
MATCH (c:Cloud {id: "Fleet Coordination Cloud"})
MATCH (ks1:KS {id: "KS-FC1"}), (ks2:KS {id: "KS-FC2"}), (ks3:KS {id: "KS-FC3"})
CREATE (c)-[:INCLUDES_KS]->(ks1),   // Relation #15
       (c)-[:INCLUDES_KS]->(ks2),   // Relation #16
       (c)-[:INCLUDES_KS]->(ks3)    // Relation #17

// Lines of Thought (LoT) Nodes and explicit KS links as Linked Lists

// LoT-Threat Detection and Classification
CREATE (lot1:LoT {id:"LoT-ThreatDetection-Step1", description:"Initial Detection"}) // Object #40
CREATE (ks_tr1:KS {id:"KS-TR1"}) // Object #41
CREATE (ks_tr2:KS {id:"KS-TR2"}) // Object #42
CREATE (lot1)-[:HAS_KS]->(ks_tr1) // Object #43
CREATE (ks_tr1)-[:NEXT_KS]->(ks_tr2) // Object #44

CREATE (lot2:LoT {id:"LoT-ThreatTracking-Step2", description:"Tracking and Fusion"}) // Object #45
CREATE (ks_tr3:KS {id:"KS-TR3"}) // Object 46
CREATE (ks_sf1:KS {id:"KS-SF1"}) // Object #47
CREATE (ks_sf2:KS {id:"KS-SF2"}) // Object #48
CREATE (lot2)-[:HAS_KS]->(ks_tr3) // Object #49
CREATE (ks_tr3)-[:NEXT_KS]->(ks_sf1) // Object #50
CREATE (ks_sf1)-[:NEXT_KS]->(ks_sf2) // Object #51

CREATE (lot3:LoT {id:"LoT-Classification-Step3", description:"Threat Classification"}) // Object #52
CREATE (ks_ec1:KS {id:"KS-EC1"}) // Object #53
CREATE (ks_ec2:KS {id:"KS-EC2"}) // Object #54
CREATE (ks_ec3:KS {id:"KS-EC3"}) // Object #55
CREATE (lot3)-[:HAS_KS]->(ks_ec1) // Object #56
CREATE (ks_ec1)-[:NEXT_KS]->(ks_ec2) // Object #57
CREATE (ks_ec2)-[:NEXT_KS]->(ks_ec3) // Object #58

// LoT-Operational Readiness Assessment
CREATE (lot4:LoT {id:"LoT-OperationalReadiness-Step1", description:"Fleet Operational Status"}) // Object #59
CREATE (ks_or1:KS {id:"KS-OR1"}) // Object #60
CREATE (ks_or2:KS {id:"KS-OR2"}) // Object #61
CREATE (ks_or3:KS {id:"KS-OR3"}) // Object #62
CREATE (lot4)-[:HAS_KS]->(ks_or1) // Object #63
CREATE (ks_or1)-[:NEXT_KS]->(ks_or2) // Object #64
CREATE (ks_or2)-[:NEXT_KS]->(ks_or3) // Object #65

CREATE (lot5:LoT {id:"LoT-OperationalReadiness-Step2", description:"Mission Feasibility Analysis"}) // Object #66
CREATE (ks_fc1:KS {id:"KS-FC1"}) // Object #67
CREATE (ks_fc2:KS {id:"KS-FC2"}) // Object #68
CREATE (lot5)-[:HAS_KS]->(ks_fc1) // Object #69
CREATE (ks_fc1)-[:NEXT_KS]->(ks_fc2) // Object #70

CREATE (lot6:LoT {id:"LoT-OperationalReadiness-Step3", description:"Final Decision and Execution"}) // Object #71
CREATE (ks_fc3:KS {id:"KS-FC3"}) // Object #72
CREATE (ks_tr5:KS {id:"KS-TR5"}) // Object #73
CREATE (lot6)-[:HAS_KS]->(ks_fc3)  // Object #74
CREATE (ks_fc3)-[:NEXT_KS]->(ks_tr5) // Object #75

// Junctures
CREATE (:Juncture {id:"Threat Detection Juncture"}) // Object #76
CREATE (:Juncture {id:"Threat Classification Juncture"}) // Object #77
CREATE (:Juncture {id:"Sensor Fusion Juncture"}) // Object #78
CREATE (:Juncture {id:"Operational Readiness Juncture"}) // Object #79
CREATE (:Juncture {id:"Tactical Decision Making Juncture"}) // Object #80
CREATE (:Juncture {id:"Fleet Coordination Juncture"}) // Object #81

// Dimensions
CREATE (:Dimension {id:"Sensor Data Processing"}) // Object #82
CREATE (:Dimension {id:"Threat Evaluation"}) // Object #83
CREATE (:Dimension {id:"Multi-Sensor Integration"}) // Object #84
CREATE (:Dimension {id:"Readiness Assessment"}) // Object #85
CREATE (:Dimension {id:"Decision Execution"}) // Object #86
CREATE (:Dimension {id:"Fleet Adaptation"}) // Object #87

// Cloud associations (Relations #1-5)
MATCH (c:Cloud {id:"Threat Response Cloud"}), (ks:KnowledgeSource)
WHERE ks.id IN ["KS-TR1","KS-TR2","KS-TR3","KS-TR4","KS-TR5"]
CREATE (c)-[:CONTAINS]->(ks); // Object #88



// Dynamic Relations (DRels) explicitly modeled with forward and inverse relationships:

// ======= Dynamic Relations (DRels) =======

// DRel #1: sensorFusion
CREATE (:DynamicRelation {id:"sensorFusion"})  // Object #89
CREATE (:DynamicRelation {id:"feedsDetection"})  // Object #90
CREATE (:DynamicRelation {id:"sensorFusion"})-[:INTEGRATES]->(:KnowledgeSource {id:"KS-SF1"}) // DRel Relation #1 (forward)
CREATE (:KnowledgeSource {id:"KS-SF1"})-[:FEEDS_DETECTION]->(:DynamicRelation {id:"feedsDetection"}) // DRel Relation #2 (inverse)

// DRel #2: sensorConfidence
CREATE (:DynamicRelation {id:"sensorConfidence"})  // Object #91
CREATE (:DynamicRelation {id:"feedsConfidence"}) // Object #92
CREATE (:DynamicRelation {id:"sensorConfidence"})-[:AGGREGATES_CONFIDENCE]->(:KnowledgeSource {id:"KS-SF2"}) // DRel Relation #3 (forward)
CREATE (:KnowledgeSource {id:"KS-SF2"})-[:FEEDS_CONFIDENCE]->(:DynamicRelation {id:"feedsConfidence"}) // DRel Relation #4 (inverse)

// DRel #3: fleetOperationalStatus
CREATE (:DynamicRelation {id:"fleetOperationalStatus"})  // Object #93
CREATE (:DynamicRelation {id:"equipmentStatusFeed"}) // Object #94
CREATE (:DynamicRelation {id:"fleetOperationalStatus"})-[:UPDATES_STATUS]->(:KnowledgeSource {id:"KS-OR1"}) // DRel Relation #5 (forward)
CREATE (:KnowledgeSource {id:"KS-OR1"})-[:FEEDS_EQUIPMENT_STATUS]->(:DynamicRelation {id:"equipmentStatusFeed"}) // DRel Relation #6 (inverse)

// DRel #4: fleetCrewFatigue
CREATE (:DynamicRelation {id:"fleetCrewFatigue"}) // Object #95
CREATE (:DynamicRelation {id:"crewFatigueFeed"}) // Object #96
CREATE (:DynamicRelation {id:"fleetCrewFatigue"})-[:UPDATES_FATIGUE_LEVEL]->(:KnowledgeSource {id:"KS-OR3"}) // DRel Relation #7 (forward)
CREATE (:KnowledgeSource {id:"KS-OR3"})-[:FEEDS_FATIGUE]->(:DynamicRelation {id:"crewFatigueFeed"}) // DRel Relation #8 (inverse)

// DRel #5: threatClassification
CREATE (:DynamicRelation {id:"threatClassification"}) // Object #97
CREATE (:DynamicRelation {id:"informsThreat"}) // Object #98
CREATE (:DynamicRelation {id:"threatClassification"})-[:CLASSIFIES_THREAT]->(:KnowledgeSource {id:"KS-EC1"}) // DRel Relation #9 (forward)
CREATE (:KnowledgeSource {id:"KS-EC1"})-[:INFORMS_THREAT]->(:DynamicRelation {id:"informsThreat"}) // DRel Relation #10 (inverse)

// DRel #6: engagementDecision
CREATE (:DynamicRelation {id:"engagementDecision"}) // Object #99
CREATE (:DynamicRelation {id:"informsEngagement"}) // Object #100
CREATE (:DynamicRelation {id:"engagementDecision"})-[:DETERMINES_ENGAGEMENT]->(:KnowledgeSource {id:"KS-TR5"}) // DRel Relation #11 (forward)
CREATE (:KnowledgeSource {id:"KS-TR5"})-[:INFORMS_ENGAGEMENT]->(:DynamicRelation {id:"informsEngagement"}) // DRel Relation #12 (inverse)


// Keraia Properties explicitly modeled (Properties #1-59)

// Property #1: classification
CREATE (p1:Property {name: "classification"})
WITH p1 MATCH (ks:KnowledgeSource) WHERE ks.id IN ["KS-SF2","KS-EC3","KS-EC1","KS-EC2","KS-TR4","KS-TR5"]
CREATE (ks)-[:HAS_PROPERTY]->(p1)
WITH p1 MATCH (lot:LoT {id:"LoT-Threat-Detection-and-Classification"}) CREATE (lot)-[:HAS_PROPERTY]->(p1)

// Property #2: combined confidence
CREATE (p2:Property {name: "combined confidence"})
WITH p2 MATCH (ks:KnowledgeSource {id:"KS-SF3"}) CREATE (ks)-[:HAS_PROPERTY]->(p2)

// Property #3: confidence level
CREATE (p3:Property {name: "confidence level"})
WITH p3 MATCH (ks:KnowledgeSource {id:"KS-TR4"}) CREATE (ks)-[:HAS_PROPERTY]->(p3)

// Property #4: confirmed tracks
CREATE (p4:Property {name: "confirmed tracks"})
WITH p4 MATCH (ks:KnowledgeSource {id:"KS-TR3"}) CREATE (ks)-[:HAS_PROPERTY]->(p4)

// Property #5: decision threshold
CREATE (p5:Property {name: "decision threshold"})
WITH p5 MATCH (ks:KnowledgeSource {id:"KS-EC3"}) CREATE (ks)-[:HAS_PROPERTY]->(p5)

// Property #6: detection capability
CREATE (p6:Property {name: "detection capability"})
WITH p6 MATCH (ks:KnowledgeSource {id:"KS-TR1"}) CREATE (ks)-[:HAS_PROPERTY]->(p6)

// Property #7: detection mode
CREATE (p7:Property {name: "detection mode"})
WITH p7 MATCH (ks:KnowledgeSource {id:"KS-TR2"}) CREATE (ks)-[:HAS_PROPERTY]->(p7)

// Property #8: detection
CREATE (p8:Property {name: "detection"})
WITH p8 MATCH (ks:KnowledgeSource) WHERE ks.id IN ["KS-SF1","KS-SF2","KS-TR1","KS-TR2"]
CREATE (ks)-[:HAS_PROPERTY]->(p8)

// Property #9: formation
CREATE (p9:Property {name: "formation"})
WITH p9 MATCH (ks:KnowledgeSource {id:"KS-FC1"}) CREATE (ks)-[:HAS_PROPERTY]->(p9)

// Property #10: fusion algorithm
CREATE (p10:Property {name: "fusion algorithm"})
WITH p10 MATCH (ks:KnowledgeSource {id:"KS-SF3"}) CREATE (ks)-[:HAS_PROPERTY]->(p10)

// Property #11: maneuver strategy
CREATE (p11:Property {name: "maneuver strategy"})
WITH p11 MATCH (lot:LoT {id:"LoT-Fleet-Coordination-and-Threat-Response"}) CREATE (lot)-[:HAS_PROPERTY]->(p11)
// Properties explicitly defined (#12–#43)

// Property #12 - fusionAlgorithm
MATCH (ks:KnowledgeSource {id:"KS-SF3"})
SET ks.fusionAlgorithm = "Bayesian Inference";

// Property #13 - range
MATCH (ks:KnowledgeSource {id:"KS-TR1"})
SET ks.range = "100 nautical miles";

// Property #14 - recentSightings
MATCH (ks:KnowledgeSource {id:"KS-TR4"})
SET ks.recentSightings = "enemy submarine detected";

// Property #15 - recommendedAction
MATCH (ks:KnowledgeSource {id:"KS-FC2"})
SET ks.recommendedAction = "disperse";

// Property #16 - rulesOfEngagement
MATCH (ks:KnowledgeSource {id:"KS-TR5"})
SET ks.rulesOfEngagement = "Engage if confirmed hostile";

// Property #17 - sensorRange
MATCH (ks:KnowledgeSource {id:"KS-TR2"})
SET ks.sensorRange = "5 nautical miles";

// Property #18 - status
MATCH (ks:KnowledgeSource)
WHERE ks.id IN ["KS-OR1", "KS-TR1", "KS-TR5", "KS-OR2", "KS-OR3", "KS-FC1", "KS-FC2", "KS-FC3"]
SET ks.status = "active";

// Property #19 - threatLevel
MATCH (ks:KnowledgeSource)
WHERE ks.id IN ["KS-FC2", "KS-TR4"]
SET ks.threatLevel = "high";

// Property #20 - trackingAlgorithm
MATCH (ks:KnowledgeSource {id:"KS-TR3"})
SET ks.trackingAlgorithm = "Kalman filter";

// Property #21 - knownSignatures
MATCH (ks:KnowledgeSource {id:"KS-EC1"})
SET ks.knownSignatures = "Type-212 Submarine, Kilo-Class";

// Property #22 - operationalStatus
MATCH (ks:KnowledgeSource {id:"KS-OR1"})
SET ks.operationalStatus = "combat ready";

// Property #23 - crewFatigueLevel
MATCH (ks:KnowledgeSource {id:"KS-OR3"})
SET ks.crewFatigueLevel = "low";

// Property #24 - sensorAccuracy
MATCH (ks:KnowledgeSource)
WHERE ks.id IN ["KS-SF1", "KS-SF2"]
SET ks.sensorAccuracy = "85%";

// Property #25 - fleetFormation
MATCH (ks:KnowledgeSource)
WHERE ks.id IN ["KS-FC1", "KS-FC3"]
SET ks.fleetFormation = "defensive perimeter";

// Property #26 - threatAssessment
MATCH (ks:KnowledgeSource {id:"KS-FC2"})
SET ks.threatAssessment = "High";

// Property #27 - fuelLevels
MATCH (ks:KnowledgeSource {id:"KS-OR1"})
SET ks.fuelLevels = "80%";

// Property #28 - ammunition
MATCH (ks:KnowledgeSource {id:"KS-OR1"})
SET ks.ammunition = "90%";

// Property #29 - radar
MATCH (ks:KnowledgeSource {id:"KS-OR2"})
SET ks.radar = "operational";

// Property #30 - sonobuoyNetwork
MATCH (ks:KnowledgeSource {id:"KS-OR2"})
SET ks.sonobuoyNetwork = "functional";

// Property #31 - fatigueLevel
MATCH (ks:KnowledgeSource {id:"KS-OR3"})
SET ks.fatigueLevel = "low";

// Property #32 - crewRotation
MATCH (ks:KnowledgeSource {id:"KS-OR3"})
SET ks.crewRotation = "scheduled";

// Property #33 - confidence
MATCH (ks:KnowledgeSource {id:"KS-SF1"})
SET ks.confidence = "50%";

// Property #34 - acousticSignature
MATCH (ks:KnowledgeSource {id:"KS-EC2"})
SET ks.acousticSignature = "unknown";

// Property #35 - depth
MATCH (ks:KnowledgeSource {id:"KS-EC2"})
SET ks.depth = "300m";

// Property #36 - currentFormation
MATCH (ks:KnowledgeSource {id:"KS-FC1"})
SET ks.currentFormation = "defensive perimeter";

// Property #37 - decisionModel
MATCH (ks:KnowledgeSource {id:"KS-FC3"})
SET ks.decisionModel = "Markov Decision Process";

// Property #38 - step1 (Lines of Thought)
MATCH (lot:LoT {id:"lot_Threat_Detection_and_Classification"})
SET lot.step1 = "Initial Detection";

// Property #39 - step2 (Lines of Thought)
MATCH (lot:LoT {id:"lot_Threat_Detection_and_Classification"})
SET lot.step2 = "Tracking and Fusion";

// Property #40 - step3 (Lines of Thought)
MATCH (lot:LoT {id:"lot_Threat_Detection_and_Classification"})
SET lot.step3 = "Classification";

// Property #41 - step4 (Lines of Thought)
MATCH (lot:LoT {id:"lot_Threat_Detection_and_Classification"})
SET lot.step4 = "Decision Making";

// Property #42 - sensorDataProcessing (Dimension)
MATCH (dim:Dimension {id:"SensorDataProcessingDimension"})
SET dim.sensorDataProcessing = "active";

// Property #43 - threatEvaluation (Dimension)
MATCH (dim:Dimension {id:"ThreatEvaluationDimension"})
SET dim.threatEvaluation = "active";



// Property #44-47: step-1 to step-4
FOREACH (step IN ["step-1","step-2","step-3","step-4"] |
  CREATE (p:Property {name: step})
  WITH p, step MATCH (lot:LoT) WHERE lot.id IN ["LoT-Threat-Detection-and-Classification","LoT-Operational-Readiness-Assessment","LoT-Sensor-Fusion-for-Decision-Making","LoT-Fleet-Coordination-and-Threat-Response"]
  CREATE (lot)-[:HAS_PROPERTY]->(p)
)

// Properties #48-53: Junctures
UNWIND [
  ["Threat Detection", "Juncture"],
  ["Threat Classification", "Juncture"],
  ["Sensor Fusion for Threat Confirmation", "Juncture"],
  ["Operational Readiness Assessment", "Juncture"],
  ["Tactical Decision Making", "Juncture"],
  ["Fleet Coordination", "Juncture"]
] AS row
CREATE (p:JunctureProperty {name: row[0]})
WITH p MATCH (j:Juncture {id: row[0] + " Juncture"}) CREATE (j)-[:HAS_PROPERTY]->(p)

// Properties #54-59: Dimensions
UNWIND [
  ["Sensor Data Processing", "Dimension"],
  ["Threat Evaluation", "Dimension"],
  ["Multi-Sensor Integration", "Dimension"],
  ["Readiness Assessment", "Dimension"],
  ["Decision Execution", "Dimension"],
  ["Fleet Adaptation", "Dimension"]
] AS row
CREATE (p:DimensionProperty {name: row[0]})
WITH p MATCH (d:Dimension {id: row[0] + " Dimension"}) CREATE (d)-[:HAS_PROPERTY]->(p)




// === Final Updated Summary ===
// GRAND TOTALS explicitly modeled:
// Objects (Nodes): 100
// Properties: 59
// Relationships: 24



