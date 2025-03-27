package ksconvocation;

import java.util.*;
import java.util.function.Function;

import aip.maps.KS;
import aip.maps.PO;
import ksconvocation.KSFrame;

import org.apache.jena.ontology.*;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.vocabulary.RDFS;

import org.neo4j.driver.*;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Transformation functions for various frames in the naval scenario
class Transformations {
    public static KSFrame<String> instantiate(KSFrame<?> frame) {
        // Ensure that data is of type String before casting
        if (frame.getData() instanceof String) {
            String newData = "Identified Object from " + frame.getData();
            return new KSFrame<>(frame.getName(), newData);
        }
        return null;
    }

    public static KS instantiate(KS frame) {
        // Ensure that data is of type String before casting
        if (frame.getData() instanceof PO) {
            String newData = "Identified Object from " + frame.getData();
            KS resultis = new KS(frame.name);
            resultis.addV("data").addA(newData);
            return resultis;
        }
        return null;
    }


    public static KSFrame<String> metaClassTransform(KSFrame<?> frame) {
        if (frame.getData() instanceof String) {
            String newData = "Vessel Class derived from " + frame.getData();
            return new KSFrame<>(frame.getName(), newData);
        }
        return null;
    }

    public static KS metaClassTransform(KS frame) {
        if (frame.getData() instanceof PO) {
            String newData = "Vessel Class derived from " + frame.getData();
            KS resultis = new KS(frame.name);
            resultis.addV("data").addA(newData);
            return resultis;

        }
        return null;
    }


    public static KSFrame<Double> refineSpeed(KSFrame<?> frame) {
        if (frame.getData() instanceof Double) {
            Double newData = (Double) frame.getData() * 1.05; // Add environmental effects
            return new KSFrame<>(frame.getName(), newData);
        }
        return null;
    }

    public static KS refineSpeed(KS frame) {
        if (frame.getData() instanceof Double) {
            Double newData = (Double) frame.getData() * 1.05; // Add environmental effects
            KS resultis = new KS(frame.name);
            resultis.addV("data").addA(newData);
            return resultis;

        }
        return null;
    }


    public static KSFrame<String> aggregateDepth(KSFrame<?> frame) {
        if (frame.getData() instanceof String) {
            String newData = "3D Map generated from depth data " + frame.getData();
            return new KSFrame<>(frame.getName(), newData);
        }
        return null;
    }

    public static KS aggregateDepth(KS frame) {
        if (frame.getData() instanceof PO) {
            String newData = "3D Map generated from depth data " + frame.getData();
            KS resultis = new KS(frame.name);
            resultis.addV("data").addA(newData);
            return resultis;

        }
        return null;
    }


    public static KSFrame<String> extendHistoricalData(KSFrame<?> frame) {
        if (frame.getData() instanceof String) {
            String newData = "Predictive Model based on " + frame.getData();
            return new KSFrame<>(frame.getName(), newData);
        }
        return null;
    }

    public static KS extendHistoricalData(KS frame) {
        if (frame.getData() instanceof PO) {
            String newData = "Predictive Model based on " + frame.getData();
            KS resultis = new KS(frame.name);
            resultis.addV("data").addA(newData);
            return resultis;

        }
        return null;
    }

    public static KSFrame<String> synthesizeMap(KSFrame<?> frame) {
        if (frame.getData() instanceof String) {
            String newData = "Tactical Zones derived from " + frame.getData();
            return new KSFrame<>(frame.getName(), newData);
        }
        return null;
    }

    public static KS synthesizeMap(KS frame) {
        if (frame.getData() instanceof PO) {
            String newData = "Tactical Zones derived from " + frame.getData();
            KS resultis = new KS(frame.name);
            resultis.addV("data").addA(newData);
            return resultis;

        }
        return null;
    }


    public static KSFrame<String> associateAlliedAssets(KSFrame<?> frame) {
        if (frame.getData() instanceof String) {
            String newData = "Engagement Capability with " + frame.getData();
            return new KSFrame<>(frame.getName(), newData);
        }
        return null;
    }

    public static KS associateAlliedAssets(KS frame) {
        if (frame.getData() instanceof PO) {
            String newData = "Engagement Capability with " + frame.getData();

            KS resultis = new KS(frame.name);
            resultis.addV("data").addA(newData);
            return resultis;

        }
        return null;
    }


