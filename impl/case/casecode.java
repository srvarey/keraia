package ksconvocation;

import aip.db.dao.NewMessageDAO;

import java.util.*;
import java.util.stream.Collectors;


// Case Class: Represents a stored case in the Case-Based Reasoning (CBR) system
class Case {


    public Case() {

    }

    public Case id(String id) {
        this.id = id;
        return this;
    }

    public Case description(String description) {
        this.description = description;
        return this;
    }


    public Case type(String type) {
        this.type = type;
        return this;
    }


    public Case classification(String classification) {
        this.classification = classification;
        return this;
    }


    public Case combinedConfidence(String combinedConfidence) {
        this.combinedConfidence = combinedConfidence;
        return this;
    }


    public Case confidenceLevel(String confidenceLevel) {
        this.confidenceLevel = confidenceLevel;
        return this;
    }


    public Case confirmedTracks(String confirmedTracks) {
        this.confirmedTracks = confirmedTracks;
        return this;
    }


    public Case decisionThreshold(String decisionThreshold) {
        this.decisionThreshold = decisionThreshold;
        return this;
    }


    public Case detectionCapability(String detectionCapability) {
        this.detectionCapability = detectionCapability;
        return this;
    }


    public Case detectionMode(String detectionMode) {
        this.detectionMode = detectionMode;
        return this;
    }


    public Case detection(String detection) {
        this.detection = detection;
        return this;
    }


    public Case formation(String formation) {
        this.formation = formation;
        return this;
    }


    public Case fusionAlgorithm(String fusionAlgorithm) {
        this.fusionAlgorithm = fusionAlgorithm;
        return this;
    }


    public Case range(String range) {
        this.range = range;
        return this;
    }


    public Case recentSightings(String recentSightings) {
        this.recentSightings = recentSightings;
        return this;
    }


    public Case recommendedAction(String recommendedAction) {
        this.recommendedAction = recommendedAction;
        return this;
    }


    public Case rulesOfEngagement(String rulesOfEngagement) {
        this.rulesOfEngagement = rulesOfEngagement;
        return this;
    }


    public Case sensorRange(String sensorRange) {
        this.sensorRange = sensorRange;
        return this;
    }


    public Case status(String status) {
        this.status = status;
        return this;
    }


    public Case threatLevel(String threatLevel) {
        this.threatLevel = threatLevel;
        return this;
    }


    public Case trackingAlgorithm(String trackingAlgorithm) {
        this.trackingAlgorithm = trackingAlgorithm;
        return this;
    }


    public Case knownSignatures(String knownSignatures) {
        this.knownSignatures = knownSignatures;
        return this;
    }


    public Case operationalStatus(String operationalStatus) {
        this.operationalStatus = operationalStatus;
        return this;
    }


    public Case crewFatigueLevel(String crewFatigueLevel) {
        this.crewFatigueLevel = crewFatigueLevel;
        return this;
    }


    public Case sensorAccuracy(String sensorAccuracy) {
        this.sensorAccuracy = sensorAccuracy;
        return this;
    }


    public Case fleetFormation(String fleetFormation) {
        this.fleetFormation = fleetFormation;
        return this;
    }


    public Case threatAssessment(String threatAssessment) {
        this.threatAssessment = threatAssessment;
        return this;
    }


    public Case fuelLevels(String fuelLevels) {
        this.fuelLevels = fuelLevels;
        return this;
    }


    public Case ammunition(String ammunition) {
        this.ammunition = ammunition;
        return this;
    }


    public Case radar(String radar) {
        this.radar = radar;
        return this;
    }


    public Case sonobuoyNetwork(String sonobuoyNetwork) {
        this.sonobuoyNetwork = sonobuoyNetwork;
        return this;
    }


    public Case fatigueLevel(String fatigueLevel) {
        this.fatigueLevel = fatigueLevel;
        return this;
    }


    public Case crewRotation(String crewRotation) {
        this.crewRotation = crewRotation;
        return this;
    }


    public Case confidence(String confidence) {
        this.confidence = confidence;
        return this;
    }


    public Case acousticSignature(String acousticSignature) {
        this.acousticSignature = acousticSignature;
        return this;
    }


    public Case depth(String depth) {
        this.depth = depth;
        return this;
    }


    public Case currentFormation(String currentFormation) {
        this.currentFormation = currentFormation;
        return this;
    }


    public Case decisionModel(String decisionModel) {
        this.decisionModel = decisionModel;
        return this;
    }


    public Case step1(String step1) {
        this.step1 = step1;
        return this;
    }


    public Case step2(String step2) {
        this.step2 = step2;
        return this;
    }


    public Case step3(String step3) {
        this.step3 = step3;
        return this;
    }


    public Case step4(String step4) {
        this.step4 = step4;
        return this;
    }


    public Case sensorDataProcessing(String sensorDataProcessing) {
        this.sensorDataProcessing = sensorDataProcessing;
        return this;
    }


    public Case threatEvaluation(String threatEvaluation) {
        this.threatEvaluation = threatEvaluation;
        return this;
    }


    public Case multiSensorIntegration(String multiSensorIntegration) {
        this.multiSensorIntegration = multiSensorIntegration;
        return this;
    }


    public Case readinessAssessment(String readinessAssessment) {
        this.readinessAssessment = readinessAssessment;
        return this;
    }


    public Case decisionExecution(String decisionExecution) {
        this.decisionExecution = decisionExecution;
        return this;
    }


    public Case fleetAdaptation(String fleetAdaptation) {
        this.fleetAdaptation = fleetAdaptation;
        return this;
    }


    public Case juncture(String juncture) {
        this.juncture = juncture;
        return this;
    }


    public Case sensors(String sensors) {
        this.sensors = sensors;
        return this;
    }


