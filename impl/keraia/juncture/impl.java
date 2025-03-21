In the java keraia implementation 
there are 17 objects (knowledge sources) :

1 KS-TR1
2 KS-TR2
3 KS-TR3
4 KS-TR4
5 KS-TR5
6 KS-OR1
7 KS-OR2
8 KS-OR3
9 KS-SF1
10 KS-SF2
11 KS-SF3
12 KS-EC1
13 KS-EC2
14 KS-EC3
15 KS-FC1
16 KS-FC2
17 KS-FC3

and 59 properties :
1. classification: lot Threat Detection and Classification, KS SF2, KS EC3, KS EC1,
KS EC2, KS TR4, KS TR5
18
2. combined confidence: KS SF3
3. confidence level: KS TR4
4. confirmed tracks: KS TR3
5. decision threshold: KS EC3
6. detection capability: KS TR1
7. detection mode: KS TR2
8. detection: KS SF1, KS SF2, KS TR1, KS TR2
9. formation: KS FC1
10. fusion algorithm: KS SF3
11. maneuver strategy: lot Fleet Coordination and Threat Response
12. range: KS TR1
13. recent sightings: KS TR4
14. recommended action: KS FC2
15. rules of engagement: KS TR5
16. sensor range: KS TR2
17. status: KS OR1, KS TR1, KS TR5, KS OR2, KS OR3, KS FC1, KS FC2, KS FC3
18. threat level: KS FC2, KS TR4
19. tracking algorithm: KS TR3
20. known signatures: KS EC1
21. operational status: KS OR1
22. crew fatigue level: KS OR3
23. historical engagement data: KS TR4
24. engagement decision: KS TR5
25. sensor accuracy: KS SF1, KS SF2
26. high-confidence detection: KS SF3
27. mission feasibility: lot Operational Readiness Assessment
28. fleet formation: KS FC1, KS FC3
29. threat assessment: KS FC2
30. decision priority: KS TR5, KS FC3
19
31. type: KS TR1, KS TR2, KS TR3, KS TR4, KS TR5, KS OR1, KS OR2, KS OR3,
KS SF1, KS SF2, KS SF3, KS EC1, KS EC2, KS EC3, KS FC1, KS FC2, KS FC3,
threat Response, Operational Readiness,
Sensor Fusion, Enemy Classification, Fleet Coordination,
lot Threat Detection and Classification,
lot Operational Readiness Assessment,
lot Sensor Fusion for Decision Making, lot Fleet Coordination and Threat Response
32. sensors: KS TR1, KS TR2
33. fuel levels: KS OR1
34. ammunition: KS OR1
35. radar: KS OR2
36. sonobuoy network: KS OR2
37. fatigue level: KS OR3
38. crew rotation: KS OR3
39. confidence: KS SF1
40. acoustic signature: KS EC2
41. depth: KS EC2
42. current formation: KS FC1
43. decision model: KS FC3
44. step-1: lot Threat Detection and Classification,
lot Operational Readiness Assessment,
lot Sensor Fusion for Decision Making,
lot Fleet Coordination and Threat Response
45. step-2: lot Threat Detection and Classification,
lot Operational Readiness Assessment,
lot Sensor Fusion for Decision Making,
lot Fleet Coordination and Threat Response
46. step-3: lot Threat Detection and Classification,
lot Operational Readiness Assessment,
lot Sensor Fusion for Decision Making,
lot Fleet Coordination and Threat Response
47. step-4: lot Threat Detection and Classification,
lot Operational Readiness Assessment,
lot Sensor Fusion for Decision Making,
lot Fleet Coordination and Threat Response
20
48. Threat Detection: Juncture
49. Threat Classification: Juncture
50. Sensor Fusion for Threat Confirmation: Juncture
51. Operational Readiness Assessment: Juncture
52. Tactical Decision Making: Juncture
53. Fleet Coordination: Juncture
54. Sensor Data Processing: Dimension
55. Threat Evaluation: Dimension
56. Multi-Sensor Integration: Dimension
57. Readiness Assessment: Dimension
58. Decision Execution: Dimension
59. Fleet Adaptation: Dimension

The first item is the property and the second the object to which it belongs (which may be many since different objects may have the same property name)

There are 24 relations 
1 sensor-fusion (sensorFusion)
2 feeds-detection (sensorFusion)
3 sensor-fusion (sensorConfidence)
4 feeds-confidence (sensorConfidence)
5 updates-status (fleetOperationalStatus)
6 feeds-equipment-status (fleetOperationalStatus)
7 updates-status (fleetCrewFatigue)
8 feeds-fatigue (fleetCrewFatigue)
9 threat-classification (threatClassification)
10 informs-threat (threatClassification)
11 threat-classification (engagementDecision)
12 informs-engagement (engagementDecision)
13 uses-intelligence (enemySignatures)
14 provides-signatures (enemySignatures)
15 uses-intelligence (historicalEngagement)
16 provides-historical-data (historicalEngagement)
17 fleet-formation-update (threatSeverity)
18 updates-threat-severity (threatSeverity)
19 fleet-formation-update (fleetFormation)
20 updates-formation (fleetFormation)
21 engagement-protocols (detectionConfidence)
22 evaluates-confidence (detectionConfidence)
23 engagement-protocols (threatAssessment)
24 evaluates-threat (threatAssessment)


There are 5 clouds
1 Threat Response
2 Operational Readiness
3 Sensor Fusion
4 Enemy Classification
5 Fleet Coordination

There are 4 lines of thought (Lot)

1 lot Threat Detection and Classification
2 lot Operational Readiness Assessment
3 lot Sensor Fusion for Decision Making
4 lot Fleet Coordination and Threat Response

and 4 dynamice relations (DRels): 
1 sensorFusion
2 sensorConfidence
3 fleetOperationalStatus
4 fleetCrewFatigue

The following code is a partial and incomplete mapping of the Keraia code to Ontologies and SWRL.

Correct any mistakes in the code and expand so that every object, relation, property , cloud, line of thought DRels and  object (Knowledge source) llisted above and which is in the keraia code 

appears in the OWL/SWRL code
To verify the mapping wite a comment in the code with the entity number
eg. Cloud #1 - Threat Response, Cloud #2 - Threat Response, Operational Readiness

A one to one mapping will not always be possible but that is ok. You will have to create new objects and properties to map cloud contents, Drels, Lot along with their properties.
I would prefer a verbose but clear code listing/mapping rather than a short but cryptic one. 

Here is the code to extend .
At the end of the code write a large comment like this:

Ojects:
<All objects listed here>

Properties:

Relations:


Be sure to check that no spurious entities in the code exists.
Finally be as verbose as possible but 100% accurate. You may create additionl entities (objects, properties and relations) to help build the neccessary constructs in OWL/SWRL which correspond to the keraia code


 