    public static KSFrame<String> enhanceThreatLevels(KSFrame<?> frame) {
        if (frame.getData() instanceof String) {
            String newData = "Escalation Protocol for " + frame.getData();
            return new KSFrame<>(frame.getName(), newData);
        }
        return null;
    }

    public static KS enhanceThreatLevels(KS frame) {
        if (frame.getData() instanceof PO) {
            String newData = "Escalation Protocol for " + frame.getData();

            KS resultis = new KS(frame.name);
            resultis.addV("data").addA(newData);
            return resultis;


        }
        return null;
    }


    public static KSFrame<String> refineSonarDetection(KSFrame<?> frame) {
        if (frame.getData() instanceof String) {
            String newData = "Enhanced detection from sonar: " + frame.getData();
            return new KSFrame<>(frame.getName(), newData);
        }
        return null;
    }

    public static KS refineSonarDetection(KS frame) {
        if (frame.getData() instanceof PO) {
            String newData = "Enhanced detection from sonar: " + frame.getData();
            KS resultis = new KS(frame.name);
            resultis.addV("data").addA(newData);
            return resultis;
        }
        return null;
    }


    public static KSFrame<String> refineRadarDetection(KSFrame<?> frame) {
        if (frame.getData() instanceof String) {
            String newData = "Refined radar classification: " + frame.getData();
            return new KSFrame<>(frame.getName(), newData);
        }
        return null;
    }

    public static KS refineRadarDetection(KS frame) {
        if (frame.getData() instanceof PO) {
            String newData = "Refined radar classification: " + frame.getData();
            KS resultis = new KS(frame.name);
            resultis.addV("data").addA(newData);
            return resultis;
        }
        return null;
    }


    public static KSFrame<Double> computeThreatProbability(KSFrame<?> frame) {
        if (frame.getData() instanceof Double) {
            Double newData = (Double) frame.getData() + 15.0; // Increase confidence level based on elaboration
            return new KSFrame<>(frame.getName(), newData);
        }
        return null;
    }

    public static KS computeThreatProbability(KS frame) {
        if (frame.getData() instanceof PO) {
            PO pod = (PO) frame.getData();
            Double newData = pod.getDoubleAtom() + 15.0; // Increase confidence level based on elaboration
            KS resultis = new KS(frame.name);
            resultis.addV("data").addA(newData);
            return resultis;

        }
        return null;
    }


    public static KSFrame<String> synthesizeFleetPosition(KSFrame<?> frame) {
        if (frame.getData() instanceof String) {
            String newData = "Optimized fleet formation based on " + frame.getData();
            return new KSFrame<>(frame.getName(), newData);
        }
        return null;
    }

    public static KS synthesizeFleetPosition(KS frame) {
        if (frame.getData() instanceof PO) {
            String newData = "Optimized fleet formation based on " + frame.getData();
            KS resultis = new KS(frame.name);
            resultis.addV("data").addA(newData);
            return resultis;

        }
        return null;
    }


    public static KSFrame<String> updateRulesOfEngagement(KSFrame<?> frame) {
        if (frame.getData() instanceof String) {
            String newData = "Revised ROE considering real-time threat level: " + frame.getData();
            return new KSFrame<>(frame.getName(), newData);
        }
        return null;
    }

    public static KS updateRulesOfEngagement(KS frame) {
        if (frame.getData() instanceof PO) {
            String newData = "Revised ROE considering real-time threat level: " + frame.getData();
            KS resultis = new KS(frame.name);
            resultis.addV("data").addA(newData);
            return resultis;
        }
        return null;
    }


    public static KSFrame<String> enhanceSituationalAwareness(KSFrame<?> frame) {
        if (frame.getData() instanceof String) {
            String newData = "Updated intelligence briefing: " + frame.getData();
            return new KSFrame<>(frame.getName(), newData);
        }
        return null;
    }

    public static KS enhanceSituationalAwareness(KS frame) {
        if (frame.getData() instanceof PO) {
            String newData = "Updated intelligence briefing: " + frame.getData();
            KS resultis = new KS(frame.name);
            resultis.addV("data").addA(newData);
            return resultis;
        }
        return null;
    }

}

// CloudElaborationService manages the transformation from Cloud A to Cloud B
// CloudElaborationService manages the transformation from Cloud A to Cloud B
class CloudElaborationService {

    private List<KSFrame<?>> cloudA;
    private List<Function<KSFrame<?>, KSFrame<?>>> transformations;
    private List<Function<KS, KS>> Transformations;

    private List<KS> CloudA;