    public Case historicalEngagementData(String historicalEngagementData) {
        this.historicalEngagementData = historicalEngagementData;
        return this;
    }

    public Case decisionPriority(String decisionPriority) {
        this.decisionPriority = decisionPriority;
        return this;
    }

    private String id;          // Unique identifier for the case
    private String description; // Description of the case scenario
    private String type;        // Type of the case (KS, Cloud, LoT)
    private String decisionPriority;
    private String classification; // (lot Threat Detection and Classification, KS SF2, KS EC3, KS EC1,
    // KS EC2, KS TR4, KS TR5)
    private String combinedConfidence; // KS SF3
    private String confidenceLevel; // KS TR4
    private String confirmedTracks; // KS TR3
    private String decisionThreshold; // KS EC3
    private String detectionCapability; // KS TR1
    private String detectionMode; // KS TR2
    private String detection;    // KS SF1, KS SF2, KS TR1, KS TR2
    private String formation;   // KS FC1
    private String fusionAlgorithm; // KS SF3
    private String range;       // KS TR1
    private String recentSightings; // KS TR4
    private String recommendedAction; // KS FC2
    private String rulesOfEngagement; // KS TR5
    private String sensorRange;   // KS TR2
    private String status;       // KS OR1, KS TR1, KS TR5, KS OR2, KS OR3, KS FC1, KS FC2, KS FC3
    private String threatLevel;  // KS FC2, KS TR4
    private String trackingAlgorithm; // KS TR3
    private String knownSignatures; // KS EC1
    private String operationalStatus; // KS OR1
    private String crewFatigueLevel; // KS OR3
    private String sensorAccuracy;  // KS SF1, KS SF2
    private String fleetFormation;  // KS FC1, KS FC3
    private String threatAssessment; // KS FC2
    private String fuelLevels;      // KS OR1
    private String ammunition;      // KS OR1
    private String radar;          // KS OR2
    private String sonobuoyNetwork; // KS OR2
    private String fatigueLevel;    // KS OR3
    private String crewRotation;   // KS OR3
    private String confidence;     // KS SF1
    private String acousticSignature; // KS EC2
    private String depth;         // KS EC2
    private String currentFormation; // KS FC1
    private String decisionModel;  // KS FC3
    private String step1;          // lot Threat Detection and Classification,
    // lot Operational Readiness Assessment,
    // lot Sensor Fusion for Decision Making,
    // lot Fleet Coordination and Threat Response
    private String step2;          // lot Threat Detection and Classification,
    // lot Operational Readiness Assessment,
    // lot Sensor Fusion for Decision Making,
    // lot Fleet Coordination and Threat Response
    private String step3;          // lot Threat Detection and Classification,
    // lot Operational Readiness Assessment,
    // lot Sensor Fusion for Decision Making,
    // lot Fleet Coordination and Threat Response
    private String step4;          // lot Threat Detection and Classification,
    // lot Operational Readiness Assessment,
    // lot Sensor Fusion for Decision Making,
    // lot Fleet Coordination and Threat Response
    private String sensorDataProcessing; // Dimension
    private String threatEvaluation;     // Dimension
    private String multiSensorIntegration; // Dimension
    private String readinessAssessment;   // Dimension
    private String decisionExecution;    // Dimension
    private String fleetAdaptation;      // Dimension
    private String juncture;             // Juncture
    private String sensors;              // KS TR1, KS TR2
    private String historicalEngagementData;  //KS TR4

    // Constructor to initialize a case
    public Case(String id, String description) {
        this.id = id;
        this.description = description;
    }


    // Getter method for retrieving the case description
    public String getDescription() {
        return description;
    }

    // Setter method to update the case description (used in adaptation)
    public void updateDescription(String newDescription) {
        this.description = newDescription;
    }

    // Getter method for retrieving the case ID
    public String getId() {
        return id;
    }

    // Method to return a string representation of the case
    @Override
    public String toString() {
        return "Case ID: " + id + " | Description: " + description;
    }
}

class KeraiaNavalScenario_CASE {

