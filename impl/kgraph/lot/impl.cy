CREATE (:LoT {name: "Threat_Detection_and_Classification"}),
       (:LoT {name: "Operational_Readiness_Assessment"}),
       (:LoT {name: "Sensor_Fusion_for_Decision_Making"}),
       (:LoT {name: "Fleet_Coordination_and_Threat_Response"});

MATCH (lot1:LoT {name: "Threat_Detection_and_Classification"})
MATCH (tr1:KnowledgeSource {name: "KS-TR1"})
MATCH (tr2:KnowledgeSource {name: "KS-TR2"})
MATCH (tr3:KnowledgeSource {name: "KS-TR3"})
MATCH (sf1:KnowledgeSource {name: "KS-SF1"})
MATCH (sf3:KnowledgeSource {name: "KS-SF3"})
MATCH (ec1:KnowledgeSource {name: "KS-EC1"})
MATCH (ec2:KnowledgeSource {name: "KS-EC2"})
MATCH (ec3:KnowledgeSource {name: "KS-EC3"})
MATCH (tr4:KnowledgeSource {name: "KS-TR4"})
MATCH (tr5:KnowledgeSource {name: "KS-TR5"})

MERGE (lot1)-[:HAS_STEP {step: 1, process: "Initial Detection"}]->(tr1)
MERGE (lot1)-[:HAS_STEP {step: 1, process: "Initial Detection"}]->(tr2)
MERGE (lot1)-[:HAS_STEP {step: 2, process: "Tracking and Data Fusion"}]->(tr3)
MERGE (lot1)-[:HAS_STEP {step: 2, process: "Tracking and Data Fusion"}]->(sf1)
MERGE (lot1)-[:HAS_STEP {step: 2, process: "Tracking and Data Fusion"}]->(sf3)
MERGE (lot1)-[:HAS_STEP {step: 3, process: "Classification"}]->(ec1)
MERGE (lot1)-[:HAS_STEP {step: 3, process: "Classification"}]->(ec2)
MERGE (lot1)-[:HAS_STEP {step: 3, process: "Classification"}]->(ec3)
MERGE (lot1)-[:HAS_STEP {step: 4, process: "Classification"}]->(tr4)
MERGE (lot1)-[:HAS_STEP {step: 4, process: "Classification"}]->(tr5);

MATCH (lot2:LoT {name: "Operational_Readiness_Assessment"})
MATCH (or1:KnowledgeSource {name: "KS-OR1"})
MATCH (or2:KnowledgeSource {name: "KS-OR2"})
MATCH (or3:KnowledgeSource {name: "KS-OR3"})
MATCH (fc1:KnowledgeSource {name: "KS-FC1"})
MATCH (fc2:KnowledgeSource {name: "KS-FC2"})
MATCH (fc3:KnowledgeSource {name: "KS-FC3"})
MATCH (tr5:KnowledgeSource {name: "KS-TR5"})

MERGE (lot2)-[:HAS_STEP {step: 1, process: "Status Assessment"}]->(or1)
MERGE (lot2)-[:HAS_STEP {step: 1, process: "Status Assessment"}]->(or2)
MERGE (lot2)-[:HAS_STEP {step: 1, process: "Status Assessment"}]->(or3)
MERGE (lot2)-[:HAS_STEP {step: 2, process: "Mission Feasibility Analysis"}]->(fc1)
MERGE (lot2)-[:HAS_STEP {step: 2, process: "Mission Feasibility Analysis"}]->(fc2)
MERGE (lot2)-[:HAS_STEP {step: 3, process: "Final Decision"}]->(fc3)
MERGE (lot2)-[:HAS_STEP {step: 3, process: "Final Decision"}]->(tr5);

MATCH (lot3:LoT {name: "Sensor_Fusion_for_Decision_Making"})
MATCH (sf1:KnowledgeSource {name: "KS-SF1"})
MATCH (sf2:KnowledgeSource {name: "KS-SF2"})
MATCH (sf3:KnowledgeSource {name: "KS-SF3"})
MATCH (ec1:KnowledgeSource {name: "KS-EC1"})
MATCH (ec3:KnowledgeSource {name: "KS-EC3"})

MERGE (lot3)-[:HAS_STEP {step: 1, process: "Data Collection"}]->(sf1)
MERGE (lot3)-[:HAS_STEP {step: 1, process: "Data Collection"}]->(sf2)
MERGE (lot3)-[:HAS_STEP {step: 2, process: "Data Integration and Analysis"}]->(sf3)
MERGE (lot3)-[:HAS_STEP {step: 3, process: "Threat Classification"}]->(ec1)
MERGE (lot3)-[:HAS_STEP {step: 3, process: "Threat Classification"}]->(ec3);

MATCH (lot4:LoT {name: "Fleet_Coordination_and_Threat_Response"})
MATCH (fc1:KnowledgeSource {name: "KS-FC1"})
MATCH (fc2:KnowledgeSource {name: "KS-FC2"})
MATCH (fc3:KnowledgeSource {name: "KS-FC3"})
MATCH (ec3:KnowledgeSource {name: "KS-EC3"})
MATCH (tr4:KnowledgeSource {name: "KS-TR4"})
MATCH (tr5:KnowledgeSource {name: "KS-TR5"})

MERGE (lot4)-[:HAS_STEP {step: 1, process: "Real-Time Threat Analysis"}]->(fc2)
MERGE (lot4)-[:HAS_STEP {step: 1, process: "Real-Time Threat Analysis"}]->(ec3)
MERGE (lot4)-[:HAS_STEP {step: 2, process: "Fleet Position Adjustment"}]->(fc1)
MERGE (lot4)-[:HAS_STEP {step: 2, process: "Fleet Position Adjustment"}]->(fc3)
MERGE (lot4)-[:HAS_STEP {step: 2, process: "Engagement Decision"}]->(tr5)
MERGE (lot4)-[:HAS_STEP {step: 2, process: "Engagement Decision"}]->(tr4);
