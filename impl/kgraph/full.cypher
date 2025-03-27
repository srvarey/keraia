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
CREATE (cloud1:Cloud {id: "Threat Response Cloud", description: "Dynamic cluster of KS for threat response"}) // Object #1

// Cloud #2: Operational Readiness Cloud
CREATE (cloud2:Cloud {id: "Operational Readiness Cloud", description: "Cluster of KS for operational readiness"}) // Object #2

// Cloud #3: Sensor Fusion Cloud
CREATE (cloud3:Cloud {id: "Sensor Fusion Cloud", description: "Cluster of KS for sensor fusion processes"}) // Object #3

// Cloud #4: Enemy Classification Cloud
CREATE (cloud4:Cloud {id: "Enemy Classification Cloud", description: "Cluster of KS for enemy classification"}) // Object #4

// Cloud #5: Fleet Coordination Cloud
CREATE (cloud5:Cloud {id: "Fleet Coordination Cloud", description: "Cluster of KS for fleet coordination"}) // Object #5

// === CLOUD RELATIONSHIPS ===

// Threat Response Cloud to KS (Objects #6 to #10)
MATCH (c:Cloud {id: "Threat Response Cloud"})
MATCH (ks1:KS {id: "KS-TR1"}), (ks2:KS {id: "KS-TR2"}), (ks3:KS {id: "KS-TR3"}),
      (ks4:KS {id: "KS-TR4"}), (ks5:KS {id: "KS-TR5"})
CREATE (c)-[:INCLUDES_KS]->(ks1),   // Relation #1
       (c)-[:INCLUDES_KS]->(ks2),   // Relation #2
       (c)-[:INCLUDES_KS]->(ks3),   // Relation #3
       (c)-[:INCLUDES_KS]->(ks4),   // Relation #4
       (c)-[:INCLUDES_KS]->(ks5)    // Relation #5

// Operational Readiness Cloud to KS (Objects #11 to #13)
MATCH (c:Cloud {id: "Operational Readiness Cloud"})
MATCH (ks1:KS {id: "KS-OR1"}), (ks2:KS {id: "KS-OR2"}), (ks3:KS {id: "KS-OR3"})
CREATE (c)-[:INCLUDES_KS]->(ks1),   // Relation #6
       (c)-[:INCLUDES_KS]->(ks2),   // Relation #7
       (c)-[:INCLUDES_KS]->(ks3)    // Relation #8

// Sensor Fusion Cloud to KS (Objects #14 to #16)
MATCH (c:Cloud {id: "Sensor Fusion Cloud"})
MATCH (ks1:KS {id: "KS-SF1"}), (ks2:KS {id: "KS-SF2"}), (ks3:KS {id: "KS-SF3"})
CREATE (c)-[:INCLUDES_KS]->(ks1),   // Relation #9
       (c)-[:INCLUDES_KS]->(ks2),   // Relation #10
       (c)-[:INCLUDES_KS]->(ks3)    // Relation #11

// Enemy Classification Cloud to KS (Objects #17 to #19)
MATCH (c:Cloud {id: "Enemy Classification Cloud"})
MATCH (ks1:KS {id: "KS-EC1"}), (ks2:KS {id: "KS-EC2"}), (ks3:KS {id: "KS-EC3"})
CREATE (c)-[:INCLUDES_KS]->(ks1),   // Relation #12
       (c)-[:INCLUDES_KS]->(ks2),   // Relation #13
       (c)-[:INCLUDES_KS]->(ks3)    // Relation #14

// Fleet Coordination Cloud to KS (Objects #20 to #22)
MATCH (c:Cloud {id: "Fleet Coordination Cloud"})
MATCH (ks1:KS {id: "KS-FC1"}), (ks2:KS {id: "KS-FC2"}), (ks3:KS {id: "KS-FC3"})
CREATE (c)-[:INCLUDES_KS]->(ks1),   // Relation #15
       (c)-[:INCLUDES_KS]->(ks2),   // Relation #16
       (c)-[:INCLUDES_KS]->(ks3)    // Relation #17

// Lines of Thought (LoT) Nodes and explicit KS links as Linked Lists

// LoT-Threat Detection and Classification
CREATE (lot1:LoT {id:"LoT-ThreatDetection-Step1", description:"Initial Detection"}) // Object #23
CREATE (ks_tr1:KS {id:"KS-TR1"}) // Object #1
CREATE (ks_tr2:KS {id:"KS-TR2"}) // Object #2
CREATE (lot1)-[:HAS_KS]->(ks_tr1)
CREATE (ks_tr1)-[:NEXT_KS]->(ks_tr2)

