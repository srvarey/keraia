import dowhy
from dowhy import CausalModel
import pandas as pd
import numpy as np

# Define the causal relationships for Junctures and Dimensions
causal_graph_junctures = """
digraph {
    # Juncture Nodes
    "Threat_Detection" -> {"Sensor_Data_Processing"};
    "Threat_Classification" -> {"Threat_Evaluation"};
    "Sensor_Fusion" -> {"Multi_Sensor_Integration"};
    "Operational_Readiness" -> {"Readiness_Assessment"};
    "Tactical_Decision" -> {"Decision_Execution"};
    "Fleet_Coordination" -> {"Fleet_Adaptation"};
    
    # Sensor Data Processing
    "Sensor_Data_Processing" -> {"KS_TR1", "KS_TR2", "KS_SF1", "KS_SF2"};

    # Threat Evaluation
    "Threat_Evaluation" -> {"KS_EC1", "KS_EC2", "KS_EC3", "KS_TR3", "KS_TR4"};

    # Multi-Sensor Integration
    "Multi_Sensor_Integration" -> {"KS_SF1", "KS_SF2", "KS_SF3", "KS_TR3"};

    # Readiness Assessment
    "Readiness_Assessment" -> {"KS_OR1", "KS_OR2", "KS_OR3"};

    # Decision Execution
    "Decision_Execution" -> {"KS_FC2", "KS_FC3", "KS_TR5"};

    # Fleet Adaptation
    "Fleet_Adaptation" -> {"KS_FC1", "KS_FC2", "KS_FC3"};

    # Interventions for causal inference
    "Intervention_Sensor_Optimization" -> "Sensor_Data_Processing";
    "Intervention_Threat_Model_Update" -> "Threat_Evaluation";
    "Intervention_Multi_Sensor_Calibration" -> "Multi_Sensor_Integration";
    "Intervention_Readiness_Check" -> "Readiness_Assessment";
    "Intervention_Tactical_Simulation" -> "Decision_Execution";
    "Intervention_Fleet_Repositioning" -> "Fleet_Adaptation";
}
"""

# Create the causal model
junctures_model = CausalModel(
    graph=causal_graph_junctures
)

# Visualize the causal structure
junctures_model.view_model()
\end{lstlisting}


\begin{lstlisting}[language=Python]
# Data Representation of Junctures and Dimensions

junctures_data = pd.DataFrame({
    "Sensor_Data_Processing": np.random.choice(["Processed", "Not Processed"], 100),
    "Threat_Evaluation": np.random.choice(["Evaluated", "Not Evaluated"], 100),
    "Multi_Sensor_Integration": np.random.choice(["Integrated", "Not Integrated"], 100),
    "Readiness_Assessment": np.random.choice(["Checked", "Unchecked"], 100),
    "Decision_Execution": np.random.choice(["Executed", "Not Executed"], 100),
    "Fleet_Adaptation": np.random.choice(["Adapted", "Not Adapted"], 100),
})

# Define Causal Model for Junctures and Dimensions
junctures_causal_model = CausalModel(
    data=junctures_data,
    treatment="Threat_Evaluation",
    outcome="Decision_Execution",
    graph=causal_graph_junctures
)

# Visualize
junctures_causal_model.view_model()
\end{lstlisting}

\begin{lstlisting}[language=Python]
# Define causal intervention on threat evaluation process
# Intervention Analysis on Junctures and Dimensions
identified_estimand = junctures_causal_model.identify_effect(
    treatment="Threat_Evaluation",
    outcome="Decision_Execution"
)

# Estimate causal effect
causal_effect = junctures_causal_model.estimate_effect(
    identified_estimand,
    method_name="backdoor.linear_regression"
)

print("Causal Effect of Threat Evaluation on Decision Execution:", causal_effect)