    public CloudElaborationService() {
        cloudA = new ArrayList<>();
        CloudA = new ArrayList<>();
        transformations = new ArrayList<>();
        Transformations = new ArrayList<>();
    }

    // Adds frames to the initial cloud
    public void addFrame(KSFrame<?> frame) {
        cloudA.add(frame);
    }

    public void addKS(KS frame) {
        CloudA.add(frame);
    }

    // Adds transformation functions
    public void addTransformation(Function<KSFrame<?>, KSFrame<?>> transformation) {
        transformations.add(transformation);
    }

    public void AddTransformation(Function<KS, KS> transformation) {
        Transformations.add(transformation);
    }


    // Performs the elaboration process: Cloud A -> Cloud B
    public List<KSFrame<?>> elaborate() {
        List<KSFrame<?>> cloudB = new ArrayList<>();
        for (int i = 0; i < cloudA.size(); i++) {
            KSFrame<?> transformedFrame = transformations.get(i).apply(cloudA.get(i));
            cloudB.add(transformedFrame);
        }
        return cloudB;
    }

    public List<KS> elaborateKS() {
        List<KS> CloudB = new ArrayList<>();
        for (int i = 0; i < CloudA.size(); i++) {
            KS transformedFrame = Transformations.get(i).apply(CloudA.get(i));
            CloudB.add(transformedFrame);
        }
        return CloudB;
    }
}


// Main class to demonstrate cloud elaboration
public class NavalCloudElaborationDemo {
    public static void main(String[] args) {
        CloudElaborationService elaborationService = new CloudElaborationService();

        KS KS_TR1 = new KS("KS-TR1");
        KS_TR1.addV("data").addA("Sonar detection: possible submarine contact");

        KS KS_TR2 = new KS("KS-TR2");
        KS_TR2.addV("data").addA("Radar detection: unidentified vessel at 30m depth");

        KS KS_SF3 = new KS("KS-SF3");
        KS_SF3.addV("data").addA(50.0); // Initial threat confidence level

        KS KS_FC1 = new KS("KS-FC1");
        KS_FC1.addV("data").addA("Current fleet formation: defensive perimeter");

        KS KS_TR5 = new KS("KS-TR5");
        KS_TR5.addV("data").addA("Standard engagement protocols");

        KS KS_TR4 = new KS("KS-TR4");
        KS_TR4.addV("data").addA("Latest intelligence: enemy submarine activity");

        elaborationService.addKS(KS_TR1);
        elaborationService.addKS(KS_TR2);
        elaborationService.addKS(KS_SF3);
        elaborationService.addKS(KS_FC1);
        elaborationService.addKS(KS_TR5);
        elaborationService.addKS(KS_TR4);


        // Initialize Cloud A with knowledge sources from the paper
        elaborationService.addFrame(new KSFrame<>("KS-TR1", "Sonar detection: possible submarine contact"));
        elaborationService.addFrame(new KSFrame<>("KS-TR2", "Radar detection: unidentified vessel at 30m depth"));
        elaborationService.addFrame(new KSFrame<>("KS-SF3", 50.0)); // Initial threat confidence level
        elaborationService.addFrame(new KSFrame<>("KS-FC1", "Current fleet formation: defensive perimeter"));
        elaborationService.addFrame(new KSFrame<>("KS-TR5", "Standard engagement protocols"));
        elaborationService.addFrame(new KSFrame<>("KS-TR4", "Latest intelligence: enemy submarine activity"));

        // Define transformations for each KS in Cloud A

        elaborationService.AddTransformation(Transformations::refineSonarDetection);
        elaborationService.AddTransformation(Transformations::refineRadarDetection);
        elaborationService.AddTransformation(Transformations::computeThreatProbability);
        elaborationService.AddTransformation(Transformations::synthesizeFleetPosition);
        elaborationService.AddTransformation(Transformations::updateRulesOfEngagement);
        elaborationService.AddTransformation(Transformations::enhanceSituationalAwareness);

        elaborationService.addTransformation(Transformations::refineSonarDetection);
        elaborationService.addTransformation(Transformations::refineRadarDetection);
        elaborationService.addTransformation(Transformations::computeThreatProbability);
        elaborationService.addTransformation(Transformations::synthesizeFleetPosition);
        elaborationService.addTransformation(Transformations::updateRulesOfEngagement);
        elaborationService.addTransformation(Transformations::enhanceSituationalAwareness);

        // Perform elaboration to create Cloud B
        List<KSFrame<?>> cloudB = elaborationService.elaborate();
        List<KS> CloudB = elaborationService.elaborateKS();

        // Display Cloud B
        System.out.println("Cloud B (Refined Intelligence and Strategy):");
        for (KSFrame<?> frame : cloudB) {
            System.out.println(frame);
        }

        System.out.println("\n--------------------------------------------------------------------------------");
        // Display Cloud B
        System.out.println("Cloud B (Refined Intelligence and Strategy):");
        for (KS frame : CloudB) {
            if (frame == null)
                System.out.println("NULL");
            else
                System.out.println(String.format("%s  %s", frame.name, frame.getData()));
        }

    }

