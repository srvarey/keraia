// Time-Series Based Decision Overhaul
// Example: Update threat level based on historical data

MATCH (t:Threat)-[:OBSERVED_AT]->(ts:TimeSeriesData)
WITH t, avg(ts.threatLevel) as avgThreatLevel
WHERE t.threatLevel < avgThreatLevel
SET t.threatLevel = avgThreatLevel;

