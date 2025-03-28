
# Blocked Pump Diagnosis and Troubleshooting

```java
/*
HYPOTHESIS:
    The pump is blocked

EVIDENCE:
    Sensor
    High temperature
    Current
    Vibration
    Flow : low
    Physical
    Hot : Using thermometer check temperature (IR)
    Noise : Abnormal
    Environment
    Can Water source be checked
    Contamination in water source of product that shouldn’t be there. (e.g. oil)

RISK MITIGATION

ASSUMPTION:
    Utilize evidence from inbuilt sensors
    Human interaction forms clarification (sensors touch, sight, smell)
    WTS only using chatbot for our service engineers
    Suitably experienced
    Pump solutions only
    Exit is callWTS expert knowledge
*/

GOALS:
    ACHIEVE free_the_pump_to_operate_correctly;

FACTS:
    FACT AlarmCode "51";

Plan : {

NAME : 
    "Blocked pump Alarm"

GOAL :
    ACHIEVE free_the_pump_to_operate_correctly;

PRECONDITION : 
    FACT AlarmCode "51";
     
BODY :
    EXECUTE Validate_engineers_credentials;
    ASSIGN $ans1 1 1 "Automatic reset and restart. Did this solve the problem? ";
    EXECUTE YN $ans1;
    WHEN: TEST (== $ans1 "Y"){
        EXECUTE println "Done";
    };
    WHEN: TEST (== $ans1 "N"){
        ASSIGN $ans2 1 1 "Can you remove the inlet and discharge?"
        EXECUTE YN $ans2;
        
        WHEN: TEST (== $ans2 "Y"){
            ASSIGN $kit 1 1 "Would you like to order service kit?"
            WHEN: TEST (== $kit "N"){
                EXECUTE order_service_kit
            }
            EXECUTE Remove_the_inlet_and_discharge;
            EXECUTE Visually_inspect_inside_pipework_and_pump_inlet_and_discharge;
            ASSIGN $ans3 1 1 "Can you see anything?"
            EXECUTE YN $ans3;
            WHEN: TEST (== $ans3 "N"){
                EXECUTE eletrically_disconnect_pump;
                EXECUTE Dismantle_the_pump;
                ASSIGN $guidance 1 1 "Do you need step by step guidance?";
                EXECUTE YN $guidance;
                WHEN: TEST (== $guidance "Y"){
                    EXECUTE Chatbox_explain;
                };
                ASSIGN $manual 1 1 "Do you need manual?";
                EXECUTE YN $manual;
                WHEN: TEST (== $manual "Y"){
                    EXECUTE Retrieve_O&M_Manual_parts_list;
                };
                EXECUTE Reassemble;
                EXECUTE Reinstall;
                EXECUTE eletrically reconnect pump;
            };
            WHEN: TEST (== $ans3 "N"){
                EXECUTE println "eletrically disconnect pump";
            };
            EXECUTE Remove_any_foreign_matter_or_impurities_preventing_the_pump_from_rotating.;
            EXECUTE Eletrically_reconnect_pump;
            EXECUTE Restart;
            EXECUTE Ensure_all_alarms_have_disappeared;
            EXECUTE Review_and_submit_report; 
        };
        
        WHEN: TEST (== $ans2 "N"){
            EXECUTE println "Remove to GF service centre";
        };
    }
}
```