    // ===================== STORED CASES (17 Knowledge Sources + Clouds + LoTs) =====================
    // KS-TR1 to KS-FC3 representing past cases of threat response and fleet coordination
    private static final List<Case> CASES = new ArrayList<>(Arrays.asList(

            new Case().id("KS-TR1").description("Submarine detected, immediate response").type("knowledge source")
                    .detectionCapability("radar").detection("detection").range("100 nautical miles").status("active")
                    .sensors("Radar APS-124").decisionPriority("high"),

            new Case().id("KS-TR2").description("Airborne threat detected, prepare countermeasures").type("knowledge source")
                    .detectionMode("passive/active").detection("detection").sensorRange("5 nautical miles").decisionPriority("high"),

            new Case().id("KS-TR3").description("Multiple ships detected, assess formation").type("knowledge source")
                    .confirmedTracks("3").trackingAlgorithm("Kalman filter").decisionPriority("high"),

            new Case().id("KS-TR4").description("Unidentified vessel approaching, maintain distance").type("knowledge source")
                    .confidenceLevel("80%").recentSightings("enemy submarine detected")
                    .historicalEngagementData("enemy submarine detected").decisionPriority("high"),

            new Case().id("KS-TR5").description("Rules of Engagement: Engage if confirmed hostile").type("knowledge source")
                    .rulesOfEngagement("Engage if confirmed hostile").status("active").decisionPriority("high"),

            new Case().id("KS-OR1").description("Operational Readiness: Combat ready, fuel 80%, ammunition 90%").type("knowledge source")
                    .status("combat ready").fuelLevels("80%").ammunition("90%").decisionPriority("high"),

            new Case().id("KS-OR2").description("Equipment Status: Radar operational, Sonobuoy network functional").type("knowledge source")
                    .radar("operational").sonobuoyNetwork("functional").decisionPriority("high"),

            new Case().id("KS-OR3").description("Crew Readiness: Fatigue low, crew rotation scheduled").type("knowledge source")
                    .crewFatigueLevel("low").crewRotation("scheduled").decisionPriority("high"),

            new Case().id("KS-SF1").description("Sensor Fusion: Acoustic anomaly, confidence 50%").type("knowledge source")
                    .detection("acoustic anomaly").confidence("50%").decisionPriority("high"),

            new Case().id("KS-SF2").description("Sensor Fusion: Object at 50m depth, unknown classification").type("knowledge source")
                    .classification("unknown").depth("300m").detection("object at 50m depth").decisionPriority("high"),

            new Case().id("KS-SF3").description("AI Fusion: Bayesian Inference, combined confidence 75%").type("knowledge source")
                    .fusionAlgorithm("Bayesian Inference").combinedConfidence("75%").decisionPriority("high"),

            new Case().id("KS-EC1").description("Enemy Classification: Known signatures Type-212, Kilo-Class").type("knowledge source")
                    .knownSignatures("Type-212 Submarine, Kilo-Class").decisionPriority("high"),

            new Case().id("KS-EC2").description("Unknown acoustic signature at 300m depth").type("knowledge source")
                    .acousticSignature("unknown").depth("300m").decisionPriority("high"),

            new Case().id("KS-EC3").description("Classification pending, decision threshold 90%").type("knowledge source")
                    .classification("pending").decisionThreshold("90%").decisionPriority("high"),

            new Case().id("KS-FC1").description("Fleet Coordination: Current formation defensive perimeter").type("knowledge source")
                    .currentFormation("defensive perimeter").formation("defensive perimeter").decisionPriority("high"),

            new Case().id("KS-FC2").description("Threat Level: High, recommended action disperse").type("knowledge source")
                    .threatLevel("high").recommendedAction("disperse").decisionPriority("high"),

            new Case().id("KS-FC3").description("Tactical AI: Decision model Markov Decision Process").type("knowledge source")
                    .decisionModel("Markov Decision Process").decisionPriority("high"),

            // Representing the Clouds of Knowledge
            new Case().id("Threat Response Cloud").description("Cloud containing KS-TR1, KS-TR2, KS-TR3, KS-TR4, KS-TR5").type("cloud").decisionPriority("high"),

            new Case().id("Operational Readiness Cloud").description("Cloud containing KS-OR1, KS-OR2, KS-OR3").type("cloud").decisionPriority("high"),

            new Case().id("Sensor Fusion Cloud").description("Cloud containing KS-SF1, KS-SF2, KS-SF3").type("cloud").decisionPriority("high"),

            new Case().id("Enemy Classification Cloud").description("Cloud containing KS-EC1, KS-EC2, KS-EC3").type("cloud").decisionPriority("high"),

            new Case().id("Fleet Coordination Cloud").description("Cloud containing KS-FC1, KS-FC2, KS-FC3").type("cloud").decisionPriority("high"),

            // Representing Lines of Thought (LoTs)
            new Case().id("lot_Threat_Detection_and_Classification").description("LoT: Initial Detection (Radar, Sonobuoy), Tracking, Classification").type("LoT")
                    .step1("Initial Detection").step2("Tracking and Data Fusion").step3("Classification").step4("Classification").decisionPriority("high"),

            new Case().id("lot_Operational_Readiness_Assessment").description("LoT: Status Assessment (Fleet, Equipment, Crew), Feasibility Analysis, Final Decision").type("LoT")
                    .step1("Status Assessment").step2("Mission Feasibility Analysis").step3("Final Decision").decisionPriority("high"),

            new Case().id("lot_Sensor_Fusion_for_Decision_Making").description("LoT: Data Collection, Integration, Threat Classification").type("LoT")
                    .step1("Data Collection").step2("Data Integration and Analysis").step3("Threat Classification").decisionPriority("high"),

            new Case().id("lot_Fleet_Coordination_and_Threat_Response").description("LoT: Threat Analysis, Fleet Adjustment, Engagement Decision").type("LoT")
                    .step1("Real-Time Threat Analysis").step2("Fleet Position Adjustment").step3("Engagement Decision").decisionPriority("high"),

            // Representing Dynamic Relations (DRels) - Simulated
            new Case().id("sensorFusion").description("Threat Sensor Integration: feeds-detection").type("DRel").decisionPriority("high"),

            new Case().id("sensorConfidence").description("Threat Sensor Integration: feeds-confidence").type("DRel").decisionPriority("high"),

            new Case().id("fleetOperationalStatus").description("Fleet Readiness Adjustment: feeds-equipment-status").type("DRel").decisionPriority("high"),

            new Case().id("fleetCrewFatigue").description("Fleet Readiness Adjustment: feeds-fatigue").type("DRel").decisionPriority("high"),

            new Case().id("threatClassification").description("Tactical Threat Assessment: informs-threat").type("DRel").decisionPriority("high"),

            new Case().id("engagementDecision").description("Tactical Threat Assessment: informs-engagement").type("DRel").decisionPriority("high"),

            new Case().id("enemySignatures").description("Intelligence-Driven Classification: provides-signatures").type("DRel").decisionPriority("high"),

            new Case().id("historicalEngagement").description("Intelligence-Driven Classification: provides-historical-data").type("DRel").decisionPriority("high"),

            // Representing Junctures
            new Case().id("Threat Detection Juncture").description("Juncture: Sensor Data Processing Dimension").type("Juncture").sensorDataProcessing("Sensor Data Processing").decisionPriority("high"),

            new Case().id("Threat Classification Juncture").description("Juncture: Threat Evaluation Dimension").type("Juncture").threatEvaluation("Threat Evaluation").decisionPriority("high"),

            new Case().id("Sensor Fusion Juncture").description("Juncture: Multi-Sensor Integration Dimension").type("Juncture").multiSensorIntegration("Multi-Sensor Integration").decisionPriority("high"),

            new Case().id("Operational Readiness Juncture").description("Juncture: Readiness Assessment Dimension").type("Juncture").readinessAssessment("Readiness Assessment").decisionPriority("high"),

            new Case().id("Tactical Decision Making Juncture").description("Juncture: Decision Execution Dimension").type("Juncture").decisionExecution("Decision Execution").decisionPriority("high"),

            new Case().id("Fleet Coordination Juncture").description("Juncture: Fleet Adaptation Dimension").type("Juncture").fleetAdaptation("Fleet Adaptation").decisionPriority("high"),

            // Clouds
            new Case().id("Threat Response Cloud").description("Dynamic cluster of threat response KS").type("Cloud"),
            new Case().id("Operational Readiness Cloud").description("Operational readiness KS cluster").type("Cloud"),
            new Case().id("Sensor Fusion Cloud").description("Sensor fusion KS cluster").type("Cloud"),
            new Case().id("Enemy Classification Cloud").description("Enemy classification KS cluster").type("Cloud"),
            new Case().id("Fleet Coordination Cloud").description("Fleet coordination KS cluster").type("Cloud"),

            // Lines of Thought (LoT) explicitly modeled as linked lists:

            // LoT: Threat Detection and Classification
            new Case().id("LoT-Threat-Detection-Classification-Step1")
                    .description("Initial Detection")
                    .type("LoT")
                    .step1("KS-TR1, KS-TR2")
                    .decisionPriority("high"),

            new Case().id("LoT-Threat-Detection-Classification-Step2")
                    .description("Tracking and Data Fusion")
                    .type("LoT")
                    .step1("KS-TR3, KS-SF1, KS-SF2")
                    .decisionPriority("high"),

            new Case().id("LoT-Threat-Detection-Classification-Step3")
                    .description("Initial Classification")
                    .type("LoT")
                    .step1("KS-EC1, KS-EC2")
                    .decisionPriority("high"),

            new Case().id("LoT-Threat-Detection-Classification-Step4")
                    .description("Final Classification Decision")
                    .type("LoT")
                    .step1("KS-EC3")
                    .decisionPriority("high"),

// LoT: Operational Readiness Assessment
            new Case().id("LoT-Operational-Readiness-Assessment-Step1")
                    .description("Initial Readiness Assessment")
                    .type("LoT")
                    .step1("KS-OR1")
                    .decisionPriority("high"),

            new Case().id("LoT-Operational-Readiness-Assessment-Step2")
                    .description("Equipment and System Check")
                    .type("LoT")
                    .step1("KS-OR2")
                    .decisionPriority("high"),

            new Case().id("LoT-Operational-Readiness-Assessment-Step3")
                    .description("Crew Readiness Verification")
                    .type("LoT")
                    .step1("KS-OR3")
                    .decisionPriority("high"),

// LoT: Sensor Fusion for Decision Making
            new Case().id("LoT-Sensor-Fusion-Decision-Step1")
                    .description("Data Collection from Sensors")
                    .type("LoT")
                    .step1("KS-SF1")
                    .decisionPriority("high"),

            new Case().id("LoT-Sensor-Fusion-Decision-Step2")
                    .description("Integration and Analysis")
                    .type("LoT")
                    .step1("KS-SF2")
                    .decisionPriority("high"),

            new Case().id("LoT-Sensor-Fusion-Decision-Step3")
                    .description("Fusion Decision and Confidence Assessment")
                    .type("LoT")
                    .step1("KS-SF3")
                    .decisionPriority("high"),

// LoT: Fleet Coordination and Threat Response
            new Case().id("LoT-Fleet-Coordination-Response-Step1")
                    .description("Real-Time Threat Analysis")
                    .type("LoT")
                    .step1("KS-FC2")
                    .decisionPriority("high"),

            new Case().id("LoT-Fleet-Coordination-Response-Step2")
                    .description("Fleet Formation Adjustment")
                    .type("LoT")
                    .step1("KS-FC1")
                    .decisionPriority("high"),

            new Case().id("LoT-Fleet-Coordination-Response-Step3")
                    .description("Tactical Decision Execution")
                    .type("LoT")
                    .step1("KS-FC3")
                    .decisionPriority("high"),

            // Dynamic Relations (DRel)
            new Case().id("sensorFusion").description("Dynamic relation for sensor fusion").type("DRel"),
            new Case().id("sensorConfidence").description("Sensor confidence relation").type("DRel"),
            new Case().id("fleetOperationalStatus").description("Relation for fleet operational status").type("DRel"),
            new Case().id("fleetCrewFatigue").description("Crew fatigue dynamic relation").type("DRel"),

            // Junctures and Dimensions explicitly modeled
            new Case().id("Threat Detection Juncture").description("Horizontal juncture: Sensor Data Processing").type("Juncture")
                    .sensorDataProcessing("active"),
            new Case().id("Threat Classification Juncture").description("Classification juncture with threat evaluation dimension").type("Juncture")
                    .threatEvaluation("active"),
            new Case().id("Sensor Fusion Juncture").description("Sensor Fusion Juncture with multi-sensor integration").type("Juncture")
                    .multiSensorIntegration("active"),
            new Case().id("Operational Readiness Juncture").description("Operational Readiness juncture with readiness assessment dimension").type("Juncture")
                    .readinessAssessment("active"),
            new Case().id("Tactical Decision Making Juncture").description("Tactical Decision Making with decision execution dimension").type("Juncture")
                    .decisionExecution("active"),
            new Case().id("Fleet Coordination Juncture").description("Fleet Coordination juncture with fleet adaptation dimension").type("Juncture")
                    .fleetAdaptation("active"),
            // Dimensions explicitly modeled
            new Case().id("Sensor Data Processing Dimension").description("Dimension: processes sensor data").type("Dimension"),
            new Case().id("Threat Evaluation Dimension").description("Dimension: evaluates threats").type("Dimension"),
            new Case().id("Multi-Sensor Integration Dimension").description("Dimension: integrates data from multiple sensors").type("Dimension"),
            new Case().id("Readiness Assessment Dimension").description("Dimension: assesses readiness").type("Dimension"),
            new Case().id("Decision Execution Dimension").description("Dimension: executes tactical decisions").type("Dimension"),
            new Case().id("Fleet Adaptation Dimension").description("Dimension: adapts fleet formation").type("Dimension")
    ));

