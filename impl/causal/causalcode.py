import numpy as np
import networkx as nx
import dowhy
from dowhy import CausalModel
import pandas as pd
import random

# --- Step 1: Generate Simulated Naval Scenario Data ---

# 48 Causal Nodes (KS-TR1 to KS-FC3, includes intermediate nodes)
# Represents knowledge sources, lines of thought, junctures and dimension in the naval scenario
causal_nodes = [
    "KS-TR1", "KS-TR2", "KS-TR3", "KS-TR4", "KS-TR5",
    "KS-OR1", "KS-OR2", "KS-OR3",
    "KS-SF1", "KS-SF2", "KS-SF3",
    "KS-EC1", "KS-EC2", "KS-EC3",
    "KS-FC1", "KS-FC2", "KS-FC3",
    "lot_Threat_Detection_and_Classification", "lot_Operational_Readiness_Assessment",
    "lot_Sensor_Fusion_for_Decision_Making", "lot_Fleet_Coordination_and_Threat_Response",
    "Threat_Detection_Juncture", "Threat_Classification_Juncture", "Sensor_Fusion_Juncture",
    "Operational_Readiness_Juncture", "Tactical_Decision_Juncture", "Fleet_Coordination_Juncture",
    "Sensor_Data_Processing_Dimension", "Threat_Evaluation_Dimension", "Multi_Sensor_Integration_Dimension",
    "Readiness_Assessment_Dimension", "Decision_Execution_Dimension", "Fleet_Adaptation_Dimension",
    "threat_Response_Cloud", "Operational_Readiness_Cloud", "Sensor_Fusion_Cloud",
    "Enemy_Classification_Cloud", "Fleet_Coordination_Cloud",
    "Initial_Detection_Step", "Tracking_Data_Fusion_Step", "Classification_Step", "Final_Decision_Step",
    "Status_Assessment_Step", "Mission_Feasibility_Analysis_Step", "Data_Collection_Step",
    "Data_Integration_Analysis_Step", "Real_Time_Threat_Analysis_Step", "Fleet_Position_Adjustment_Step",
    "sensorFusion", "fleetOperationalStatus", "threatClassification", "enemySignatures", "fleetThreatSeverity", "commandDecisions" #added drels
]

