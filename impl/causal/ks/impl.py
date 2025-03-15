
# Define the causal relationships between Knowledge Sources
causal_graph_ks = """
digraph {
    # Threat Response Knowledge Sources
    "KS_TR1" -> {"KS_EC1", "KS_EC2"};  # Radar contributes to threat classification
    "KS_TR2" -> {"KS_EC3"};  # Sonobuoy Network assists classification
    "KS_TR3" -> {"KS_FC2"};  # Tracking system supports fleet decisions
    "KS_TR4" -> {"KS_EC1", "KS_EC3"};  # Intelligence reports refine classification
    "KS_TR5" -> {"KS_FC3"};  # Rules of engagement inform tactical AI

    # Operational Readiness Knowledge Sources
    "KS_OR1" -> {"KS_FC1"};  # Fleet readiness affects positioning
    "KS_OR2" -> {"KS_FC2"};  # Equipment status affects threat level assessment
    "KS_OR3" -> {"KS_FC3"};  # Crew fatigue influences decision models

    # Sensor Fusion Knowledge Sources
    "KS_SF1" -> {"KS_EC1"};  # Acoustic anomaly assists intelligence database
    "KS_SF2" -> {"KS_EC2"};  # Object detection refines classification
    "KS_SF3" -> {"KS_TR1", "KS_TR2"};  # Bayesian inference integrates sensor data

    # Enemy Classification Knowledge Sources
    "KS_EC1" -> {"KS_FC2"};  # Known signatures contribute to threat assessment
    "KS_EC2" -> {"KS_TR4"};  # Sensor data supports intelligence reports
    "KS_EC3" -> {"KS_FC3"};  # Classification system refines decision models

    # Fleet Coordination Knowledge Sources
    "KS_FC1" -> {"KS_TR5"};  # Defensive perimeter impacts engagement rules
    "KS_FC2" -> {"KS_TR5"};  # High threat level modifies engagement strategies
    "KS_FC3" -> {"KS_OR3"};  # Tactical AI depends on crew readiness

    # Interventions for causal inference
    "Intervention_Threat_Detection" -> "KS_EC1";
    "Intervention_Sensor_Fusion" -> "KS_SF3";
    "Intervention_Operational_Status" -> "KS_OR1";
}
"""

# Create the causal model
ks_model = CausalModel(
    graph=causal_graph_ks
)

# Visualize the causal structure
ks_model.view_model()

# Define the causal relationships between Knowledge Sources
causal_graph_ks = """
digraph {
    # Threat Response Knowledge Sources
    "KS_TR1" -> {"KS_EC1", "KS_EC2"};  # Radar contributes to threat classification
    "KS_TR2" -> {"KS_EC3"};  # Sonobuoy Network assists classification
    "KS_TR3" -> {"KS_FC2"};  # Tracking system supports fleet decisions
    "KS_TR4" -> {"KS_EC1", "KS_EC3"};  # Intelligence reports refine classification
    "KS_TR5" -> {"KS_FC3"};  # Rules of engagement inform tactical AI

    # Operational Readiness Knowledge Sources
    "KS_OR1" -> {"KS_FC1"};  # Fleet readiness affects positioning
    "KS_OR2" -> {"KS_FC2"};  # Equipment status affects threat level assessment
    "KS_OR3" -> {"KS_FC3"};  # Crew fatigue influences decision models

    # Sensor Fusion Knowledge Sources
    "KS_SF1" -> {"KS_EC1"};  # Acoustic anomaly assists intelligence database
    "KS_SF2" -> {"KS_EC2"};  # Object detection refines classification
    "KS_SF3" -> {"KS_TR1", "KS_TR2"};  # Bayesian inference integrates sensor data

    # Enemy Classification Knowledge Sources
    "KS_EC1" -> {"KS_FC2"};  # Known signatures contribute to threat assessment
    "KS_EC2" -> {"KS_TR4"};  # Sensor data supports intelligence reports
    "KS_EC3" -> {"KS_FC3"};  # Classification system refines decision models

    # Fleet Coordination Knowledge Sources
    "KS_FC1" -> {"KS_TR5"};  # Defensive perimeter impacts engagement rules
    "KS_FC2" -> {"KS_TR5"};  # High threat level modifies engagement strategies
    "KS_FC3" -> {"KS_OR3"};  # Tactical AI depends on crew readiness

    # Interventions for causal inference
    "Intervention_Threat_Detection" -> "KS_EC1";
    "Intervention_Sensor_Fusion" -> "KS_SF3";
    "Intervention_Operational_Status" -> "KS_OR1";
}
"""

