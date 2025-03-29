# Aircraft Carrier Group

| **Knowledge Source**     | **Value**                            |
|--------------------------|--------------------------------------|
| Type                     | Aircraft Carrier                     |
| Class                    | Nimitz-class                         |
| Location                 | Mediterranean Sea                   |
| Mission                  | Air Support and Force Projection     |
| Speed                    | 30 knots                             |
| Status                   | Launching Aircraft                   |
| Armament                 | F/A-18 Jets, CIWS                    |
| Detected Threats         | Underwater Anomalies                 |
| Communication State      | Active                               |
| Support Vessels          | Cruisers, Destroyers, Supply Ships   |

---

## KSYNTH Representation (Java)

```java
Cloud Aircraft_Carrier_Group = new Cloud("Aircraft_Carrier_Group");
Aircraft_Carrier_Group.addKS("Type")
        .addA("Aircraft Carrier");
Aircraft_Carrier_Group.addKS("Class")
        .addA("Nimitz-class");
Aircraft_Carrier_Group.addKS("Location")
        .addA("Mediterranean Sea");
Aircraft_Carrier_Group.addKS("Mission")
        .addA("Air Support and Force Projection");
Aircraft_Carrier_Group.addKS("Speed")
        .addA(30)
        .addV("Units")
        .addA("knots");
Aircraft_Carrier_Group.addKS("Status")
        .addA("Launching Aircraft");
Aircraft_Carrier_Group.addKS("Armament")
        .addA("F/A-18 Jets")
        .addA("CIWS");
Aircraft_Carrier_Group.addKS("Detected_Threats")
        .addA("Underwater Anomalies");
Aircraft_Carrier_Group.addKS("Communication_State")
        .addA("Active");
Aircraft_Carrier_Group.addKS("Support Vessels")
        .addA("Cruisers")
        .addA("Destroyers")
        .addA("Supply Ships");
```