    private Map sourceToTargetsMap;
    private Map<String, Relation> relations;

    // Relations explicitly modeling LoTs and Dynamic Relations (higher count)
    private void modelRelations() {
        linkCases("LoT-Threat-Detection-Step1", "KS-TR1");
        linkCases("LoT-Threat_Detection_and_Classification-Step1", "LoT-Threat_Detection-Step2");
        // Continue explicitly linking each LoT step

        // Dynamic Relations (explicit context-dependent relations)
        establishDRel("sensorFusion", "KS-SF3", "KS-TR1");
        establishDRel("fleetOperationalStatus", "KS-OR1", "KS-OR2");
        // Continue similarly for each DRel
    }

    // Relation Class representing the link between two cases
    class Relation {
        private Case source;
        private Case target;
        private String relationType;

        public Relation(Case source, Case target, String relationType) {
            this.source = source;
            this.target = target;
            this.relationType = relationType;
        }

        public Case getSource() {
            return source;
        }

        public Case getTarget() {
            return target;
        }

        public String getRelationType() {
            return relationType;
        }

        @Override
        public String toString() {
            return source.getId() + " --[" + relationType + "]--> " + target.getId();
        }
    }

    //  Method to explicitly link cases (e.g., linking Knowledge Sources to Lines of Thought or Clouds)
    public void linkCases(Case source, Case target, String relationType) {
        if (sourceToTargetsMap == null) {
            sourceToTargetsMap = new HashMap<>();
        }

        String relationKey = source.getId() + "-" + relationType + "->" + target.getId();
        relations.put(relationKey, new Relation(source, target, relationType));
    }

