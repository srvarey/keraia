# Helo Features and Characteristics via Inheritance

| **Relationship (with respect to Entity)** | **Feature Description** |   |
|------------------------------------------|--------------------------|---|
| **on (with respect to Ship)**            |                          |   |
|                                          | DeckLandingCapability: Whether the helo can land on the ship's deck. |   |
|                                          | FuelTypeCompatibility: The type of fuel the helo uses and whether it's available on the ship. |   |
|                                          | MaintenanceFacility: Availability of a facility on the ship to carry out maintenance on the helo. |   |
| **partof (with respect to Taskgroup)**   |                          |   |
|                                          | TaskGroupMission: The specific mission or role the helo plays in the task group. |   |
|                                          | OperationalTempo: The frequency of helo deployments as determined by the task group's schedule. |   |
|                                          | CommunicationStandards: The communication protocols the helo should adhere to as part of the task group. |   |
| **counters (with respect to Threat)**    |                          |   |
|                                          | DetectionEquipment: Equipment on the helo to detect specific threats. |   |
|                                          | CounterMeasureType: Type of countermeasures the helo can deploy against the threat. |   |
|                                          | EscapeManeuvers: Specialized maneuvers the helo can perform to evade the threat. |   |