    static void implementations() {


        /*
        ONTOLOGIES
         */
        class NavalOntology {
            private static final String BASE_URI = "http://example.org/naval#";
            private OntModel model;

            public NavalOntology() {
                model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
            }

            /**
             * Create 17 ontology classes representing naval concepts.
             */
            public void createClasses() {
                // Core Entities
                OntClass threat = model.createClass(BASE_URI + "Threat"); // Class #1
                OntClass ship = model.createClass(BASE_URI + "Ship"); // Class #2
                OntClass fleet = model.createClass(BASE_URI + "Fleet"); // Class #3
                OntClass sensor = model.createClass(BASE_URI + "Sensor"); // Class #4
                OntClass weapon = model.createClass(BASE_URI + "Weapon"); // Class #5
                OntClass tacticalDecision = model.createClass(BASE_URI + "TacticalDecision"); // Class #6

                // Additional Entities
                OntClass mission = model.createClass(BASE_URI + "Mission"); // Class #7
                OntClass surveillanceMission = model.createClass(BASE_URI + "SurveillanceMission"); // Class #8
                OntClass attackPlan = model.createClass(BASE_URI + "AttackPlan"); // Class #9
                OntClass fleetCoordination = model.createClass(BASE_URI + "FleetCoordination"); // Class #10
                OntClass threatResponse = model.createClass(BASE_URI + "ThreatResponse"); // Class #11

                // Hierarchical Class Links
                OntClass submarineThreat = model.createClass(BASE_URI + "SubmarineThreat"); // Class #12
                submarineThreat.addSuperClass(threat); // Hierarchy Link #1

                OntClass airborneThreat = model.createClass(BASE_URI + "AirborneThreat"); // Class #13
                airborneThreat.addSuperClass(threat); // Hierarchy Link #2

                OntClass destroyerShip = model.createClass(BASE_URI + "Destroyer"); // Class #14
                destroyerShip.addSuperClass(ship); // Hierarchy Link #3

                OntClass frigateShip = model.createClass(BASE_URI + "Frigate"); // Class #15
                frigateShip.addSuperClass(ship); // Hierarchy Link #4

                OntClass surveillanceSensor = model.createClass(BASE_URI + "SurveillanceSensor"); // Class #16
                surveillanceSensor.addSuperClass(sensor); // Hierarchy Link #5

                OntClass radarSensor = model.createClass(BASE_URI + "RadarSensor"); // Class #17
                radarSensor.addSuperClass(sensor); // Hierarchy Link #6
            }

            /**
             * Define 12 ontology properties (6 object properties, 6 datatype properties).
             */
            public void createProperties() {
                // Object Properties (6)
                ObjectProperty detects = model.createObjectProperty(BASE_URI + "detects"); // Property #1
                detects.addDomain(model.getOntClass(BASE_URI + "Sensor"));
                detects.addRange(model.getOntClass(BASE_URI + "Threat"));

                ObjectProperty assignedTo = model.createObjectProperty(BASE_URI + "assignedTo"); // Property #2
                assignedTo.addDomain(model.getOntClass(BASE_URI + "Ship"));
                assignedTo.addRange(model.getOntClass(BASE_URI + "Fleet"));

                ObjectProperty engages = model.createObjectProperty(BASE_URI + "engages"); // Property #3
                engages.addDomain(model.getOntClass(BASE_URI + "Weapon"));
                engages.addRange(model.getOntClass(BASE_URI + "Threat"));

                ObjectProperty makesDecision = model.createObjectProperty(BASE_URI + "makesDecision"); // Property #4
                makesDecision.addDomain(model.getOntClass(BASE_URI + "Fleet"));
                makesDecision.addRange(model.getOntClass(BASE_URI + "TacticalDecision"));

                ObjectProperty informs = model.createObjectProperty(BASE_URI + "informs"); // Property #5
                informs.addDomain(model.getOntClass(BASE_URI + "Sensor"));
                informs.addRange(model.getOntClass(BASE_URI + "Fleet"));

                ObjectProperty prioritizes = model.createObjectProperty(BASE_URI + "prioritizes"); // Property #6
                prioritizes.addDomain(model.getOntClass(BASE_URI + "TacticalDecision"));
                prioritizes.addRange(model.getOntClass(BASE_URI + "Threat"));

                // Datatype Properties (6)
                DatatypeProperty threatLevel = model.createDatatypeProperty(BASE_URI + "threatLevel"); // Property #7
                threatLevel.addDomain(model.getOntClass(BASE_URI + "Threat"));

                DatatypeProperty confidenceLevel = model.createDatatypeProperty(BASE_URI + "confidenceLevel"); // Property #8
                confidenceLevel.addDomain(model.getOntClass(BASE_URI + "Sensor"));

                DatatypeProperty readinessLevel = model.createDatatypeProperty(BASE_URI + "readinessLevel"); // Property #9
                readinessLevel.addDomain(model.getOntClass(BASE_URI + "Fleet"));

                DatatypeProperty sensorAccuracy = model.createDatatypeProperty(BASE_URI + "sensorAccuracy"); // Property #10
                sensorAccuracy.addDomain(model.getOntClass(BASE_URI + "Sensor"));

                DatatypeProperty engagementOutcome = model.createDatatypeProperty(BASE_URI + "engagementOutcome"); // Property #11
                engagementOutcome.addDomain(model.getOntClass(BASE_URI + "Weapon"));

                DatatypeProperty decisionPriority = model.createDatatypeProperty(BASE_URI + "decisionPriority"); // Property #12
                decisionPriority.addDomain(model.getOntClass(BASE_URI + "TacticalDecision"));
            }

            /**
             * Define 10 SWRL Rules.
             */
            public List<String> createSWRLRules() {
                List<String> rules = new ArrayList<>();

                rules.add("SWRL Rule #1: ?sensor rdf:type :Sensor , :detects ?threat , :confidenceLevel ?conf -> IF ?conf > 0.8 THEN ?threat :threatLevel 5");
                rules.add("SWRL Rule #2: ?ship rdf:type :Destroyer , :assignedTo ?fleet -> ?fleet :readinessLevel 'HIGH'");
                rules.add("SWRL Rule #3: ?threat rdf:type :SubmarineThreat -> ?threat :requiresCountermeasures 'TRUE'");
                rules.add("SWRL Rule #4: ?sensor rdf:type :RadarSensor , :sensorAccuracy ?accuracy -> IF ?accuracy > 0.85 THEN ?sensor :isReliable 'TRUE'");
                rules.add("SWRL Rule #5: ?fleet rdf:type :Fleet , :makesDecision ?decision -> ?decision :decisionPriority 1");
                rules.add("SWRL Rule #6: ?fleet rdf:type :Fleet , :engages ?threat -> ?threat :engagementOutcome 'MITIGATED'");
                rules.add("SWRL Rule #7: ?sensor rdf:type :SurveillanceSensor , :detects ?threat -> ?threat :classifiedAs 'POTENTIAL'");
                rules.add("SWRL Rule #8: ?weapon rdf:type :Weapon , :engages ?threat -> ?threat :status 'NEUTRALIZED'");
                rules.add("SWRL Rule #9: ?tacticalDecision rdf:type :TacticalDecision , :prioritizes ?threat -> ?threat :priorityLevel 3");
                rules.add("SWRL Rule #10: ?threat rdf:type :AirborneThreat , :detectedBy ?sensor -> ?sensor :requiresCalibration 'TRUE'");

                return rules;
            }

            /**
             * Define 3 SWRL-Derived Relations.
             */
            public void createSWRLDerivedRelations() {
                model.createObjectProperty(BASE_URI + "requiresCountermeasures"); // Derived Relation #1
                model.createObjectProperty(BASE_URI + "classifiedAs"); // Derived Relation #2
                model.createObjectProperty(BASE_URI + "requiresCalibration"); // Derived Relation #3
            }

            public static void main(String[] args) {
                NavalOntology navalOntology = new NavalOntology();
                navalOntology.createClasses();
                navalOntology.createProperties();
                navalOntology.createSWRLDerivedRelations();

                List<String> rules = navalOntology.createSWRLRules();
                for (String rule : rules) {
                    System.out.println(rule);
                }
            }
        }


/*
CASE BASED REASONING
 */
        // Case Class: Represents a stored case in the Case-Based Reasoning (CBR) system
        class Case {
            private String id;          // Unique identifier for the case
            private String description; // Description of the case scenario

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

        class NavalCBRSystem {

            // ===================== STORED CASES (17) =====================
            // KS-TR1 to KS-FC3 representing past cases of threat response and fleet coordination
            private static final List<Case> CASES = Arrays.asList(
                    new Case("KS-TR1", "Submarine detected, immediate response"),
                    new Case("KS-TR2", "Airborne threat detected, prepare countermeasures"),
                    new Case("KS-TR3", "Multiple ships detected, assess formation"),
                    new Case("KS-TR4", "Unidentified vessel approaching, maintain distance"),
                    new Case("KS-TR5", "Radar contact lost, deploy UAV"),
                    new Case("KS-TR6", "Confirmed enemy vessel, initiate engagement"),
                    new Case("KS-TR7", "Sonar anomaly, investigate further"),
                    new Case("KS-TR8", "Escort vessel required for logistics ship"),
                    new Case("KS-TR9", "Satellite confirms fleet movement, reposition assets"),
                    new Case("KS-TR10", "Detected torpedo launch, initiate countermeasures"),
                    new Case("KS-TR11", "High-speed vessel detected, intercept"),
                    new Case("KS-TR12", "Weather affecting radar, rely on sonar"),
                    new Case("KS-TR13", "Friendly fire risk, validate target"),
                    new Case("KS-TR14", "Jamming detected, switch to alternative comms"),
                    new Case("KS-TR15", "Electronic warfare detected, deploy counter-EW"),
                    new Case("KS-TR16", "Civilian vessel in conflict zone, establish ID"),
                    new Case("KS-FC3", "Fleet coordination update: defensive posture")
            );

            // ===================== SIMILARITY FUNCTIONS (8) =====================
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

            // ===================== ADAPTATION RULES (5) =====================
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

            // ===================== CASE MATCHING RELATIONS (4) =====================
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

            // ===================== ADAPTATION LINKS (4) =====================
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
            }
        }


    }

