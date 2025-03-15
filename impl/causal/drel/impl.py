import dowhy
from dowhy import CausalModel
import pandas as pd
import numpy as np

# Define the causal relationships for Dynamic Relations (DRels)
causal_graph_drels = """
digraph {
    # Dynamic Relations (DRels)
    "DRel_Threat_Sensor_Integration" -> {"KS_SF3", "KS_TR1", "KS_TR2"};
    "DRel_Fleet_Readiness_Adjustment" -> {"KS_OR1", "KS_OR2", "KS_OR3"};
    "DRel_Tactical_Threat_Assessment" -> {"KS_FC2", "KS_EC3", "KS_TR5"};
    "DRel_Intelligence_Driven_Classification" -> {"KS_EC3", "KS_EC1", "KS_TR4"};
    "DRel_Fleet_Positioning" -> {"KS_FC1", "KS_FC2", "KS_FC3"};
    "DRel_Command_Decisions" -> {"KS_TR5", "KS_SF3", "KS_FC2"};

    # Causal steps in Threat Sensor Integration
    "Step_1_Sensor_Fusion" -> {"KS_SF3"};
    "Step_2_Radar_Integration" -> {"KS_TR1"};
    "Step_3_Sonobuoy_Integration" -> {"KS_TR2"};

    # Causal steps in Fleet Readiness Adjustment
    "Step_1_Operational_Status" -> {"KS_OR1", "KS_OR2"};
    "Step_2_Crew_Fatigue_Assessment" -> {"KS_OR3"};

    # Causal steps in Tactical Threat Assessment
    "Step_1_Threat_Classification" -> {"KS_EC3"};
    "Step_2_Engagement_Decision" -> {"KS_TR5"};

    # Causal steps in Intelligence-Driven Classification
    "Step_1_Threat_Signatures" -> {"KS_EC1"};
    "Step_2_Historical_Engagement" -> {"KS_TR4"};

    # Causal steps in Fleet Positioning Based on Threats
    "Step_1_Threat_Severity_Assessment" -> {"KS_FC2"};
    "Step_2_Fleet_Formation_Update" -> {"KS_FC1", "KS_FC3"};

    # Causal steps in Command Decisions Based on Sensor Fusion
    "Step_1_Detection_Confidence" -> {"KS_SF3"};
    "Step_2_Threat_Assessment" -> {"KS_FC2"};

    # Interventions for causal inference
    "Intervention_Sensor_Activation" -> "Step_1_Sensor_Fusion";
    "Intervention_Fleet_Status" -> "Step_1_Operational_Status";
    "Intervention_Threat_Decision" -> "Step_2_Engagement_Decision";
}
"""

# Create the causal model
drel_model = CausalModel(
    graph=causal_graph_drels
)

# Visualize the causal structure
drel_model.view_model()
\end{lstlisting}


\begin{lstlisting}[language=Python]
# Data Representation of DRel Steps
# Data Representation of Dynamic Relations (DRels)
# Each DRel step is explicitly mapped with its attributes.

drel_data = pd.DataFrame({
    # Threat Sensor Integration DRel
    "Step_1_Sensor_Fusion_SF3": np.random.choice(["AI Fusion System", "No Fusion"], 100),
    "Step_2_Radar_Integration_TR1": np.random.choice(["Radar APS-124", "No Radar"], 100),
    "Step_3_Sonobuoy_Integration_TR2": np.random.choice(["Sonobuoy Network", "No Data"], 100),

    # Fleet Readiness Adjustment DRel
    "Step_1_Operational_Status_OR1": np.random.choice(["Fleet Ready", "Not Ready"], 100),
    "Step_1_Operational_Status_OR2": np.random.choice(["Equipment Operational", "Equipment Failure"], 100),
    "Step_2_Crew_Fatigue_Assessment_OR3": np.random.choice(["Crew Ready", "Fatigued"], 100),

    # Tactical Threat Assessment DRel
    "Step_1_Threat_Classification_EC3": np.random.choice(["Classification System", "No Classification"], 100),
    "Step_2_Engagement_Decision_TR5": np.random.choice(["Command Center Decision", "No Decision"], 100),

    # Intelligence-Driven Classification DRel
    "Step_1_Threat_Signatures_EC1": np.random.choice(["Known Threat Signatures", "Unknown"], 100),
    "Step_2_Historical_Engagement_TR4": np.random.choice(["Intelligence Reports", "No Report"], 100),

    # Fleet Positioning Based on Threats DRel
    "Step_1_Threat_Severity_Assessment_FC2": np.random.choice(["High Threat", "Low Threat"], 100),
    "Step_2_Fleet_Formation_Update_FC1": np.random.choice(["Fleet Position Adjusted", "No Adjustment"], 100),
    "Step_2_Fleet_Formation_Update_FC3": np.random.choice(["Tactical AI Decision", "No Decision"], 100),

    # Command Decisions Based on Sensor Fusion DRel
    "Step_1_Detection_Confidence_SF3": np.random.choice(["High Confidence Detection", "Low Confidence"], 100),
    "Step_2_Threat_Assessment_FC2": np.random.choice(["Threat Confirmed", "Threat Unconfirmed"], 100),
})

# Define Causal Model for Dynamic Relations
drel_causal_model = CausalModel(
    data=drel_data,
    treatment="Step_1_Sensor_Fusion_SF3",
    outcome="Step_2_Engagement_Decision_TR5",
    graph=causal_graph_drels
)

# Visualize
drel_causal_model.view_model()
\end{lstlisting}

\begin{lstlisting}[language=Python]
# Define causal intervention on sensor fusion
# Intervention Analysis on Dynamic Relations
identified_estimand = drel_causal_model.identify_effect(
    treatment="Step_1_Sensor_Fusion_SF3",
    outcome="Step_2_Engagement_Decision_TR5"
)

# Estimate causal effect
causal_effect = drel_causal_model.estimate_effect(
    identified_estimand,
    method_name="backdoor.linear_regression"
)

print("Causal Effect of AI Fusion System on Engagement Decision:", causal_effect)