# 90 Edges (Causal Relations)
# Defines causal influences between nodes, lines of thought steps, cloud memberships, juncture composition, and dimension influences
causal_edges = [
    ("KS-TR1", "KS-TR5"),  # Edge #1: TR1 influences TR5
    ("KS-TR2", "KS-TR6"),  # Edge #2: TR2 influences TR6
    ("KS-TR3", "KS-TR7"),  # Edge #3: TR3 influences TR7
    ("KS-TR4", "KS-TR8"),  # Edge #4: TR4 influences TR8
    ("KS-TR5", "KS-TR9"),  # Edge #5: TR5 influences TR9
    ("KS-TR6", "KS-TR10"), # Edge #6: TR6 influences TR10
    ("KS-TR7", "KS-TR11"), # Edge #7: TR7 influences TR11
    ("KS-TR8", "KS-TR12"), # Edge #8: TR8 influences TR12
    ("KS-TR9", "KS-TR13"), # Edge #9: TR9 influences TR13
    ("KS-TR10", "KS-TR14"), # Edge #10: TR10 influences TR14
    ("KS-TR11", "KS-TR15"), # Edge #11: TR11 influences TR15
    ("KS-TR12", "KS-TR16"), # Edge #12: TR12 influences TR16
    ("KS-TR15", "KS-FC3"),  # Edge #13: TR15 influences FC3
    ("KS-TR16", "KS-FC3"), # Edge #14: TR16 influences FC3

    # Lines of Thought relations
    ("lot_Threat_Detection_and_Classification", "KS-TR1"), # Edge #15: LoT uses KS-TR1
    ("lot_Threat_Detection_and_Classification", "KS-TR2"), # Edge #16: LoT uses KS-TR2
    ("lot_Threat_Detection_and_Classification", "KS-TR3"), # Edge #17: LoT uses KS-TR3
    ("lot_Threat_Detection_and_Classification", "KS-SF1"), # Edge #18: LoT uses KS-SF1
    ("lot_Threat_Detection_and_Classification", "KS-SF3"), # Edge #19: LoT uses KS-SF3
    ("lot_Threat_Detection_and_Classification", "KS-EC1"), # Edge #20: LoT uses KS-EC1
    ("lot_Threat_Detection_and_Classification", "KS-EC2"), # Edge #21: LoT uses KS-EC2
    ("lot_Threat_Detection_and_Classification", "KS-EC3"), # Edge #22: LoT uses KS-EC3
    ("lot_Threat_Detection_and_Classification", "KS-TR4"), # Edge #23: LoT uses KS-TR4
    ("lot_Threat_Detection_and_Classification", "KS-TR5"), # Edge #24: LoT uses KS-TR5

    ("lot_Operational_Readiness_Assessment", "KS-OR1"), # Edge #25: LoT uses KS-OR1
    ("lot_Operational_Readiness_Assessment", "KS-OR2"), # Edge #26: LoT uses KS-OR2
    ("lot_Operational_Readiness_Assessment", "KS-OR3"), # Edge #27: LoT uses KS-OR3
    ("lot_Operational_Readiness_Assessment", "KS-FC1"), # Edge #28: LoT uses KS-FC1
    ("lot_Operational_Readiness_Assessment", "KS-FC2"), # Edge #29: LoT uses KS-FC2
    ("lot_Operational_Readiness_Assessment", "KS-FC3"), # Edge #30: LoT uses KS-FC3
    ("lot_Operational_Readiness_Assessment", "KS-TR5"), # Edge #31: LoT uses KS-TR5

    ("lot_Sensor_Fusion_for_Decision_Making", "KS-SF1"), # Edge #32: LoT uses KS-SF1
    ("lot_Sensor_Fusion_for_Decision_Making", "KS-SF2"), # Edge #33: LoT uses KS-SF2
    ("lot_Sensor_Fusion_for_Decision_Making", "KS-SF3"), # Edge #34: LoT uses KS-SF3
    ("lot_Sensor_Fusion_for_Decision_Making", "KS-EC1"), # Edge #35: LoT uses KS-EC1
    ("lot_Sensor_Fusion_for_Decision_Making", "KS-EC3"), # Edge #36: LoT uses KS-EC3

    ("lot_Fleet_Coordination_and_Threat_Response", "KS-FC2"), # Edge #37: LoT uses KS-FC2
    ("lot_Fleet_Coordination_and_Threat_Response", "KS-EC3"), # Edge #38: LoT uses KS-EC3
    ("lot_Fleet_Coordination_and_Threat_Response", "KS-FC1"), # Edge #39: LoT uses KS-FC1
    ("lot_Fleet_Coordination_and_Threat_Response", "KS-FC3"), # Edge #40: LoT uses KS-FC3
    ("lot_Fleet_Coordination_and_Threat_Response", "KS-TR5"), # Edge #41: LoT uses KS-TR5
    ("lot_Fleet_Coordination_and_Threat_Response", "KS-TR4"), # Edge #42: LoT uses KS-TR4

    # Cloud membership relations
    ("threat_Response_Cloud", "KS-TR1"), # Edge #43
    ("threat_Response_Cloud", "KS-TR2"), # Edge #44
    ("threat_Response_Cloud", "KS-TR3"), # Edge #45
    ("threat_Response_Cloud", "KS-TR4"), # Edge #46
    ("threat_Response_Cloud", "KS-TR5"), # Edge #47

    ("Operational_Readiness_Cloud", "KS-OR1"), # Edge #48
    ("Operational_Readiness_Cloud", "KS-OR2"), # Edge #49
    ("Operational_Readiness_Cloud", "KS-OR3"), # Edge #50

    ("Sensor_Fusion_Cloud", "KS-SF1"), # Edge #51
    ("Sensor_Fusion_Cloud", "KS-SF2"), # Edge #52
    ("Sensor_Fusion_Cloud", "KS-SF3"), # Edge #53

    ("Enemy_Classification_Cloud", "KS-EC1"), # Edge #54
    ("Enemy_Classification_Cloud", "KS-EC2"), # Edge #55
    ("Enemy_Classification_Cloud", "KS-EC3"), # Edge #56

    ("Fleet_Coordination_Cloud", "KS-FC1"), # Edge #57
    ("Fleet_Coordination_Cloud", "KS-FC2"), # Edge #58
    ("Fleet_Coordination_Cloud", "KS-FC3"), # Edge #59

    # Juncture and Dimension Relations
    ("Threat_Detection_Juncture", "Sensor_Data_Processing_Dimension"), # Edge #60
    ("Threat_Classification_Juncture", "Threat_Evaluation_Dimension"), # Edge #61
    ("Sensor_Fusion_Juncture", "Multi_Sensor_Integration_Dimension"), # Edge #62
    ("Operational_Readiness_Juncture", "Readiness_Assessment_Dimension"), # Edge #63
    ("Tactical_Decision_Juncture", "Decision_Execution_Dimension"), # Edge #64
    ("Fleet_Coordination_Juncture", "Fleet_Adaptation_Dimension"), # Edge #65

    # Line of Thought Step Relations - expanded
    ("lot_Threat_Detection_and_Classification", "Initial_Detection_Step"), # Edge #66
    ("lot_Threat_Detection_and_Classification", "Tracking_Data_Fusion_Step"), # Edge #67
    ("lot_Threat_Detection_and_Classification", "Classification_Step"), # Edge #68
    ("lot_Threat_Detection_and_Classification", "Final_Decision_Step"), # Edge #69

    ("lot_Operational_Readiness_Assessment", "Status_Assessment_Step"), # Edge #70
    ("lot_Operational_Readiness_Assessment", "Mission_Feasibility_Analysis_Step"), # Edge #71
    ("lot_Operational_Readiness_Assessment", "Final_Decision_Step"), # Edge #72

    ("lot_Sensor_Fusion_for_Decision_Making", "Data_Collection_Step"), # Edge #73
    ("lot_Sensor_Fusion_for_Decision_Making", "Data_Integration_Analysis_Step"), # Edge #74
    ("lot_Sensor_Fusion_for_Decision_Making", "Classification_Step"), # Edge #75

    ("lot_Fleet_Coordination_and_Threat_Response", "Real_Time_Threat_Analysis_Step"), # Edge #76
    ("lot_Fleet_Coordination_and_Threat_Response", "Fleet_Position_Adjustment_Step"), # Edge #77
    ("lot_Fleet_Coordination_and_Threat_Response", "Final_Decision_Step"), # Edge #78

    # DRel Relations (Forward and Inverse - simplified)
    ("sensorFusion", "KS-SF3"),  # Edge #79: sensorFusion uses KS-SF3 (AI Fusion System)
    ("sensorFusion", "KS-TR1"),  # Edge #80: sensorFusion uses KS-TR1 (Radar APS-124)
    ("fleetOperationalStatus", "KS-OR1"),  # Edge #81: fleetOperationalStatus uses KS-OR1 (Fleet Readiness)
    ("fleetOperationalStatus", "KS-OR2"),  # Edge #82: fleetOperationalStatus uses KS-OR2 (Equipment Status)
    ("threatClassification", "KS-FC2"),  # Edge #83: threatClassification uses KS-FC2 (Threat Level Assessment)
    ("threatClassification", "KS-EC3"),  # Edge #84: threatClassification uses KS-EC3 (Classification System)
    ("enemySignatures", "KS-EC3"),  # Edge #85: enemySignatures uses KS-EC3 (Classification System)
    ("enemySignatures", "KS-EC1"),  # Edge #86: enemySignatures uses KS-EC1 (Intelligence Database)
    ("fleetThreatSeverity", "KS-FC1"),  # Edge #87: fleetThreatSeverity uses KS-FC1 (Fleet Positioning System)
    ("fleetThreatSeverity", "KS-FC2"),  # Edge #88: fleetThreatSeverity uses KS-FC2 (Threat Level Assessment)
    ("commandDecisions", "KS-TR5"),  # Edge #89: commandDecisions uses KS-TR5 (Command Center)
    ("commandDecisions", "KS-SF3"),  # Edge #90: commandDecisions uses KS-SF3 (AI Fusion System)
]