    // Methods to handle relations
    private void establishDRel(String relationName, String sourceKS, String targetKS) {
        // Explicitly define the dynamic relationship
    }

    private void linkLoTSteps(String currentStep, String nextStep) {
        // Explicitly create links between LoT steps
    }

// Explicit implementations of case linking methods

    // Establish explicit dynamic relations (DRels) between two knowledge sources
    public void establishDynamicRelation(String relationId, String fromKsId, String toKsId) {
        System.out.println("Establishing Dynamic Relation (" + relationId + ") from " + fromKsId + " to " + toKsId);
        Case fromKS = findCaseById(fromKsId);
        Case toKS = findCaseById(toKsId);
        if (fromKS != null && toKS != null) {
            fromKS.updateDescription(fromKS.getDescription() + " [DRel: " + relationId + " -> " + toKS.getId() + "]");
            System.out.println("Dynamic relation established: " + fromKsId + " (" + relationId + ") -> " + toKsId);
        } else {
            System.out.println("Error: Knowledge Source not found for dynamic relation.");
        }
    }

    // Explicitly link steps within Lines of Thought (LoT)
    public void linkCases(String fromLotStepId, String toLotStepId) {
        System.out.println("Linking LoT step from " + fromLotStepId + " to " + toLotStepId);
        Case fromStep = findCaseById(fromLotStepId);
        Case toStep = findCaseById(toLotStepId);
        if (fromStep != null && toStep != null) {
            fromStep.updateDescription(fromStep.getDescription() + " [Next Step: " + toLotStepId + "]");
            System.out.println("Successfully linked: " + fromLotStepId + " -> " + toLotStepId);
        } else {
            System.out.println("Error: LoT step(s) not found (" + fromLotStepId + ", " + toLotStepId + ")");
        }
    }

    // Explicitly associate KS instances to their Cloud
    public void establishCloudRelation(String cloudId, List<String> ksIds) {
        System.out.println("Establishing Cloud (" + cloudId + ") relation to KS instances");
        Case cloud = findCaseById(cloudId);
        if (cloud != null) {
            List<String> associatedKS = new ArrayList<>();
            for (String ksId : ksIds) {
                Case ks = findCaseById(ksId);
                if (ks != null) {
                    associatedKS.add(ksId);
                } else {
                    System.out.println("Warning: KS " + ksId + " not found.");
                }
            }
            if (!associatedKS.isEmpty()) {
                String existingDescription = cloud.getDescription();
                cloud.updateDescription(existingCloudDescription(cloud, associatedKS));
                System.out.println("Updated Cloud (" + cloudId + ") with KS: " + String.join(", ", associatedKS));
            }
        } else {
            System.out.println("Error: Cloud case not found (" + cloudId + ")");
        }
    }

    // Helper method to append KS IDs to the existing description neatly
    private String existingCloudDescription(Case cloud, List<String> ksIds) {
        return cloud.getDescription() + " [KS Instances: " + String.join(", ", ksIds) + "]";
    }

    // Helper method to find a case by ID
    private Case findCaseById(String id) {
        for (Case c : CASES) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }


    // ===================== SIMILARITY FUNCTIONS (15) =====================
    // Measures relevance of cases based on different criteria
    public static double similarityByThreatType(Case newCase, Case storedCase) {
        // Similarity Function #1: Compare threat type
        return newCase.getDescription().contains(storedCase.getDescription()) ? 1.0 : 0.5;
    }

    public static double similarityByDistance(double currentDistance, double caseDistance) {
        // Similarity Function #2: Compare proximity
        return 1.0 / (1.0 + Math.abs(currentDistance - caseDistance));
    }