# Create the causal model
ks_model = CausalModel(
    graph=causal_graph_ks
)

# Visualize the causal structure
ks_model.view_model()

# Data Representation of Knowledge Sources
# Each knowledge source is explicitly mapped with its attributes.

ks_data = pd.DataFrame({
    # Threat Response KS Properties
    "KS_TR1_status": np.random.choice(["Active", "Inactive"], 100),
    "KS_TR1_detection_capability": np.random.choice(["Radar"], 100),
    "KS_TR1_range": np.random.uniform(90, 110, 100),  # 100 nautical miles with variation

    "KS_TR2_sensor_range": np.random.uniform(4, 6, 100),  # 5 nautical miles
    "KS_TR2_detection_mode": np.random.choice(["Passive", "Active"], 100),

    "KS_TR3_confirmed_tracks": np.random.randint(2, 5, 100),
    "KS_TR3_tracking_algorithm": np.random.choice(["Kalman Filter"], 100),

    "KS_TR4_recent_sightings": np.random.choice(["Enemy Submarine Detected", "No Detection"], 100),
    "KS_TR4_confidence_level": np.random.uniform(70, 90, 100),  # 80% with variance

    "KS_TR5_rules_of_engagement": np.random.choice(["Engage if Confirmed Hostile", "Hold Fire"], 100),

    # Operational Readiness KS Properties
    "KS_OR1_status": np.random.choice(["Combat Ready", "Not Ready"], 100),
    "KS_OR1_fuel_levels": np.random.uniform(75, 85, 100),  # 80% with variance
    "KS_OR1_ammunition": np.random.uniform(85, 95, 100),  # 90% with variance

    "KS_OR2_radar_status": np.random.choice(["Operational", "Non-Operational"], 100),
    "KS_OR2_sonobuoy_network": np.random.choice(["Functional", "Non-Functional"], 100),

    "KS_OR3_fatigue_level": np.random.choice(["Low", "Moderate", "High"], 100),
    "KS_OR3_crew_rotation": np.random.choice(["Scheduled", "Unscheduled"], 100),

    # Sensor Fusion KS Properties
    "KS_SF1_detection": np.random.choice(["Acoustic Anomaly Detected", "No Anomaly"], 100),
    "KS_SF1_confidence": np.random.uniform(40, 60, 100),  # 50% with variance

    "KS_SF2_detection": np.random.choice(["Object Detected at 50m", "No Object"], 100),
    "KS_SF2_classification": np.random.choice(["Unknown", "Identified"], 100),

    "KS_SF3_fusion_algorithm": np.random.choice(["Bayesian Inference"], 100),
    "KS_SF3_combined_confidence": np.random.uniform(70, 80, 100),  # 75% with variance

    # Enemy Classification KS Properties
    "KS_EC1_known_signatures": np.random.choice(["Type-212 Submarine", "Kilo-Class Submarine", "Unknown"], 100),

    "KS_EC2_acoustic_signature": np.random.choice(["Match", "No Match"], 100),
    "KS_EC2_depth": np.random.uniform(290, 310, 100),  # 300m with variance

    "KS_EC3_classification": np.random.choice(["Pending", "Completed"], 100),
    "KS_EC3_decision_threshold": np.random.uniform(85, 95, 100),  # 90% with variance

    # Fleet Coordination KS Properties
    "KS_FC1_current_formation": np.random.choice(["Defensive Perimeter", "Open Formation"], 100),

    "KS_FC2_threat_level": np.random.choice(["High", "Low"], 100),
    "KS_FC2_recommended_action": np.random.choice(["Disperse", "Hold Position"], 100),

    "KS_FC3_decision_model": np.random.choice(["Markov Decision Process"], 100)
})

# Define Causal Model for Knowledge Sources
ks_causal_model = CausalModel(
    data=ks_data,
    treatment="KS_TR1_status",
    outcome="KS_EC1_known_signatures",
    graph=causal_graph_ks
)

# Visualize
ks_causal_model.view_model()

# Define causal intervention on threat detection
# Intervention Analysis on Knowledge Sources
identified_estimand = ks_causal_model.identify_effect(
    treatment="KS_TR1_status",
    outcome="KS_EC1_known_signatures"
)

# Estimate causal effect
causal_effect = ks_causal_model.estimate_effect(
    identified_estimand,
    method_name="backdoor.linear_regression"
)

print("Causal Effect of Radar Activation on Classification:", causal_effect)