# 43 Define Probabilistic Dependencies (31 Bayesian Dependencies) ---
# Probability of each KS being active/true
probabilistic_dependencies = {
    "KS-TR1": 0.7, "KS-TR2": 0.6, "KS-TR3": 0.75, "KS-TR4": 0.5, "KS-TR5": 0.65,
    "KS-OR1": 0.8, "KS-OR2": 0.7, "KS-OR3": 0.9,
    "KS-SF1": 0.6, "KS-SF2": 0.5, "KS-SF3": 0.7,
    "KS-EC1": 0.9, "KS-EC2": 0.4, "KS-EC3": 0.8,
    "KS-FC1": 0.7, "KS-FC2": 0.6, "KS-FC3": 0.8,
    "lot_Threat_Detection_and_Classification": 0.7,
    "lot_Operational_Readiness_Assessment": 0.8,
    "lot_Sensor_Fusion_for_Decision_Making": 0.6,
    "lot_Fleet_Coordination_and_Threat_Response": 0.9,
    "Threat_Detection_Juncture": 0.7,
    "Threat_Classification_Juncture": 0.6,
    "Sensor_Fusion_Juncture": 0.8,
    "Operational_Readiness_Juncture": 0.9,
    "Tactical_Decision_Juncture": 0.7,
    "Fleet_Coordination_Juncture": 0.8,
    "Sensor_Data_Processing_Dimension": 0.6,
    "Threat_Evaluation_Dimension": 0.7,
    "Initial_Detection_Step": 0.8,
    "Tracking_Data_Fusion_Step": 0.7,
    "Classification_Step": 0.9,
    "Final_Decision_Step": 0.8,
    "Status_Assessment_Step": 0.75,
    "Mission_Feasibility_Analysis_Step": 0.85,
    "Data_Collection_Step": 0.65,
    "Data_Integration_Analysis_Step": 0.75,
    "Real_Time_Threat_Analysis_Step": 0.85,
    "Fleet_Position_Adjustment_Step": 0.95,
    "sensorFusion": 0.7,
    "fleetOperationalStatus": 0.8,
    "threatClassification": 0.6,
    "enemySignatures": 0.9,
    "fleetThreatSeverity": 0.7,
    "commandDecisions": 0.8
}

