
# Define the causal relationships between LoTs and KS
causal_graph_lot = """
digraph {
    # Lines of Thought (LoT)
    "LoT_Threat_Detection_and_Classification" -> {"KS_TR1", "KS_TR2", "KS_TR3", "KS_SF1", "KS_SF3", "KS_EC1", "KS_EC2", "KS_EC3", "KS_TR4", "KS_TR5"};
    "LoT_Operational_Readiness_Assessment" -> {"KS_OR1", "KS_OR2", "KS_OR3", "KS_FC1", "KS_FC2", "KS_FC3", "KS_TR5"};
    "LoT_Sensor_Fusion_for_Decision_Making" -> {"KS_SF1", "KS_SF2", "KS_SF3", "KS_EC1", "KS_EC3"};
    "LoT_Fleet_Coordination_and_Threat_Response" -> {"KS_FC1", "KS_FC2", "KS_FC3", "KS_TR4", "KS_TR5"};

    # Causal steps in Threat Detection and Classification
    "Step_1_Initial_Detection" -> {"KS_TR1", "KS_TR2"};
    "Step_2_Tracking_and_Fusion" -> {"KS_TR3", "KS_SF1", "KS_SF3"};
    "Step_3_Classification" -> {"KS_EC1", "KS_EC2", "KS_EC3"};
    "Step_4_Threat_Confirmation" -> {"KS_TR4", "KS_TR5"};

    # Causal steps in Operational Readiness Assessment
    "Step_1_Status_Assessment" -> {"KS_OR1", "KS_OR2", "KS_OR3"};
    "Step_2_Mission_Feasibility" -> {"KS_FC1", "KS_FC2"};
    "Step_3_Final_Decision" -> {"KS_FC3", "KS_TR5"};

    # Causal steps in Sensor Fusion for Decision Making
    "Step_1_Data_Collection" -> {"KS_SF1", "KS_SF2"};
    "Step_2_Data_Integration" -> {"KS_SF3"};
    "Step_3_Threat_Classification" -> {"KS_EC1", "KS_EC3"};

    # Causal steps in Fleet Coordination and Threat Response
    "Step_1_Threat_Analysis" -> {"KS_FC2", "KS_EC3"};
    "Step_2_Fleet_Adjustment" -> {"KS_FC1", "KS_FC3"};
    "Step_3_Engagement_Decision" -> {"KS_TR5", "KS_TR4"};

    # Interventions for causal inference
    "Intervention_Sensor_Data" -> "Step_1_Initial_Detection";
    "Intervention_Threat_Tracking" -> "Step_2_Tracking_and_Fusion";
    "Intervention_Tactical_Decision" -> "Step_3_Final_Decision";
}
"""

# Create the causal model
lot_model = CausalModel(
    graph=causal_graph_lot
)

# Visualize the causal structure
lot_model.view_model()
\end{lstlisting}


\begin{lstlisting}[language=Python]
# Data Representation of LoT Steps
# Each LoT step is explicitly mapped with its attributes.

lot_data = pd.DataFrame({
    # Threat Detection and Classification LoT
    "Step_1_Initial_Detection_TR1": np.random.choice(["Radar", "No Detection"], 100),
    "Step_1_Initial_Detection_TR2": np.random.choice(["Sonobuoy Network", "No Detection"], 100),

    "Step_2_Tracking_and_Fusion_TR3": np.random.choice(["Tracking System", "No Track"], 100),
    "Step_2_Tracking_and_Fusion_SF1": np.random.choice(["Sonobuoy Data", "No Data"], 100),
    "Step_2_Tracking_and_Fusion_SF3": np.random.choice(["AI Fusion System", "No Fusion"], 100),

    "Step_3_Classification_EC1": np.random.choice(["Intelligence Database", "No Match"], 100),
    "Step_3_Classification_EC2": np.random.choice(["Sensor Data", "No Data"], 100),
    "Step_3_Classification_EC3": np.random.choice(["Classification System", "No Classification"], 100),

    "Step_4_Threat_Confirmation_TR4": np.random.choice(["Intelligence Reports", "No Report"], 100),
    "Step_4_Threat_Confirmation_TR5": np.random.choice(["Command Centre", "No Decision"], 100),

    # Operational Readiness Assessment LoT
    "Step_1_Status_Assessment_OR1": np.random.choice(["Fleet Ready", "Not Ready"], 100),
    "Step_1_Status_Assessment_OR2": np.random.choice(["Equipment Operational", "Equipment Failure"], 100),
    "Step_1_Status_Assessment_OR3": np.random.choice(["Crew Ready", "Fatigued"], 100),

    "Step_2_Mission_Feasibility_FC1": np.random.choice(["Fleet Positioning System", "Not Available"], 100),
    "Step_2_Mission_Feasibility_FC2": np.random.choice(["Threat Level Assessment", "No Assessment"], 100),

    "Step_3_Final_Decision_FC3": np.random.choice(["Tactical AI Decision", "No Decision"], 100),
    "Step_3_Final_Decision_TR5": np.random.choice(["Command Centre Order", "No Order"], 100),

    # Sensor Fusion for Decision Making LoT
    "Step_1_Data_Collection_SF1": np.random.choice(["Sonobuoy Data", "No Data"], 100),
    "Step_1_Data_Collection_SF2": np.random.choice(["Radar Contacts", "No Contacts"], 100),

    "Step_2_Data_Integration_SF3": np.random.choice(["AI Fusion System", "No Integration"], 100),

    "Step_3_Threat_Classification_EC1": np.random.choice(["Intelligence Database", "No Match"], 100),
    "Step_3_Threat_Classification_EC3": np.random.choice(["Classification System", "No Classification"], 100),

    # Fleet Coordination and Threat Response LoT
    "Step_1_Threat_Analysis_FC2": np.random.choice(["Threat Level Assessment", "No Assessment"], 100),
    "Step_1_Threat_Analysis_EC3": np.random.choice(["Classification System", "No Classification"], 100),

    "Step_2_Fleet_Adjustment_FC1": np.random.choice(["Fleet Positioning System", "No Positioning"], 100),
    "Step_2_Fleet_Adjustment_FC3": np.random.choice(["Tactical AI Decision", "No Decision"], 100),

    "Step_3_Engagement_Decision_TR5": np.random.choice(["Command Centre", "No Command"], 100),
    "Step_3_Engagement_Decision_TR4": np.random.choice(["Intelligence Reports", "No Report"], 100),
})

# Define Causal Model for Lines of Thought
lot_causal_model = CausalModel(
    data=lot_data,
    treatment="Step_1_Initial_Detection_TR1",
    outcome="Step_3_Threat_Classification_EC1",
    graph=causal_graph_lot
)

# Visualize
lot_causal_model.view_model()
\end{lstlisting}

\begin{lstlisting}[language=Python]
# Intervention Analysis on Lines of Thought
# Define causal intervention on initial detection
identified_estimand = lot_causal_model.identify_effect(
    treatment="Step_1_Initial_Detection_TR1",
    outcome="Step_3_Threat_Classification_EC1"
)

# Estimate causal effect
causal_effect = lot_causal_model.estimate_effect(
    identified_estimand,
    method_name="backdoor.linear_regression"
)

print("Causal Effect of Radar Activation on Classification:", causal_effect)
