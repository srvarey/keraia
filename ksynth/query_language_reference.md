
# Query Language BNF and Examples

## Type 1: Querying a Relationship Between Two Frames

1. **BNF:**
```
Q ::= Q[Juncture, {DimensionList}] frame1/
      frame2(rel=relationshipName)

Juncture      ::= <string>
DimensionList ::= {dimension_number | dimension_name | dimension_label 
                                    | dimension_function}*
dimension_number   ::= <integer>
dimension_name     ::= <string>
dimension_label    ::= <string>
dimension_function ::= <string>
relationshipName   ::= <string>
```

2. **Note:** The dimension function can be a name, * (wild card) or _ (don't care)

3. **Description:** This query identifies a direct relationship between two specific knowledge sources within a given dimension and juncture. It is used to explore how entities are connected.

4. **Example:**  
   `RQ[J1, 1, global, intell, _] /Naval Strategy/Maritime Surveillance{rel=IntelligenceSharing}`

5. **Output:**  
```json
[{"Naval Strategy": {}, "IntelligenceSharing": {}, "Maritime Surveillance": {}}]
```

---

## Type 2: Querying for a Specific Slot-Filler Value

1. **BNF:**
```
SQ ::= SQ[Juncture, DimensionList] /FramePath*(slot=value)

FramePath ::= Frame | Frame / FramePath | Frame / "*"

Frame ::= frame_name
slot  ::= slot_name
value ::= slot_value

Juncture      ::= <string>
DimensionList ::= {dimension_number | dimension_name | dimension_label 
                                    | dimension_function}*
dimension_number   ::= <integer>
dimension_name     ::= <string>
dimension_label    ::= <string>
dimension_function ::= <string>
```

2. **Note:** The dimension function can be a name, * (wild card) or _ (don't care)

3. **Description:** Searches for frames or paths where a specific slot has a specified value, useful for filtering data based on criteria.

4. **Example:**  
   `SQ[J1, 1, global, intell, _] /Situation Awareness(threat level='high')`

5. **Output:**  
```json
[{"Situation Awareness": {"threat level": "high"}}]
```

---

## Type 3: Querying with a DRel

1. **BNF:**
```
DQ ::= DQ[Juncture, DimensionList] /Frame1/Frame2

Juncture      ::= <string>
DimensionList ::= {dimension_number | dimension_name 
                                    | dimension_label 
                                    | dimension_function}*
Frame1             ::= <string>
Frame2             ::= <string>
```

2. **Note:** The dimension function can be a name, * (wild card) or _ (don't care), Similar to RQ, but specifically targets dynamic relationships (DRel) between frames.

3. **Description:** Identifies dynamic relationships (DRel) between two specified frames, focusing on the actions or interactions that are possible or occurring.

4. **Example:**  
   `DQ[J1, 1, global, intell, _] /Recon Drone/Naval Carrier`

5. **Output:**  
```json
[{"Recon Drone": {}, "SurveillanceOperation": {}, "Naval Carrier": {}}]
```

---

## Type 4: Querying for a Fork within Dimension

1. **BNF:**
```
FQ ::= FQ[Juncture, DimensionList] [/PartialKLinePath]
      (fork[dimension_number, dimension_name, label, predicate])

PartialKLinePath ::= Frame | Frame / PartialKLinePath | "*"
Frame            ::= frame_name
fork             ::= "fork"
Juncture         ::= <string>
DimensionList ::= {dimension_number | dimension_name | dimension_label 
                                    | dimension_function}*
dimension_number   ::= <integer>
dimension_name     ::= <string>
dimension_label    ::= <string>
dimension_function ::= <string>
```

2. **Note:** Forks represent decision points or branching logic in the model. The dimension function can be a name, * (wild card) or _ (don't care)

3. **Description:** This query locates klines with forks within a given dimension and juncture, characterized by specific attributes or results, illustrating decision-making or branching logic.

4. **Example:**  
   `FQ[J1, 1, global, NavalOps, _] [/Reconnaissance/Surveillance] (fork[1, "Threat Assessment", "Engagement Decision", highThreat])`

5. **Output:**  
```json
[
  ["Reconnaissance/Surveillance/Engagement Decision(fork[1, "Threat Assessment", "Engagement Decision", highThreat])/Countermeasures - High threat identified, engagement decision pending approval."],
  ["Reconnaissance/Surveillance/Threat Identification/Engagement Decision(fork[1, "Threat Assessment", "Engagement Decision", highThreat])/Evacuation - Threat level high, immediate evacuation and engagement protocol activated."]
]
```

---

## Type 5: Querying for a Path (KLine) with Multiple Relationships

1. **BNF:**
```
KQ ::= KQ[Juncture, DimensionList] /Frame1/Frame2

Juncture      ::= <string>
DimensionList ::= {dimension_number | dimension_name 
                                    | dimension_label 
                                    | dimension_function}*
dimension_number   ::= <integer>
dimension_name     ::= <string>
dimension_label    ::= <string>
dimension_function ::= <string>
Frame1             ::= <string>
Frame2             ::= <string>
```

2. **Note:** The dimension function can be a name, * (wild card) or _ (don't care)

3. **Description:** Searches for paths (klines) between two knowledge sources

4. **Example:**  
   `KQ[J1, 1, global, logistics, _] /Supply Chain/Port Facility`

5. **Output:**  
```
["Supply Chain/LogisticalSupport/Port Facility"]
```

---

These refined BNF notations, examples, and outputs aim to provide a clear framework for querying within a hypothetical naval scenario knowledge representation system, demonstrating the flexibility and specificity of the query language in addressing complex data relationships.
