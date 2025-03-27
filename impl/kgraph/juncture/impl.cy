CREATE (:Juncture {name: "Threat Detection"}),
       (:Juncture {name: "Threat Classification"}),
       (:Juncture {name: "Sensor Fusion for Threat Confirmation"}),
       (:Juncture {name: "Operational Readiness Assessment"}),
       (:Juncture {name: "Tactical Decision Making"}),
       (:Juncture {name: "Fleet Coordination"});

CREATE (:Dimension {name: "Sensor Data Processing"}),
       (:Dimension {name: "Threat Evaluation"}),
       (:Dimension {name: "Multi-Sensor Integration"}),
       (:Dimension {name: "Readiness Assessment"}),
       (:Dimension {name: "Decision Execution"}),
       (:Dimension {name: "Fleet Adaptation"});

MATCH (jd1:Juncture {name: "Threat Detection"})
MATCH (dim1:Dimension {name: "Sensor Data Processing"})
MATCH (tr1:KnowledgeSource {name: "KS-TR1"})
MATCH (tr2:KnowledgeSource {name: "KS-TR2"})
MATCH (sf1:KnowledgeSource {name: "KS-SF1"})
MATCH (sf2:KnowledgeSource {name: "KS-SF2"})

MERGE (jd1)-[:HAS_DIMENSION]->(dim1)
MERGE (dim1)-[:USES_SOURCE]->(tr1)
MERGE (dim1)-[:USES_SOURCE]->(tr2)
MERGE (dim1)-[:USES_SOURCE]->(sf1)
MERGE (dim1)-[:USES_SOURCE]->(sf2);

MATCH (jd2:Juncture {name: "Threat Classification"})
MATCH (dim2:Dimension {name: "Threat Evaluation"})
MATCH (ec1:KnowledgeSource {name: "KS-EC1"})
MATCH (ec2:KnowledgeSource {name: "KS-EC2"})
MATCH (ec3:KnowledgeSource {name: "KS-EC3"})
MATCH (tr3:KnowledgeSource {name: "KS-TR3"})
MATCH (tr4:KnowledgeSource {name: "KS-TR4"})

MERGE (jd2)-[:HAS_DIMENSION]->(dim2)
MERGE (dim2)-[:USES_SOURCE]->(ec1)
MERGE (dim2)-[:USES_SOURCE]->(ec2)
MERGE (dim2)-[:USES_SOURCE]->(ec3)
MERGE (dim2)-[:USES_SOURCE]->(tr3)
MERGE (dim2)-[:USES_SOURCE]->(tr4);

MATCH (jd3:Juncture {name: "Sensor Fusion for Threat Confirmation"})
MATCH (dim3:Dimension {name: "Multi-Sensor Integration"})
MATCH (sf1:KnowledgeSource {name: "KS-SF1"})
MATCH (sf2:KnowledgeSource {name: "KS-SF2"})
MATCH (sf3:KnowledgeSource {name: "KS-SF3"})
MATCH (tr3:KnowledgeSource {name: "KS-TR3"})

MERGE (jd3)-[:HAS_DIMENSION]->(dim3)
MERGE (dim3)-[:USES_SOURCE]->(sf1)
MERGE (dim3)-[:USES_SOURCE]->(sf2)
MERGE (dim3)-[:USES_SOURCE]->(sf3)
MERGE (dim3)-[:USES_SOURCE]->(tr3);

MATCH (jd4:Juncture {name: "Operational Readiness Assessment"})
MATCH (dim4:Dimension {name: "Readiness Assessment"})
MATCH (or1:KnowledgeSource {name: "KS-OR1"})
MATCH (or2:KnowledgeSource {name: "KS-OR2"})
MATCH (or3:KnowledgeSource {name: "KS-OR3"})

MERGE (jd4)-[:HAS_DIMENSION]->(dim4)
MERGE (dim4)-[:USES_SOURCE]->(or1)
MERGE (dim4)-[:USES_SOURCE]->(or2)
MERGE (dim4)-[:USES_SOURCE]->(or3);

MATCH (jd5:Juncture {name: "Tactical Decision Making"})
MATCH (dim5:Dimension {name: "Decision Execution"})
MATCH (fc2:KnowledgeSource {name: "KS-FC2"})
MATCH (fc3:KnowledgeSource {name: "KS-FC3"})
MATCH (tr5:KnowledgeSource {name: "KS-TR5"})

MERGE (jd5)-[:HAS_DIMENSION]->(dim5)
MERGE (dim5)-[:USES_SOURCE]->(fc2)
MERGE (dim5)-[:USES_SOURCE]->(fc3)
MERGE (dim5)-[:USES_SOURCE]->(tr5);

MATCH (jd6:Juncture {name: "Fleet Coordination"})
MATCH (dim6:Dimension {name: "Fleet Adaptation"})
MATCH (fc1:KnowledgeSource {name: "KS-FC1"})
MATCH (fc2:KnowledgeSource {name: "KS-FC2"})
MATCH (fc3:KnowledgeSource {name: "KS-FC3"})

MERGE (jd6)-[:HAS_DIMENSION]->(dim6)
MERGE (dim6)-[:USES_SOURCE]->(fc1)
MERGE (dim6)-[:USES_SOURCE]->(fc2)
MERGE (dim6)-[:USES_SOURCE]->(fc3);