    public static double similarityByWeather(String currentWeather, String caseWeather) {
        // Similarity Function #3: Compare weather conditions
        return currentWeather.equals(caseWeather) ? 1.0 : 0.6;
    }

    public static double similarityByEnemyType(String currentType, String caseType) {
        // Similarity Function #4: Compare known threat classification
        return currentType.equalsIgnoreCase(caseType) ? 1.0 : 0.7;
    }

    public static double similarityByRulesOfEngagement(String engagementRules1, String engagementRules2) {
        // Similarity Function #5: Compare rules of engagement
        return engagementRules1.equalsIgnoreCase(engagementRules2) ? 1.0 : 0.8;
    }

    public static double similarityByDetectionSource(String sensor1, String sensor2) {
        // Similarity Function #6: Compare sensors (Radar vs Sonar)
        return sensor1.equalsIgnoreCase(sensor2) ? 1.0 : 0.6;
    }

    public static double similarityByOperationalStatus(String status1, String status2) {
        // Similarity Function #7: Compare ship operational status
        return status1.equalsIgnoreCase(status2) ? 1.0 : 0.5;
    }

    public static double similarityByFleetPosition(String fleetFormation1, String fleetFormation2) {
        // Similarity Function #8: Compare fleet formations
        return fleetFormation1.equalsIgnoreCase(fleetFormation2) ? 1.0 : 0.7;
    }

    public static double similarityBySensorData(String sensorData1, String sensorData2) {
        // Similarity Function #9: Compare sensor data characteristics
        return sensorData1.equalsIgnoreCase(sensorData2) ? 1.0 : 0.6;
    }

    public static double similarityByCrewFatigue(String crewFatigue1, String crewFatigue2) {
        // Similarity Function #10: Compare crew fatigue levels
        return crewFatigue1.equalsIgnoreCase(crewFatigue2) ? 1.0 : 0.7;
    }

    public static double similarityByThreatLevel(String threatLevel1, String threatLevel2) {
        // Similarity Function #11: Compare threat levels
        return threatLevel1.equalsIgnoreCase(threatLevel2) ? 1.0 : 0.8;
    }

    public static double similarityByEngagementDecision(String decision1, String decision2) {
        // Similarity Function #12: Compare engagement decisions
        return decision1.equalsIgnoreCase(decision2) ? 1.0 : 0.9;
    }

    public static double similarityByHistoricalData(String data1, String data2) {
        // Similarity Function #13: Compare historical engagement data
        return data1.equalsIgnoreCase(data2) ? 1.0 : 0.7;
    }

    public static double similarityByFormationUpdate(String formation1, String formation2) {
        // Similarity Function #14: Compare fleet formation updates
        return formation1.equalsIgnoreCase(formation2) ? 1.0 : 0.6;
    }

    public static double similarityByDecisionPriority(String priority1, String priority2) {
        // Similarity Function #15: Compare Decision Priorities
        return priority1.equalsIgnoreCase(priority2) ? 1.0 : 0.8;
    }

    // ===================== ADAPTATION RULES (7) =====================
    // Adjusts retrieved cases to fit new conditions
    public static Case adaptCaseForWeather(Case retrievedCase, String newWeather) {
        // Adaptation Rule #1: Modify response based on weather
        if (newWeather.equals("stormy")) {
            retrievedCase.updateDescription(retrievedCase.getDescription() + " (Caution: Storm Interference)");
        }
        return retrievedCase;
    }

    public static Case adaptCaseForFleetReadiness(Case retrievedCase, boolean fleetReady) {
        // Adaptation Rule #2: Adjust actions based on fleet readiness
        if (!fleetReady) {
            retrievedCase.updateDescription(retrievedCase.getDescription() + " (Hold fire until reinforcements arrive)");
        }
        return retrievedCase;
    }

    public static Case adaptCaseForEnemySpeed(Case retrievedCase, double enemySpeed) {
        // Adaptation Rule #3: Adjust engagement for high-speed threats
        if (enemySpeed > 30) {
            retrievedCase.updateDescription(retrievedCase.getDescription() + " (Use high-speed interceptors)");
        }
        return retrievedCase;
    }

    public static Case adaptCaseForDetectionType(Case retrievedCase, String detectionSource) {
        // Adaptation Rule #4: Adjust sensor priority
        if (detectionSource.equals("sonar")) {
            retrievedCase.updateDescription(retrievedCase.getDescription() + " (Validate with passive sonar)");
        }
        return retrievedCase;
    }

    public static Case adaptCaseForEWThreat(Case retrievedCase, boolean ewDetected) {
        // Adaptation Rule #5: Modify tactics for electronic warfare
        if (ewDetected) {
            retrievedCase.updateDescription(retrievedCase.getDescription() + " (Deploy EW countermeasures)");
        }
        return retrievedCase;
    }

    public static Case adaptCaseForThreatLevel(Case retrievedCase, String threatLevel) {
        // Adaptation Rule #6: Adjust formation for threat level
        if (threatLevel.equalsIgnoreCase("high")) {
            retrievedCase.updateDescription(retrievedCase.getDescription() + " (Initiate dispersal formation)");
        }
        return retrievedCase;
    }

    public static Case adaptCaseForFatigueLevel(Case retrievedCase, String fatigueLevel) {
        // Adaptation Rule #7: Adjust operation based on crew fatigue
        if (fatigueLevel.equalsIgnoreCase("high")) {
            retrievedCase.updateDescription(retrievedCase.getDescription() + " (Prioritize crew rotation)");
        }
        return retrievedCase;
    }

    // ===================== CASE MATCHING RELATIONS (8) =====================
    // Defines how cases are retrieved from the system
    public static List<Case> retrieveCasesByThreatType(String threatType) {
        // Case Matching Relation #1: Retrieve cases matching threat type
        return CASES.stream().filter(c -> c.getDescription().contains(threatType)).collect(Collectors.toList());
    }