# 24 Bayesian Fusion Links (18 Links) ---
# These integrate probability data to refine causal inference,  expanded to include LoTs
bayesian_fusion_links = [
    ("KS-TR1", "KS-TR3"), # Link #1: TR1 informs TR3
    ("KS-TR2", "KS-TR4"), # Link #2: TR2 informs TR4
    ("KS-TR5", "KS-TR7"), # Link #3: TR5 informs TR7
    ("KS-TR6", "KS-TR8"), # Link #4: TR6 informs TR8
    ("KS-TR9", "KS-TR11"), # Link #5: TR9 informs TR11
    ("KS-TR10", "KS-TR12"), # Link #6: TR10 informs TR12
    ("KS-TR13", "KS-TR15"), # Link #7: TR13 informs TR15
    ("KS-TR14", "KS-TR16"), # Link #8: TR14 informs TR16
    ("KS-TR15", "KS-FC3"), # Link #9: TR15 informs FC3
    ("KS-TR16", "KS-FC3"), # Link #10: TR16 informs FC3
    ("KS-SF1", "KS-SF3"), # Link #11: SF1 informs SF3
    ("KS-SF2", "KS-SF3"), # Link #12: SF2 informs SF3
    ("KS-EC1", "KS-EC3"), # Link #13: EC1 informs EC3
    ("KS-FC1", "KS-FC3"), # Link #14: FC1 informs FC3

    # Links to LoTs
    ("KS-TR3", "lot_Threat_Detection_and_Classification"), # Link #15
    ("KS-OR1", "lot_Operational_Readiness_Assessment"), # Link #16
    ("KS-SF3", "lot_Sensor_Fusion_for_Decision_Making"), # Link #17
    ("KS-FC2", "lot_Fleet_Coordination_and_Threat_Response")  # Link #18
]

# 8 Define Markov Dependencies (6 Time-Sequenced Causal Links) ---
# Temporal dependencies between knowledge sources
markov_dependencies = [
    ("KS-TR5", "KS-TR6"), # Dependency #1: TR5 follows TR6
    ("KS-TR7", "KS-TR8"), # Dependency #2: TR7 follows TR8
    ("KS-TR9", "KS-TR10"), # Dependency #3: TR9 follows TR10
    ("KS-TR11", "KS-TR12"), # Dependency #4: TR11 follows TR12
    ("KS-TR13", "KS-TR14"), # Dependency #5: TR13 follows TR14

    # Temporal dependency within a LoT (simplified)
    ("Initial_Detection_Step", "Tracking_Data_Fusion_Step"), #Dependency #6
    ("Tracking_Data_Fusion_Step", "Classification_Step"), #Dependency #7
    ("Classification_Step", "Final_Decision_Step")  #Dependency #8
]

