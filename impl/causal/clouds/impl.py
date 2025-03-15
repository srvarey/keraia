# Setup
# Define the causal relationships in a graph format
causal_graph = """
digraph {
    # Clouds of Knowledge
    "Threat_Response" -> {"KS_TR1", "KS_TR2", "KS_TR3", "KS_TR4", "KS_TR5"};
    "Operational_Readiness" -> {"KS_OR1", "KS_OR2", "KS_OR3"};
    "Sensor_Fusion" -> {"KS_SF1", "KS_SF2", "KS_SF3"};
    "Enemy_Classification" -> {"KS_EC1", "KS_EC2", "KS_EC3"};
    "Fleet_Coordination" -> {"KS_FC1", "KS_FC2", "KS_FC3"};

    # Lines of Thought
    "LoT_Threat_Detection" -> {"KS_TR1", "KS_TR2"};
    "LoT_Tracking" -> {"KS_TR3", "KS_SF1", "KS_SF3"};
    "LoT_Classification" -> {"KS_EC1", "KS_EC2", "KS_EC3"};

    # Dynamic Relations
    "Threat_Sensor_Integration" -> {"KS_SF3", "KS_TR1"};
    "Threat_Classification" -> {"KS_FC2", "KS_EC3"};
    "Fleet_Positioning" -> {"KS_FC1", "KS_FC2"};

    # Interventions
    "Intervention_Threat_Level" -> "Threat_Response";
    "Intervention_Fleet_Position" -> "Fleet_Coordination";
}
"""

# Create the causal model
model = CausalModel(
    graph=causal_graph
)


# Data Representation for Clouds of Knowledge
data = pd.DataFrame({
    "Threat_Response": np.random.choice(["Active", "Inactive"], 100),
    "Operational_Readiness": np.random.choice(["Ready", "Not Ready"], 100),
    "Sensor_Fusion": np.random.choice(["Functional", "Non-Functional"], 100),
    "Enemy_Classification": np.random.choice(["Identified", "Unknown"], 100),
    "Fleet_Coordination": np.random.choice(["Coordinated", "Uncoordinated"], 100)
})

# Define the causal model for clouds
clouds_model = CausalModel(
    data=data,
    treatment="Threat_Response",
    outcome="Fleet_Coordination",
    graph=causal_graph
)

# Visualize
clouds_model.view_model()

