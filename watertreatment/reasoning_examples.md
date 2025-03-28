
## 1. Forward Chaining Example

```java
//Objective: Automatically adjust treatment processes based on water quality data.
{
    input_set_1 = {		
        WaterTreatmentInput = {
              knowledge_source WaterQualityData  = {
                pH:        "7.4";
                turbidity: "3.2 NTU";
              },
              TreatmentRules = {
                alkalineAdjustment:    "if pH < 6.5 then AddAlkaline";
                acidAdjustment:        "if pH > 8.5 then AddAcid";
                filtrationAdjustment:  "if turbidity > 5 NTU then IncreaseFiltration";
             }
         } 
      }

   Execute = {
        Paradigm: "rule_engine",
        block : 2
    },   
}
```

---

## 2. Procedural Reasoning Example

```java
//Objective: Guide through a step-by-step pump troubleshooting procedure.

{
    input_set_2 = {
         PumpTroubleshootingInput = {
            PumpStatus  = {
                Operational: "False",
                ErrorCodes: ["E101"]
            }
          },
          kline  = {
            TroubleshootingProcedure = {
                path: "CheckElectricalConnections/FixWiringIssues/VerifyOperation";
            }
          },
       Execute = {
            Paradigm: "PRS",
            block : 2,
            goal: PumpTroubleshootingInput,
        },  
      }
}
```

---

## 3. Causal Reasoning Example

```java
//Objective: Diagnose the root cause of a decrease in water flow rate.

input_set_3 = {
  FlowRateDiagnosisInput {
      knowledge_source FlowRateData {
        CurrentRate: "50% of expected";
      },
      knowledge_source PotentialCauses {
        CloggedFilter: "if turbidity high then CheckFilter";
        PipeLeakage: "if pressure drop then InspectPipes";
      },
      Execute = {
            Paradigm: "causal",
            block : 2,
            goal: FlowRateDiagnosisInput,
      },  
    }
}
```

---

## 4. Explanation-Based Reasoning Example

```java
//Objective: Explain the effectiveness of a water treatment strategy.

{
    input_set_4 = { 
        StrategyEffectivenessInput = {
           TreatmentStrategy = {
            Method: "UV Disinfection",
            Efficacy: "99.9% pathogen removal"
          },
          ScientificBasis = {
            UVExposure: "Destroys microbial DNA"
          }
        }
    },
       Execute = {
        Paradigm: "expalanation",
        block : 2
    },   
}
```

---

## 5. Reasoning by Analogy Example

```java
//Objective: Apply strategies from similar past water treatment scenarios.

{
    input_set_5 = {
        SimilarScenariosInput = {
            HistoricalCases = {
               Case1: "Phosphate removal using chemical precipitation",
               Case2: "Nitrate reduction with ion exchange"
            }

        },
       
        CurrentIssue = {
           Issue: "Excessive phosphate"
        },
        Execute = {
            Paradigm: "analogy",
            block : 2,
            explanation: "SimilarScenariosInput"
        } 
      }
}
```

---

## 6. Anomaly Detection Example

```java
//Objective: Monitor water quality for unexpected changes.

{
    input_set_6 = {
        QualityMonitoringInput = {
           WaterQualityMetrics = {
            pH: "7.8",
            turbidity: "0.5 NTU",
            contaminants: "None detected"
          },
          AnomalyThresholds = {
            pHRange: "6.5 to 8.5",
            turbidityLimit: "5 NTU"
          }
      },
      Execute = {
        Paradigm: "anomaly",
        block : 2,
        goal: "QualityMonitoringInput"
    }
   }
}
```