# 8 Define Historical Data Intelligence Refinement (4 Adjustments) ---
# Refinement of knowledge sources based on historical data
historical_data_refinement = [
    ("KS-TR1", "KS-TR9"), # Refinement #1: TR1 refines TR9
    ("KS-TR3", "KS-TR11"), # Refinement #2: TR3 refines TR11
    ("KS-TR6", "KS-TR15"), # Refinement #3: TR6 refines TR15
    ("KS-TR8", "KS-FC3"), # Refinement #4: TR8 refines FC3
    ("KS-EC1", "KS-TR4"), # Refinement #5
    ("KS-SF3", "KS-TR5"), # Refinement #6
    ("KS-FC3", "KS-FC1"), # Refinement #7
    ("KS-OR3", "KS-TR3")  # Refinement #8
]

# --- Step 6: Define Properties and Generate Sample Data ---

# 59 Properties
properties = {
    "classification": ["KS-SF2", "KS-EC3", "KS-EC1", "KS-EC2", "KS-TR4", "KS-TR5", "lot_Threat_Detection_and_Classification"], # Property #1
    "combined_confidence": ["KS-SF3"],  # Property #2
    "confidence_level": ["KS-TR4"],  # Property #3
    "confirmed_tracks": ["KS-TR3"],  # Property #4
    "decision_threshold": ["KS-EC3"],  # Property #5
    "detection_capability": ["KS-TR1"],  # Property #6
    "detection_mode": ["KS-TR2"],  # Property #7
    "detection": ["KS-SF1", "KS-SF2", "KS-TR1", "KS-TR2"],  # Property #8
    "formation": ["KS-FC1"],  # Property #9
    "fusion_algorithm": ["KS-SF3"],  # Property #10
    "maneuver_strategy": ["lot_Fleet_Coordination_and_Threat_Response"],  # Property #11
    "range": ["KS-TR1"],  # Property #12
    "recent_sightings": ["KS-TR4"],  # Property #13
    "recommended_action": ["KS-FC2"],  # Property #14
    "rules_of_engagement": ["KS-TR5"],  # Property #15
    "sensor_range": ["KS-TR2"],  # Property #16
    "status": ["KS-OR1", "KS-TR1", "KS-TR5", "KS-OR2", "KS-OR3", "KS-FC1", "KS-FC2", "KS-FC3"],  # Property #17
    "threat_level": ["KS-FC2", "KS-TR4"],  # Property #18
    "tracking_algorithm": ["KS-TR3"],  # Property #19
    "known_signatures": ["KS-EC1"],  # Property #20
    "operational_status": ["KS-OR1"],  # Property #21
    "crew_fatigue_level": ["KS-OR3"],  # Property #22
    "historical_engagement_data": ["KS-TR4"],  # Property #23
    "engagement_decision": ["KS-TR5"],  # Property #24
    "sensor_accuracy": ["KS-SF1", "KS-SF2"],  # Property #25
    "high_confidence_detection": ["KS-SF3"],  # Property #26
    "mission_feasibility": ["lot_Operational_Readiness_Assessment"],  # Property #27
    "fleet_formation": ["KS-FC1", "KS-FC3"],  # Property #28
    "threat_assessment": ["KS-FC2"],  # Property #29
    "decision_priority": ["KS-TR5", "KS-FC3"],  # Property #30
    "type": ["KS-TR1", "KS-TR2", "KS-TR3", "KS-TR4", "KS-TR5", "KS-OR1", "KS-OR2", "KS-OR3", "KS-SF1", "KS-SF2", "KS-SF3", "KS-EC1", "KS-EC2", "KS-EC3", "KS-FC1", "KS-FC2", "KS-FC3", "threat_Response_Cloud", "Operational_Readiness_Cloud", "Sensor_Fusion_Cloud", "Enemy_Classification_Cloud", "Fleet_Coordination_Cloud", "lot_Threat_Detection_and_Classification", "lot_Operational_Readiness_Assessment", "lot_Sensor_Fusion_for_Decision_Making", "lot_Fleet_Coordination_and_Threat_Response"],  # Property #31
    "sensors": ["KS-TR1", "KS-TR2"],  # Property #32
    "fuel_levels": ["KS-OR1"],  # Property #33
    "ammunition": ["KS-OR1"],  # Property #34
    "radar": ["KS-OR2"],  # Property #35
    "sonobuoy_network": ["KS-OR2"],  # Property #36
    "fatigue_level": ["KS-OR3"],  # Property #37
    "crew_rotation": ["KS-OR3"],  # Property #38
    "confidence": ["KS-SF1"],  # Property #39
    "acoustic_signature": ["KS-EC2"],  # Property #40
    "depth": ["KS-EC2"],  # Property #41
    "current_formation": ["KS-FC1"],  # Property #42
    "decision_model": ["KS-FC3"],  # Property #43
    "step_1": ["lot_Threat_Detection_and_Classification", "lot_Operational_Readiness_Assessment", "lot_Sensor_Fusion_for_Decision_Making", "lot_Fleet_Coordination_and_Threat_Response"],  # Property #44
    "step_2": ["lot_Threat_Detection_and_Classification", "lot_Operational_Readiness_Assessment", "lot_Sensor_Fusion_for_Decision_Making", "lot_Fleet_Coordination_and_Threat_Response"],  # Property #45
    "step_3": ["lot_Threat_Detection_and_Classification", "lot_Operational_Readiness_Assessment", "lot_Sensor_Fusion_for_Decision_Making", "lot_Fleet_Coordination_and_Threat_Response"],  # Property #46
    "step_4": ["lot_Threat_Detection_and_Classification"],  # Property #47
    "Threat_Detection": ["Threat_Detection_Juncture"],  # Property #48
    "Threat_Classification": ["Threat_Classification_Juncture"],  # Property #49
    "Sensor_Fusion_for_Threat_Confirmation": ["Sensor_Fusion_Juncture"],  # Property #50
    "Operational_Readiness_Assessment": ["Operational_Readiness_Juncture"],  # Property #51
    "Tactical_Decision_Making": ["Tactical_Decision_Juncture"],  # Property #52
    "Fleet_Coordination": ["Fleet_Coordination_Juncture"],  # Property #53
    "Sensor_Data_Processing": ["Sensor_Data_Processing_Dimension"],  # Property #54
    "Threat_Evaluation": ["Threat_Evaluation_Dimension"],  # Property #55
    "Multi_Sensor_Integration": ["Multi_Sensor_Integration_Dimension"],  # Property #56
    "Readiness_Assessment": ["Readiness_Assessment_Dimension"],  # Property #57
    "Decision_Execution": ["Decision_Execution_Dimension"],  # Property #58
    "Fleet_Adaptation": ["Fleet_Adaptation_Dimension"]  # Property #59
}