    public static List<Case> retrieveCasesByFleetFormation(String fleetFormation) {
        // Case Matching Relation #2: Retrieve cases based on past fleet coordination
        return CASES.stream().filter(c -> c.getDescription().contains(fleetFormation)).collect(Collectors.toList());
    }

    public static List<Case> retrieveCasesByPreviousEngagements() {
        // Case Matching Relation #3: Retrieve cases that resulted in prior successful engagement
        return CASES.stream().filter(c -> c.getDescription().contains("engagement")).collect(Collectors.toList());
    }

    public static List<Case> retrieveCasesByEnvironmentalFactors(String weather) {
        // Case Matching Relation #4: Retrieve cases with similar environmental conditions
        return CASES.stream().filter(c -> c.getDescription().contains(weather)).collect(Collectors.toList());
    }

    public static List<Case> retrieveCasesByOperationalReadiness(String readinessStatus) {
        // Case Matching Relation #5: Retrieve cases with similar operational readiness
        return CASES.stream().filter(c -> c.getDescription().contains(readinessStatus)).collect(Collectors.toList());
    }

    public static List<Case> retrieveCasesBySensorFusion(String sensorData) {
        // Case Matching Relation #6: Retrieve cases with sensor data
        return CASES.stream().filter(c -> c.getDescription().contains(sensorData)).collect(Collectors.toList());
    }

    public static List<Case> retrieveCasesByEnemyClassification(String enemyType) {
        // Case Matching Relation #7: Retrieve cases with same enemy type
        return CASES.stream().filter(c -> c.getDescription().contains(enemyType)).collect(Collectors.toList());
    }

    public static List<Case> retrieveCasesByRulesOfEngagement(String rules) {
        // Case Matching Relation #8: Retrieve cases with similar ROE
        return CASES.stream().filter(c -> c.getDescription().contains(rules)).collect(Collectors.toList());
    }

    // ===================== ADAPTATION LINKS (7) =====================
    // Defines how retrieved cases are adapted for current use
    public static void applyAdaptationLinks(Case retrievedCase, String newCondition) {
        // Adaptation Link #1: Apply weather adaptation
        adaptCaseForWeather(retrievedCase, newCondition);

        // Adaptation Link #2: Adjust readiness based on fleet status
        adaptCaseForFleetReadiness(retrievedCase, false);

        // Adaptation Link #3: Modify response based on enemy speed
        adaptCaseForEnemySpeed(retrievedCase, 35.0);

        // Adaptation Link #4: Change detection approach based on sensor type
        adaptCaseForDetectionType(retrievedCase, "radar");

        // Adaptation Link #5: Modify tactics based on electronic warfare
        adaptCaseForEWThreat(retrievedCase, true);

        // Adaptation Link #6: Adjust formation based on threat level
        adaptCaseForThreatLevel(retrievedCase, "high");

        // Adaptation Link #7: Adjust operation based on crew fatigue
        adaptCaseForFatigueLevel(retrievedCase, "high");
    }

    // ===================== DYNAMIC RELATIONS (DRels) - Simulated =====================

    // Simulating DRel 1: Threat Sensor Integration (sensorFusion, sensorConfidence)
    public static String integrateSensorData(String radarData, String sonarData) {
        return "Integrated sensor data: Radar - " + radarData + ", Sonar - " + sonarData;
    }

    // Simulating DRel 2: Fleet Readiness Adjustment (fleetOperationalStatus, fleetCrewFatigue)
    public static String adjustFleetReadiness(String equipmentStatus, String crewFatigue) {
        return "Adjusted fleet readiness: Equipment - " + equipmentStatus + ", Crew - " + crewFatigue;
    }

    // Simulating DRel 3: Tactical Threat Assessment (threatClassification, engagementDecision)
    public static String assessThreat(String threatLabel, String rulesOfEngagement) {
        return "Threat assessment: Label - " + threatLabel + ", ROE - " + rulesOfEngagement;
    }

    // Simulating DRel 4: Intelligence-Driven Classification (enemySignatures, historicalEngagement)
    public static String classifyEnemy(String knownSignatures, String historicalData) {
        return "Enemy classification: Signatures - " + knownSignatures + ", History - " + historicalData;
    }
}

