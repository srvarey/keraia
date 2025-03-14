        //DRELs
        // DRel 1: Threat Sensor Integration
        KS sensorFusion = navalRecon.acquire(
                "sensor-fusion",
                "feeds-detection",
                KS_SF3,  // AI Fusion System
                KS_TR1,  // Radar APS-124
                "detection-data",
                "detection",
                "feeds-detection",
                (List<String>) null,
                (List<String>) null);

        KS sensorConfidence = navalRecon.acquire(
                "sensor-fusion",
                "feeds-confidence",
                KS_SF3,  // AI Fusion System
                KS_TR2,  // Sonobuoy Network
                "confidence-score",
                "confidence",
                "feeds-confidence",
                (List<String>) null,
                (List<String>) null);


// DRel 2: Fleet Readiness Adjustment
        KS fleetOperationalStatus = navalRecon.acquire(
                "updates-status",
                "feeds-equipment-status",
                KS_OR1,  // Fleet Readiness
                KS_OR2,  // Equipment Status
                "operational-status",
                "radar-status",
                "feeds-equipment-status",
                (List<String>) null,
                (List<String>) null);

        KS fleetCrewFatigue = navalRecon.acquire(
                "updates-status",
                "feeds-fatigue",
                KS_OR1,  // Fleet Readiness
                KS_OR3,  // Crew Readiness
                "crew-fatigue-level",
                "fatigue-level",
                "feeds-fatigue",
                (List<String>) null,
                (List<String>) null);


// DRel 3: Tactical Threat Assessment
        KS threatClassification = navalRecon.acquire(
                "threat-classification",
                "informs-threat",
                KS_FC2,  // Threat Level Assessment
                KS_EC3,  // Classification System
                "threat-label",
                "classification",
                "informs-threat",
                (List<String>) null,
                (List<String>) null);

        KS engagementDecision = navalRecon.acquire(
                "threat-classification",
                "informs-engagement",
                KS_FC2,  // Threat Level Assessment
                KS_TR5,  // Command Center
                "engagement-decision",
                "rules-of-engagement",
                "informs-engagement",
                (List<String>) null,
                (List<String>) null);


// DRel 4: Intelligence-Driven Classification
        KS enemySignatures = navalRecon.acquire(
                "uses-intelligence",
                "provides-signatures",
                KS_EC3,  // Classification System
                KS_EC1,  // Intelligence Database
                "known-threat-signatures",
                "known-signatures",
                "provides-signatures",
                (List<String>) null,
                (List<String>) null);

        KS historicalEngagement = navalRecon.acquire(
                "uses-intelligence",
                "provides-historical-data",
                KS_EC3,  // Classification System
                KS_TR4,  // Intelligence Reports
                "historical-engagement-data",
                "historical-data",
                "provides-historical-data",
                (List<String>) null,
                (List<String>) null);


// DRel 5: Fleet Positioning Based on Threats
        KS threatSeverity = navalRecon.acquire(
                "fleet-formation-update",
                "updates-threat-severity",
                KS_FC1,  // Fleet Positioning System
                KS_FC2,  // Threat Level Assessment
                "threat-severity",
                "threat-level",
                "updates-threat-severity",
                (List<String>) null,
                (List<String>) null);

        KS fleetFormation = navalRecon.acquire(
                "fleet-formation-update",
                "updates-formation",
                KS_FC1,  // Fleet Positioning System
                KS_FC3,  // Tactical AI
                "fleet-formation",
                "new-formation",
                "updates-formation",
                (List<String>) null,
                (List<String>) null);


// DRel 6: Command Decisions Based on Sensor Fusion
        KS detectionConfidence = navalRecon.acquire(
                "engagement-protocols",
                "evaluates-confidence",
                KS_TR5,  // Command Center
                KS_SF3,  // AI Fusion System
                "detection-confidence",
                "high-confidence-detection",
                "evaluates-confidence",
                (List<String>) null,
                (List<String>) null);

        KS threatAssessment = navalRecon.acquire(
                "engagement-protocols",
                "evaluates-threat",
                KS_TR5,  // Command Center
                KS_FC2,  // Threat Level Assessment
                "threat-assessment",
                "high-threat-level",
                "evaluates-threat",
                (List<String>) null,
                (List<String>) null);