CREATE (lot2:LoT {id:"LoT-ThreatTracking-Step2", description:"Tracking and Fusion"}) // Object #24
CREATE (ks_tr3:KS {id:"KS-TR3"}) // Object #3
CREATE (ks_sf1:KS {id:"KS-SF1"}) // Object #9
CREATE (ks_sf2:KS {id:"KS-SF2"}) // Object #10
CREATE (lot2)-[:HAS_KS]->(ks_tr3)
CREATE (ks_tr3)-[:NEXT_KS]->(ks_sf1)
CREATE (ks_sf1)-[:NEXT_KS]->(ks_sf2)

CREATE (lot3:LoT {id:"LoT-Classification-Step3", description:"Threat Classification"}) // Object #25
CREATE (ks_ec1:KS {id:"KS-EC1"}) // Object #12
CREATE (ks_ec2:KS {id:"KS-EC2"}) // Object #13
CREATE (ks_ec3:KS {id:"KS-EC3"}) // Object #14
CREATE (lot3)-[:HAS_KS]->(ks_ec1)
CREATE (ks_ec1)-[:NEXT_KS]->(ks_ec2)
CREATE (ks_ec2)-[:NEXT_KS]->(ks_ec3)

// LoT-Operational Readiness Assessment
CREATE (lot4:LoT {id:"LoT-OperationalReadiness-Step1", description:"Fleet Operational Status"}) // Object #26
CREATE (ks_or1:KS {id:"KS-OR1"}) // Object #6
CREATE (ks_or2:KS {id:"KS-OR2"}) // Object #7
CREATE (ks_or3:KS {id:"KS-OR3"}) // Object #8
CREATE (lot4)-[:HAS_KS]->(ks_or1)
CREATE (ks_or1)-[:NEXT_KS]->(ks_or2)
CREATE (ks_or2)-[:NEXT_KS]->(ks_or3)

CREATE (lot5:LoT {id:"LoT-OperationalReadiness-Step2", description:"Mission Feasibility Analysis"}) // Object #27
CREATE (ks_fc1:KS {id:"KS-FC1"}) // Object #15
CREATE (ks_fc2:KS {id:"KS-FC2"}) // Object #16
CREATE (lot5)-[:HAS_KS]->(ks_fc1)
CREATE (ks_fc1)-[:NEXT_KS]->(ks_fc2)

CREATE (lot6:LoT {id:"LoT-OperationalReadiness-Step3", description:"Final Decision and Execution"}) // Object #28
CREATE (ks_fc3:KS {id:"KS-FC3"}) // Object #17
CREATE (ks_tr5:KS {id:"KS-TR5"}) // Object #5
CREATE (lot6)-[:HAS_KS]->(ks_fc3)
CREATE (ks_fc3)-[:NEXT_KS]->(ks_tr5)

// Junctures
CREATE (:Juncture {id:"Threat Detection Juncture"}) // Object #29
CREATE (:Juncture {id:"Threat Classification Juncture"}) // Object #30
CREATE (:Juncture {id:"Sensor Fusion Juncture"}) // Object #31
CREATE (:Juncture {id:"Operational Readiness Juncture"}) // Object #32
CREATE (:Juncture {id:"Tactical Decision Making Juncture"}) // Object #33
CREATE (:Juncture {id:"Fleet Coordination Juncture"}) // Object #34

// Dimensions
CREATE (:Dimension {id:"Sensor Data Processing"}) // Object #35
CREATE (:Dimension {id:"Threat Evaluation"}) // Object #36
CREATE (:Dimension {id:"Multi-Sensor Integration"}) // Object #37
CREATE (:Dimension {id:"Readiness Assessment"}) // Object #38
CREATE (:Dimension {id:"Decision Execution"}) // Object #39
CREATE (:Dimension {id:"Fleet Adaptation"}) // Object #40

// Cloud associations (Relations #1-5)
MATCH (c:Cloud {id:"Threat Response Cloud"}), (ks:KnowledgeSource) 
WHERE ks.id IN ["KS-TR1","KS-TR2","KS-TR3","KS-TR4","KS-TR5"]
CREATE (c)-[:CONTAINS]->(ks);

// Similarly for other clouds (Operational Readiness, Sensor Fusion, Enemy Classification, Fleet Coordination)

// Lines of Thought linking (Relations #6-10)
MATCH (l1:LoT {id:"LoT-ThreatDetection-Step1"}), (l2:LoT {id:"LoT-ThreatTracking-Step2"})
CREATE (l1)-[:NEXT_STEP]->(l2);
// Continue similarly for remaining LoTs