/*
Objects:

    KS-TR1
    KS-TR2
    KS-TR3
    KS-TR4
    KS-TR5
    KS-OR1
    KS-OR2
    KS-OR3
    KS-SF1
    KS-SF2
    KS-SF3
    KS-EC1
    KS-EC2
    KS-EC3
    KS-FC1
    KS-FC2
    KS-FC3
    Threat Response Cloud
    Operational Readiness Cloud
    Sensor Fusion Cloud
    Enemy Classification Cloud
    Fleet Coordination Cloud
    lot_Threat_Detection_and_Classification-Step1 (Initial Detection)
    lot_Threat_Detection_and_Classification-Step2 (Tracking and Fusion)
    lot_Threat_Detection_and_Classification-Step3 (Threat Classification)
    lot_Operational_Readiness_Assessment-Step1 (Initial Readiness Assessment)
    lot_Operational_Readiness_Assessment-Step2 (Mission Feasibility Analysis)
    lot_Operational_Readiness_Assessment-Step3 (Final Decision)
    lot_Sensor_Fusion_for_Decision_Making-Step1 (Data Collection)
    lot_Sensor_Fusion_for_Decision_Making-Step2 (Integration and Analysis)
    lot_Sensor_Fusion_for_Decision_Making-Step3 (Classification)
    lot_Fleet_Coordination_and_Threat_Response-Step1 (Real-Time Threat Analysis)
    lot_Fleet_Coordination_and_Threat_Response-Step2 (Fleet Position Adjustment)
    lot_Fleet_Coordination_and_Threat_Response-Step3 (Engagement Decision)
    sensorFusion (DRel)
    sensorConfidence (DRel)
    fleetOperationalStatus (DRel)
    fleetCrewFatigue (DRel)
    threatClassification (DRel)
    engagementDecision (DRel)
    enemySignatures (DRel)
    historicalEngagement (DRel)
    Threat Detection Juncture
    Threat Classification Juncture
    Sensor Fusion Juncture
    Operational Readiness Juncture
    Tactical Decision Making Juncture
    Fleet Coordination Juncture
    Sensor Data Processing Dimension
    Threat Evaluation Dimension
    Multi-Sensor Integration Dimension
    Readiness Assessment Dimension
    Decision Execution Dimension
    Fleet Adaptation Dimension

Properties:

    description
    type
    classification
    combinedConfidence
    confidenceLevel
    confirmedTracks
    decisionThreshold
    detectionCapability
    detectionMode
    detection
    formation
    fusionAlgorithm
    range
    recentSightings
    recommendedAction
    rulesOfEngagement
    sensorRange
    status
    threatLevel
    trackingAlgorithm
    knownSignatures
    operationalStatus
    crewFatigueLevel
    sensorAccuracy
    fleetFormation
    threatAssessment
    fuelLevels
    ammunition
    radar
    sonobuoyNetwork
    fatigueLevel
    crewRotation
    confidence
    acousticSignature
    depth
    currentFormation
    decisionModel
    step1
    step2
    step3
    step4
    sensorDataProcessing
    threatEvaluation
    multiSensorIntegration
    readinessAssessment
    decisionExecution
    fleetAdaptation
    juncture
    sensors
    historicalEngagementData
    decisionPriority
    nextStep (explicit property for LoT linking)
    linkedKS (explicit property for dynamic relation linking)
    associatedKS (explicit property for cloud association linking)
    associatedDimension (explicit property for juncture-to-dimension linking)

Relations (now explicitly modeled and expanded):
Case Matching Relations:

    retrieveCasesByThreatType
    retrieveCasesByFleetFormation
    retrieveCasesByPreviousEngagements
    retrieveCasesByEnvironmentalFactors
    retrieveCasesByOperationalReadiness
    retrieveCasesBySensorFusion
    retrieveCasesByEnemyClassification
    retrieveCasesByRulesOfEngagement

Dynamic Relation Handling (Explicit):

    integrateSensorData (sensorFusion ↔ sensorConfidence)
    adjustFleetReadiness (fleetOperationalStatus ↔ fleetCrewFatigue)
    assessThreat (threatClassification ↔ engagementDecision)
    classifyEnemy (enemySignatures ↔ historicalEngagement)

Explicit Cloud Associations:

    establishCloudRelation(Threat Response Cloud → [KS-TR1, KS-TR2, KS-TR3, KS-TR4, KS-TR5])
    establishCloudRelation(Operational Readiness Cloud → [KS-OR1, KS-OR2, KS-OR3])
    establishCloudRelation(Sensor Fusion Cloud → [KS-SF1, KS-SF2, KS-SF3])
    establishCloudRelation(Enemy Classification Cloud → [KS-EC1, KS-EC2, KS-EC3])
    establishCloudRelation(Fleet Coordination Cloud → [KS-FC1, KS-FC2, KS-FC3])

Explicit Lines of Thought (LoT) Linking:

    linkCases(lot_Threat_Detection_and_Classification-Step1 → lot_Threat_Detection_and_Classification-Step2)
    linkCases(lot_Threat_Detection_and_Classification-Step2 → lot_Threat_Detection_and_Classification-Step3)
    linkCases(lot_Operational_Readiness_Assessment-Step1 → lot_Operational_Readiness_Assessment-Step2)
    linkCases(lot_Operational_Readiness_Assessment-Step2 → lot_Operational_Readiness_Assessment-Step3)
    linkCases(lot_Sensor_Fusion_for_Decision_Making-Step1 → lot_Sensor_Fusion_for_Decision_Making-Step2)
    linkCases(lot_Sensor_Fusion_for_Decision_Making-Step2 → lot_Sensor_Fusion_for_Decision_Making-Step3)
    linkCases(lot_Fleet_Coordination_and_Threat_Response-Step1 → lot_Fleet_Coordination_and_Threat_Response-Step2)
    linkCases(lot_Fleet_Coordination_and_Threat_Response-Step2 → lot_Fleet_Coordination_and_Threat_Response-Step3)

Explicit Juncture and Dimension Linking:

    linkCases(Threat Detection Juncture → Sensor Data Processing Dimension)
    linkCases(Threat Classification Juncture → Threat Evaluation Dimension)
    linkCases(Sensor Fusion Juncture → Multi-Sensor Integration Dimension)
    linkCases(Operational Readiness Juncture → Readiness Assessment Dimension)
    linkCases(Tactical Decision Making Juncture → Decision Execution Dimension)
    linkCases(Fleet Coordination Juncture → Fleet Adaptation Dimension)

Additional explicitly modeled dynamic relations:

    establishDynamicRelation(sensorFusion, KS-SF1, KS-SF2)
    establishDynamicRelation(sensorConfidence, KS-SF2, KS-SF3)
    establishDynamicRelation(fleetOperationalStatus, KS-OR1, KS-OR2)
    establishDynamicRelation(fleetCrewFatigue, KS-OR3, KS-OR1)
    establishDynamicRelation(threatClassification, KS-EC1, KS-EC3)
    establishDynamicRelation(engagementDecision, KS-TR5, KS-FC3)
    establishDynamicRelation(enemySignatures, KS-EC1, KS-EC2)
    establishDynamicRelation(historicalEngagement, KS-TR4, KS-TR5)

*/


