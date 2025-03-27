MATCH (tr1:KnowledgeSource {name: "KS-TR1"}),
      (tr2:KnowledgeSource {name: "KS-TR2"}),
      (sf3:KnowledgeSource {name: "KS-SF3"}),
      (fc1:KnowledgeSource {name: "KS-FC1"}),
      (tr5:KnowledgeSource {name: "KS-TR5"}),
      (tr4:KnowledgeSource {name: "KS-TR4"})

CREATE (tr1)-[:PROCESSED_BY]->(:Transformation {name: "RefineSonarDetection"}),
       (tr2)-[:PROCESSED_BY]->(:Transformation {name: "RefineRadarDetection"}),
       (sf3)-[:PROCESSED_BY]->(:Transformation {name: "ComputeThreatProbability"}),
       (fc1)-[:PROCESSED_BY]->(:Transformation {name: "SynthesizeFleetPosition"}),
       (tr5)-[:PROCESSED_BY]->(:Transformation {name: "UpdateRulesOfEngagement"}),
       (tr4)-[:PROCESSED_BY]->(:Transformation {name: "EnhanceSituationalAwareness"});
