import numpy as np
import networkx as nx
import dowhy
from dowhy import CausalModel
import pandas as pd
import random

# --- Step 1: Generate Simulated Naval Scenario Data ---

# 17 Causal Nodes (KS-TR1 to KS-FC3)
# Represents knowledge sources in the naval scenario
causal_nodes = [
    "KS-TR1", "KS-TR2", "KS-TR3", "KS-TR4", "KS-TR5", "KS-TR6",
    "KS-TR7", "KS-TR8", "KS-TR9", "KS-TR10", "KS-TR11", "KS-TR12",
    "KS-TR13", "KS-TR14", "KS-TR15", "KS-TR16", "KS-FC3"
]

# 14 Edges (Causal Relations)
# Defines causal influences between nodes
causal_edges = [
    ("KS-TR1", "KS-TR5"),   # Edge #1
    ("KS-TR2", "KS-TR6"),   # Edge #2
    ("KS-TR3", "KS-TR7"),   # Edge #3
    ("KS-TR4", "KS-TR8"),   # Edge #4
    ("KS-TR5", "KS-TR9"),   # Edge #5
    ("KS-TR6", "KS-TR10"),  # Edge #6
    ("KS-TR7", "KS-TR11"),  # Edge #7
    ("KS-TR8", "KS-TR12"),  # Edge #8
    ("KS-TR9", "KS-TR13"),  # Edge #9
    ("KS-TR10", "KS-TR14"), # Edge #10
    ("KS-TR11", "KS-TR15"), # Edge #11
    ("KS-TR12", "KS-TR16"), # Edge #12
    ("KS-TR15", "KS-FC3"),  # Edge #13
    ("KS-TR16", "KS-FC3")   # Edge #14
]

# --- Step 2: Define Probabilistic Dependencies (11 Bayesian Dependencies) ---
probabilistic_dependencies = {
    "KS-TR1": 0.7, "KS-TR2": 0.6, "KS-TR3": 0.75, "KS-TR4": 0.5, "KS-TR5": 0.65,
    "KS-TR6": 0.55, "KS-TR7": 0.8, "KS-TR8": 0.45, "KS-TR9": 0.7, "KS-TR10": 0.6,
    "KS-TR11": 0.65
}

# --- Step 3: Define Bayesian Fusion Links (10 Links) ---
# These integrate probability data to refine causal inference
bayesian_fusion_links = [
    ("KS-TR1", "KS-TR3"),  # Link #1
    ("KS-TR2", "KS-TR4"),  # Link #2
    ("KS-TR5", "KS-TR7"),  # Link #3
    ("KS-TR6", "KS-TR8"),  # Link #4
    ("KS-TR9", "KS-TR11"), # Link #5
    ("KS-TR10", "KS-TR12"),# Link #6
    ("KS-TR13", "KS-TR15"),# Link #7
    ("KS-TR14", "KS-TR16"),# Link #8
    ("KS-TR15", "KS-FC3"), # Link #9
    ("KS-TR16", "KS-FC3")  # Link #10
]

# --- Step 4: Define Markov Dependencies (5 Time-Sequenced Causal Links) ---
markov_dependencies = [
    ("KS-TR5", "KS-TR6"),  # Dependency #1
    ("KS-TR7", "KS-TR8"),  # Dependency #2
    ("KS-TR9", "KS-TR10"), # Dependency #3
    ("KS-TR11", "KS-TR12"),# Dependency #4
    ("KS-TR13", "KS-TR14") # Dependency #5
]

# --- Step 5: Define Historical Data Intelligence Refinement (4 Adjustments) ---
historical_data_refinement = [
    ("KS-TR1", "KS-TR9"),  # Refinement #1
    ("KS-TR3", "KS-TR11"), # Refinement #2
    ("KS-TR6", "KS-TR15"), # Refinement #3
    ("KS-TR8", "KS-FC3")   # Refinement #4
]

# --- Step 6: Create DoWhy Causal Model ---

# Generate sample data
np.random.seed(42)
data = pd.DataFrame({
    "KS-TR1": np.random.binomial(1, probabilistic_dependencies["KS-TR1"], 1000),
    "KS-TR2": np.random.binomial(1, probabilistic_dependencies["KS-TR2"], 1000),
    "KS-TR3": np.random.binomial(1, probabilistic_dependencies["KS-TR3"], 1000),
    "KS-TR4": np.random.binomial(1, probabilistic_dependencies["KS-TR4"], 1000),
    "KS-TR5": np.random.binomial(1, probabilistic_dependencies["KS-TR5"], 1000),
    "KS-FC3": np.random.binomial(1, 0.5, 1000)  # Final outcome
})

# Define causal model
model = CausalModel(
    data=data,
    treatment="KS-TR1",
    outcome="KS-FC3",
    common_causes=["KS-TR2", "KS-TR3", "KS-TR4", "KS-TR5"]
)

# Identify causal effect
identified_estimand = model.identify_effect()
print(identified_estimand)

# Estimate causal effect using Propensity Score Matching
estimate = model.estimate_effect(identified_estimand, method_name="backdoor.propensity_score_matching")
print("Causal Effect Estimate:", estimate)

# --- Step 7: Validate Causal Model ---
model.refute_estimate(identified_estimand, estimate, method_name="random_common_cause")


