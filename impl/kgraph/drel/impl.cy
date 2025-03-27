-- Create Knowledge Sources
CREATE (:KnowledgeSource {id: 'KS-TR1', name: 'Radar APS-124', type: 'Sensor', detection_data: 'Unknown contact'});
CREATE (:KnowledgeSource {id: 'KS-TR2', name: 'Sonobuoy Network', type: 'Sensor', confidence_score: '0.85'});
CREATE (:KnowledgeSource {id: 'KS-SF3', name: 'AI Fusion System', type: 'Processing Node'});

-- Create Dynamic Relations
MATCH (sensor1:KnowledgeSource {id: 'KS-TR1'}), (fusion:KnowledgeSource {id: 'KS-SF3'})
CREATE (sensor1)-[:FEEDS_DETECTION {relation: 'sensor-fusion'}]->(fusion);

MATCH (sensor2:KnowledgeSource {id: 'KS-TR2'}), (fusion:KnowledgeSource {id: 'KS-SF3'})
CREATE (sensor2)-[:FEEDS_CONFIDENCE {relation: 'sensor-fusion'}]->(fusion);

-- Update KS-SF3 with inherited properties
MATCH (sensor1:KnowledgeSource {id: 'KS-TR1'})-[r1:FEEDS_DETECTION]->(fusion:KnowledgeSource {id: 'KS-SF3'}),
      (sensor2:KnowledgeSource {id: 'KS-TR2'})-[r2:FEEDS_CONFIDENCE]->(fusion)
SET fusion.detection_data = sensor1.detection_data,
    fusion.confidence_score = sensor2.confidence_score;


-- This relation updates the Fleet Readiness (KS-OR1) with radar status from Equipment Status (KS-OR2) and crew fatigue from Crew Readiness (KS-OR3).

-- Create Knowledge Sources
CREATE (:KnowledgeSource {id: 'KS-OR2', name: 'Equipment Status', radar_status: 'Operational'});
CREATE (:KnowledgeSource {id: 'KS-OR3', name: 'Crew Readiness', fatigue_level: 'Moderate'});
CREATE (:KnowledgeSource {id: 'KS-OR1', name: 'Fleet Readiness'});

-- Create Dynamic Relations
MATCH (eq:KnowledgeSource {id: 'KS-OR2'}), (fleet:KnowledgeSource {id: 'KS-OR1'})
CREATE (eq)-[:FEEDS_EQUIPMENT_STATUS {relation: 'updates-status'}]->(fleet);

MATCH (crew:KnowledgeSource {id: 'KS-OR3'}), (fleet:KnowledgeSource {id: 'KS-OR1'})
CREATE (crew)-[:FEEDS_FATIGUE {relation: 'updates-status'}]->(fleet);

-- Update KS-OR1 with inherited properties
MATCH (eq:KnowledgeSource {id: 'KS-OR2'})-[r1:FEEDS_EQUIPMENT_STATUS]->(fleet:KnowledgeSource {id: 'KS-OR1'}),
      (crew:KnowledgeSource {id: 'KS-OR3'})-[r2:FEEDS_FATIGUE]->(fleet)
SET fleet.radar_status = eq.radar_status,
    fleet.fatigue_level = crew.fatigue_level;


-- This relation updates Threat Level Assessment (KS-FC2) with a classification from Threat Classification System (KS-EC3) and engagement decisions from Command Center (KS-TR5).

-- Create Knowledge Sources
CREATE (:KnowledgeSource {id: 'KS-EC3', name: 'Threat Classification System', classification: 'Unidentified Submarine'});
CREATE (:KnowledgeSource {id: 'KS-TR5', name: 'Command Center', rules_of_engagement: 'Hold fire until confirmed hostile'});
CREATE (:KnowledgeSource {id: 'KS-FC2', name: 'Threat Level Assessment'});

-- Create Dynamic Relations
MATCH (cls:KnowledgeSource {id: 'KS-EC3'}), (threat:KnowledgeSource {id: 'KS-FC2'})
CREATE (cls)-[:INFORMS_THREAT {relation: 'threat-classification'}]->(threat);

MATCH (cmd:KnowledgeSource {id: 'KS-TR5'}), (threat:KnowledgeSource {id: 'KS-FC2'})
CREATE (cmd)-[:INFORMS_ENGAGEMENT {relation: 'threat-classification'}]->(threat);

-- Update KS-FC2 with inherited properties
MATCH (cls:KnowledgeSource {id: 'KS-EC3'})-[r1:INFORMS_THREAT]->(threat:KnowledgeSource {id: 'KS-FC2'}),
      (cmd:KnowledgeSource {id: 'KS-TR5'})-[r2:INFORMS_ENGAGEMENT]->(threat)
SET threat.threat_label = cls.classification,
    threat.engagement_decision = (CASE 
                                    WHEN cmd.rules_of_engagement CONTAINS 'hold fire' 
                                    THEN 'No engagement' 
                                    ELSE 'Engage target' 
                                  END);
 