    /*
    KNOWLEDGE GRAPH
     */

    public class NavalKnowledgeGraph {
        private static final String URI = "bolt://localhost:7687";
        private static final String USER = "neo4j";
        private static final String PASSWORD = "password";

        private final Driver driver;

        public NavalKnowledgeGraph() {
            driver = GraphDatabase.driver(URI, AuthTokens.basic(USER, PASSWORD));
        }

        public void createGraph() {
            try (Session session = driver.session()) {

                // ----------------------
                // Creating Nodes (17)
                // ----------------------
                String[] knowledgeSources = {
                        "KS-TR1", "KS-TR2", "KS-TR3", "KS-TR4", "KS-TR5",
                        "KS-TR6", "KS-TR7", "KS-TR8", "KS-TR9", "KS-TR10",
                        "KS-FC1", "KS-FC2", "KS-FC3", "KS-TR11", "KS-TR12",
                        "KS-TR13", "KS-TR14"
                };

                for (String ks : knowledgeSources) {
                    session.run("CREATE (n:KnowledgeSource {name: $name})", Values.parameters("name", ks));
                }

                // ----------------------
                // Creating Edges (15)
                // ----------------------
                String[] edges = {
                        "KS-TR1:DERIVES:KS-TR2",
                        "KS-TR2:ANALYZES:KS-TR3",
                        "KS-TR3:INTEGRATES:KS-TR4",
                        "KS-TR4:SUPPORTS:KS-FC1",
                        "KS-FC1:COLLABORATES:KS-FC2",
                        "KS-FC2:VALIDATES:KS-FC3",
                        "KS-TR5:SYNTHESIZES:KS-TR6",
                        "KS-TR6:REINFORCES:KS-TR7",
                        "KS-TR7:LINKS:KS-TR8",
                        "KS-TR8:COMBINES:KS-TR9",
                        "KS-TR10:DEPLOYS:KS-TR11",
                        "KS-TR11:EVALUATES:KS-TR12",
                        "KS-TR12:CLASSIFIES:KS-TR13",
                        "KS-TR13:UPDATES:KS-TR14",
                        "KS-TR14:OPTIMIZES:KS-TR1"
                };

                for (String edge : edges) {
                    String[] parts = edge.split(":");
                    session.run("MATCH (a:KnowledgeSource {name:$a}), (b:KnowledgeSource {name:$b}) " +
                                    "CREATE (a)-[r:" + parts[1] + "]->(b)",
                            Values.parameters("a", parts[0], "b", parts[2]));
                }

/*
                //Triggers

                // Trigger #1: UpdateThreatConfidence
                CALL apoc.trigger.add(
                        'UpdateThreatConfidence',
                        'MATCH (t:Threat) WHERE t.confidence < 50 SET t.status = "Review Required"',
                        {}
                );

// Trigger #2: AdjustFleetPosition
                CALL apoc.trigger.add(
                        'AdjustFleetPosition',
                        'MATCH (f:Fleet)-[:DETECTS]->(t:Threat) WHERE t.threatLevel > 80 SET f.position = "Defensive"',
                        {}
                );

// Trigger #3: ClassifyThreat
                CALL apoc.trigger.add(
                        'ClassifyThreat',
                        'MATCH (t:Threat) WHERE t.type = "Submarine" SET t.classification = "High Risk"',
                        {}
                );

// Trigger #4: EvaluateSensorReliability
                CALL apoc.trigger.add(
                        'EvaluateSensorReliability',
                        'MATCH (s:Sensor)-[:REPORTS]->(t:Threat) WHERE s.reliability < 70
                        SET t.confidence = t.confidence * 0.8',
                {}
);

// Trigger #5: ReinforceDetection
                CALL apoc.trigger.add(
                        'ReinforceDetection',
                        'MATCH (s:Sensor)-[:DETECTS]->(t:Threat) WHERE t.confidence > 90
                        SET s.alert = "Critical"',
                {}
);

// Trigger #6: CoordinateFleetResponse
                CALL apoc.trigger.add(
                        'CoordinateFleetResponse',
                        'MATCH (f:Fleet)-[:MONITORS]->(t:Threat) WHERE t.threatLevel > 85
                        SET f.mode = "Combat Ready"',
                {}
);

// Trigger #7: UpdateTacticalPosition
                CALL apoc.trigger.add(
                        'UpdateTacticalPosition',
                        'MATCH (s:Ship)-[:ANALYZES]->(t:Threat) WHERE t.threatLevel > 60
                        SET s.position = "Alert Mode"',
                {}
);

// Trigger #8: EnhanceTracking
                CALL apoc.trigger.add(
                        'EnhanceTracking',
                        'MATCH (r:Radar)-[:TRACKS]->(t:Threat) WHERE r.precision > 95
                        SET t.verified = true',
                {}
);

// Trigger #9: MergeThreatReports
                CALL apoc.trigger.add(
                        'MergeThreatReports',
                        'MATCH (t1:Threat)-[:RELATED_TO]->(t2:Threat) WHERE t1.location = t2.location
                        SET t1.merged = true',
                {}
);

// Trigger #10: ValidateIntelligence
                CALL apoc.trigger.add(
                        'ValidateIntelligence',
                        'MATCH (i:Intelligence)-[:CONFIRMS]->(t:Threat) WHERE i.confidence > 90
                        SET t.status = "Verified"',
                {}
);

// Trigger #11: SimulateThreatScenario
                CALL apoc.trigger.add(
                        'SimulateThreatScenario',
                        'MATCH (t:Threat)-[:MODELED_AS]->(s:Simulation)
                        SET s.status = "Active"',
                {}
);

// Trigger #12: OptimizeFleetDeployment
                CALL apoc.trigger.add(
                        'OptimizeFleetDeployment',
                        'MATCH (f:Fleet)-[:DEPLOYED_TO]->(r:Region) WHERE r.threatLevel > 70
                        SET f.status = "Reinforced"',
                {}
);

// Trigger #13: RecalculateThreatImpact
                CALL apoc.trigger.add(
                        'RecalculateThreatImpact',
                        'MATCH (t:Threat) WHERE t.escalationPotential > 0.8
                        SET t.riskLevel = "Severe"',
                {}
);
*/
                // ----------------------
                // Creating Inference Rules (13)
                // ----------------------
                String[] inferenceRules = {
                        "CALL apoc.trigger.add('UpdateThreatConfidence', 'MATCH (t:Threat) WHERE t.confidence < 50 SET t.status = \"Review Required\"', {})",
                        "CALL apoc.trigger.add('AdjustFleetPosition', 'MATCH (f:Fleet)-[:DETECTS]->(t:Threat) WHERE t.threatLevel > 80 SET f.position = \"Defensive\"', {})",
                        "CALL apoc.trigger.add('ClassifyThreat', 'MATCH (t:Threat) WHERE t.type = \"Submarine\" SET t.classification = \"High Risk\"', {})",
                        "CALL apoc.trigger.add('EvaluateSensorReliability', 'MATCH (s:Sensor)-[:REPORTS]->(t:Threat) WHERE s.reliability < 70 SET t.confidence = t.confidence * 0.8', {})",
                        "CALL apoc.trigger.add('ReinforceDetection', 'MATCH (s:Sensor)-[:DETECTS]->(t:Threat) WHERE t.confidence > 90 SET s.alert = \"Critical\"', {})",
                        "CALL apoc.trigger.add('CoordinateFleetResponse', 'MATCH (f:Fleet)-[:MONITORS]->(t:Threat) WHERE t.threatLevel > 85 SET f.mode = \"Combat Ready\"', {})",
                        "CALL apoc.trigger.add('UpdateTacticalPosition', 'MATCH (s:Ship)-[:ANALYZES]->(t:Threat) WHERE t.threatLevel > 60 SET s.position = \"Alert Mode\"', {})",
                        "CALL apoc.trigger.add('EnhanceTracking', 'MATCH (r:Radar)-[:TRACKS]->(t:Threat) WHERE r.precision > 95 SET t.verified = true', {})",
                        "CALL apoc.trigger.add('MergeThreatReports', 'MATCH (t1:Threat)-[:RELATED_TO]->(t2:Threat) WHERE t1.location = t2.location SET t1.merged = true', {})",
                        "CALL apoc.trigger.add('ValidateIntelligence', 'MATCH (i:Intelligence)-[:CONFIRMS]->(t:Threat) WHERE i.confidence > 90 SET t.status = \"Verified\"', {})",
                        "CALL apoc.trigger.add('SimulateThreatScenario', 'MATCH (t:Threat)-[:MODELED_AS]->(s:Simulation) SET s.status = \"Active\"', {})",
                        "CALL apoc.trigger.add('OptimizeFleetDeployment', 'MATCH (f:Fleet)-[:DEPLOYED_TO]->(r:Region) WHERE r.threatLevel > 70 SET f.status = \"Reinforced\"', {})",
                        "CALL apoc.trigger.add('RecalculateThreatImpact', 'MATCH (t:Threat) WHERE t.escalationPotential > 0.8 SET t.riskLevel = \"Severe\"', {})"
                };

                for (String rule : inferenceRules) {
                    session.run(rule);
                }

                // ----------------------
                // Creating Graph-Based Relations (5)
                // ----------------------
                session.run("MATCH (a:KnowledgeSource), (b:KnowledgeSource) " +
                        "WHERE a.name STARTS WITH 'KS' AND b.name STARTS WITH 'KS' " +
                        "CREATE (a)-[:CONNECTS]->(b)");

                session.run("MATCH (t:Threat)-[:IDENTIFIED_BY]->(i:Intelligence) CREATE (t)-[:VERIFIED_BY]->(i)");
                session.run("MATCH (r:Radar)-[:TRACKS]->(t:Threat) CREATE (t)-[:CORROBORATED_BY]->(r)");
                session.run("MATCH (s:Ship)-[:MONITORS]->(t:Threat) CREATE (t)-[:EVALUATED_BY]->(s)");
                session.run("MATCH (s:Sensor)-[:REPORTS]->(t:Threat) CREATE (t)-[:ANALYZED_BY]->(s)");

                // ----------------------
                // Creating Multi-Sensor Data Coherence (3)
                // ----------------------
                session.run("MATCH (s1:Sensor)-[:DETECTS]->(t:Threat), (s2:Sensor)-[:DETECTS]->(t) " +
                        "WHERE s1.data != s2.data SET t.confidence = 0.75 * t.confidence");

                session.run("MATCH (t:Threat)-[:VERIFIED_BY]->(i:Intelligence) " +
                        "SET t.confidence = (t.confidence + i.reliability) / 2");

                session.run("MATCH (s:Sensor)-[:CORROBORATES]->(t:Threat) WHERE s.accuracy > 90 " +
                        "SET t.confidence = t.confidence * 1.1");
            }
        }

        public void close() {
            driver.close();
        }

        public static void main(String[] args) {
            System.out.println("Naval Knowledge Graph Created Successfully.");
        }
    }

}

