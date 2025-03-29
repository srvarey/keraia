```
goal MainGoal: achieve [goal] PumpOperatesCorrectly;

fact AlarmCode.        : 51;
fact HasServiceKit     : true;
fact HasDismantleGuide : true;
fact HasManual         : true;


#### Knowledge Sources and Clouds

knowledge PumpStatus {
  attributes: {
    isBlocked: boolean;
    hasForeignObjects: boolean;
    electricalStatus: string; // "connected", "disconnected"
  };
}

knowledge EngineerCredentials {
  validated: boolean;
}


#### Enhanced Plans with ATMS Nodes and Justifications

plan MainDiagnosticPlan {
  goal: MainGoal;

  body: {
    execute [explanation] ValidateEngineersCredentials;

    execute [forward] AutomaticResetAndRestart;

    if not Solved {
      execute [dialogue] AskRemoveInletAndDischarge;

      when Answer == "No" {
        advise [causal] ContactServiceCenter;
      }

      when Answer == "Yes" {
        achieve [procedural] CheckForForeignObjects;

        if HasForeignObjects {
          perform [anomaly] ObjectRemovalProcedure;
        } else {
          // Fork to explore issues beyond mechanical obstructions.
          fork {
            path ElectricalIssue: {
              achieve [procedural] CheckElectricalConnections;
              if ElectricalFaultFound {
                perform [anomaly] FixElectricalFault;
              } else {
                advise [explanation] ConsultElectricalEngineer;
              }
            }

            path SoftwareIssue: {
              achieve [procedural] CheckPumpSoftware;
              if SoftwareUpdateRequired {
                perform [forward] UpdatePumpSoftware;
              } else {
                advise [explanation] MonitorForUnusualBehavior;
              }
            }

            // If neither path resolves the issue, consider a complete system 
            // overhaul.
            defaultPath: {
              atms_node "CompleteOverhaul" {
                  justification: 
                    "Electrical and software diagnostics did not reveal 
                    the fault's cause.";
                  assumptions: [
                    "Electrical and software diagnostics did not reveal 
                    the fault's cause.", 
                    "Mechanical components might be internally damaged 
                    or worn out."
                 ];
              }
              follow [analogy] DismantleAndReassembleGuide;
            }
          } // End of fork construct
        }

        atms_node "SystemRestart" {
              justification: 
                    "A restart is required to apply fixes and reevaluate 
                    the pump's operational status.";
              assumptions: [
               "A restart may resolve temporary glitches or issues 
               affecting pump performance."
              ];
        }
        execute [forward] RestartPump;

        atms_node "FinalCheck" {
              justification: 
                    "Ensures all issues are resolved and the pump 
                    operates correctly.";
              assumptions: [
                "All potential faults have been addressed.",
                "The pump should now operate without any issues."
              ];
        }
        ensure [causal] NoAlarms;

        atms_node "Reporting" {
          justification: 
                "Documentation of actions and outcomes supports 
                accountability and future reference.";
          assumptions: [
            "A detailed report helps in tracking the resolution 
            process.",
            "Documentation aids in future troubleshooting and 
            accountability."
          ];
        }
        report [explanation] ActionTaken;      }
    }
  }
}
```