# Generate sample data with properties
data = pd.DataFrame()
num_samples = 1000

for node in causal_nodes:
    data[node] = np.random.binomial(1, probabilistic_dependencies.get(node, 0.5), num_samples) # Default probability if not found

for prop, nodes in properties.items():
    for node in nodes:
        data[prop + "_" + node] = np.random.normal(loc=0.0, scale=1.0, size=num_samples) # Create a normal distribution for property values,

# Define causal model
model = CausalModel(
    data=data,
    treatment="KS-TR1",
    outcome="KS-FC3",
    common_causes=["KS-TR2", "KS-TR3", "KS-TR4", "KS-TR5", "lot_Threat_Detection_and_Classification", "classification_KS-SF2", "combined_confidence_KS-SF3", "sensorFusion", "fleetOperationalStatus", "threatClassification", "enemySignatures", "fleetThreatSeverity", "commandDecisions"]
)

# Identify causal effect
identified_estimand = model.identify_effect()
print(identified_estimand)

# Estimate causal effect using Propensity Score Matching
estimate = model.estimate_effect(identified_estimand, method_name="backdoor.propensity_score_matching")
print("Causal Effect Estimate:", estimate)

# --- Step 7: Validate Causal Model ---
model.refute_estimate(identified_estimand, estimate, method_name="random_common_cause")

# Objects: 48
# Relations: 113 (90 edges + 43 probabilistic dependencies + 5 fusion links)
# Properties: 59