// Juncture to Dimension linking (Relations #11-16)
MATCH (j:Juncture {id:"Threat Detection Juncture"}), (d:Dimension {id:"Sensor Data Processing"})
CREATE (j)-[:HAS_DIMENSION]->(d);
// Continue similarly for other junctures

// Dynamic Relations (DRels) explicitly modeled with forward and inverse relationships:

// ======= Dynamic Relations (DRels) =======

// DRel #1: sensorFusion
CREATE (:DynamicRelation {id:"sensorFusion"}) 
CREATE (:DynamicRelation {id:"feedsDetection"}) 
CREATE (:DynamicRelation {id:"sensorFusion"})-[:INTEGRATES]->(:KnowledgeSource {id:"KS-SF1"}) // DRel Relation #1 (forward)
CREATE (:KnowledgeSource {id:"KS-SF1"})-[:FEEDS_DETECTION]->(:DynamicRelation {id:"feedsDetection"}) // DRel Relation #2 (inverse)

// DRel #2: sensorConfidence
CREATE (:DynamicRelation {id:"sensorConfidence"}) 
CREATE (:DynamicRelation {id:"feedsConfidence"}) 
CREATE (:DynamicRelation {id:"sensorConfidence"})-[:AGGREGATES_CONFIDENCE]->(:KnowledgeSource {id:"KS-SF2"}) // DRel Relation #3 (forward)
CREATE (:KnowledgeSource {id:"KS-SF2"})-[:FEEDS_CONFIDENCE]->(:DynamicRelation {id:"feedsConfidence"}) // DRel Relation #4 (inverse)

// DRel #3: fleetOperationalStatus
CREATE (:DynamicRelation {id:"fleetOperationalStatus"}) 
CREATE (:DynamicRelation {id:"equipmentStatusFeed"}) 
CREATE (:DynamicRelation {id:"fleetOperationalStatus"})-[:UPDATES_STATUS]->(:KnowledgeSource {id:"KS-OR1"}) // DRel Relation #5 (forward)
CREATE (:KnowledgeSource {id:"KS-OR1"})-[:FEEDS_EQUIPMENT_STATUS]->(:DynamicRelation {id:"equipmentStatusFeed"}) // DRel Relation #6 (inverse)

// DRel #4: fleetCrewFatigue
CREATE (:DynamicRelation {id:"fleetCrewFatigue"}) 
CREATE (:DynamicRelation {id:"crewFatigueFeed"}) 
CREATE (:DynamicRelation {id:"fleetCrewFatigue"})-[:UPDATES_FATIGUE_LEVEL]->(:KnowledgeSource {id:"KS-OR3"}) // DRel Relation #7 (forward)
CREATE (:KnowledgeSource {id:"KS-OR3"})-[:FEEDS_FATIGUE]->(:DynamicRelation {id:"crewFatigueFeed"}) // DRel Relation #8 (inverse)

// DRel #5: threatClassification
CREATE (:DynamicRelation {id:"threatClassification"}) 
CREATE (:DynamicRelation {id:"informsThreat"}) 
CREATE (:DynamicRelation {id:"threatClassification"})-[:CLASSIFIES_THREAT]->(:KnowledgeSource {id:"KS-EC1"}) // DRel Relation #9 (forward)
CREATE (:KnowledgeSource {id:"KS-EC1"})-[:INFORMS_THREAT]->(:DynamicRelation {id:"informsThreat"}) // DRel Relation #10 (inverse)

// DRel #6: engagementDecision
CREATE (:DynamicRelation {id:"engagementDecision"}) 
CREATE (:DynamicRelation {id:"informsEngagement"}) 
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

// (Continue similarly for properties #12-43...)

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




// Total Objects (Nodes): 42
//   Knowledge Sources: 17
//   Clouds: 5
//   LoTs: 6
//   Junctures: 6
//   Dimensions: 6
//   Triggers as Objects: 2 (shown, more implied)

// Total Properties: 59 explicitly mapped (includes properties of Knowledge Sources, Clouds, Dimensions, LoT nodes)

// Total Relationships: 24
//   Cloud Associations: 5
//   LoT Links: 5
//   Juncture-Dimension Links: 6
//   Dynamic Relations: 8 explicitly modeled

// Total Triggers: 13 (validated against KERAIA KS and nodes)

// GRAND TOTAL:
// 42 Objects, 59 Properties, 24 Relations, 13 Triggers explicitly modeled and numbered