-- This relation connects the Threat Classification System (KS-EC3) to intelligence sources such as the Intelligence Database (KS-EC1) and Intelligence Reports (KS-TR4).

-- Create Knowledge Sources
CREATE (:KnowledgeSource {id: 'KS-EC3', name: 'Threat Classification System'});
CREATE (:KnowledgeSource {id: 'KS-EC1', name: 'Intelligence Database', known_signatures: 'Type-212, Kilo-Class Submarine'});
CREATE (:KnowledgeSource {id: 'KS-TR4', name: 'Intelligence Reports', historical_data: 'Past encounters with hostile submarines'});

-- Create Dynamic Relations
MATCH (cls:KnowledgeSource {id: 'KS-EC3'}), (intel:KnowledgeSource {id: 'KS-EC1'})
CREATE (cls)-[:PROVIDES_SIGNATURES {relation: 'uses-intelligence'}]->(intel);

MATCH (cls:KnowledgeSource {id: 'KS-EC3'}), (report:KnowledgeSource {id: 'KS-TR4'})
CREATE (cls)-[:PROVIDES_HISTORICAL_DATA {relation: 'uses-intelligence'}]->(report);

-- Update KS-EC3 with inherited properties
MATCH (cls:KnowledgeSource {id: 'KS-EC3'})-[r1:PROVIDES_SIGNATURES]->(intel:KnowledgeSource {id: 'KS-EC1'}),
      (cls)-[r2:PROVIDES_HISTORICAL_DATA]->(report:KnowledgeSource {id: 'KS-TR4'})
SET cls.known_threat_signatures = intel.known_signatures,
    cls.historical_engagement_data = report.historical_data;


-- This relation updates Fleet Positioning System (KS-FC1) with threat severity from Threat Level Assessment (KS-FC2) and tactical formation from Tactical AI (KS-FC3).

-- Create Knowledge Sources
CREATE (:KnowledgeSource {id: 'KS-FC1', name: 'Fleet Positioning System'});
CREATE (:KnowledgeSource {id: 'KS-FC2', name: 'Threat Level Assessment', threat_level: 'High'});
CREATE (:KnowledgeSource {id: 'KS-FC3', name: 'Tactical AI', new_formation: 'Defensive Perimeter'});

-- Create Dynamic Relations
MATCH (fleet:KnowledgeSource {id: 'KS-FC1'}), (threat:KnowledgeSource {id: 'KS-FC2'})
CREATE (threat)-[:UPDATES_THREAT_SEVERITY {relation: 'fleet-formation-update'}]->(fleet);

MATCH (fleet:KnowledgeSource {id: 'KS-FC1'}), (tactical:KnowledgeSource {id: 'KS-FC3'})
CREATE (tactical)-[:UPDATES_FORMATION {relation: 'fleet-formation-update'}]->(fleet);

-- Update KS-FC1 with inherited properties
MATCH (threat:KnowledgeSource {id: 'KS-FC2'})-[r1:UPDATES_THREAT_SEVERITY]->(fleet:KnowledgeSource {id: 'KS-FC1'}),
      (tactical:KnowledgeSource {id: 'KS-FC3'})-[r2:UPDATES_FORMATION]->(fleet)
SET fleet.threat_severity = threat.threat_level,
    fleet.fleet_formation = tactical.new_formation;



-- This relation updates Command Center (KS-TR5) with detection confidence from AI Fusion System (KS-SF3) and threat assessment from Threat Level Assessment (KS-FC2).

-- Create Knowledge Sources
CREATE (:KnowledgeSource {id: 'KS-SF3', name: 'AI Fusion System', high_confidence_detection: '85%'});
CREATE (:KnowledgeSource {id: 'KS-FC2', name: 'Threat Level Assessment', high_threat_level: 'Severe'});
CREATE (:KnowledgeSource {id: 'KS-TR5', name: 'Command Center'});

-- Create Dynamic Relations
MATCH (fusion:KnowledgeSource {id: 'KS-SF3'}), (command:KnowledgeSource {id: 'KS-TR5'})
CREATE (fusion)-[:EVALUATES_CONFIDENCE {relation: 'engagement-protocols'}]->(command);

MATCH (threat:KnowledgeSource {id: 'KS-FC2'}), (command:KnowledgeSource {id: 'KS-TR5'})
CREATE (threat)-[:EVALUATES_THREAT {relation: 'engagement-protocols'}]->(command);

-- Update KS-TR5 with inherited properties
MATCH (fusion:KnowledgeSource {id: 'KS-SF3'})-[r1:EVALUATES_CONFIDENCE]->(cmd:KnowledgeSource {id: 'KS-TR5'}),
      (threat:KnowledgeSource {id: 'KS-FC2'})-[r2:EVALUATES_THREAT]->(cmd)
SET cmd.detection_confidence = fusion.high_confidence_detection,
    cmd.threat_assessment = threat.high_threat_level;




