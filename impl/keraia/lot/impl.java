

        //Lines of thoght
        KS lot_Threat_Detection_and_Classification = new KS("lot_Threat_Detection_and_Classification");
        lot_Threat_Detection_and_Classification.addV("type").addA("LoT");

        KS lot_Operational_Readiness_Assessment = new KS("Operational_Readiness_Assessment");
        lot_Operational_Readiness_Assessment.addV("type").addA("LoT");

        KS lot_Sensor_Fusion_for_Decision_Making = new KS("lot_TSensor_Fusion_for_Decision_Making");
        lot_Sensor_Fusion_for_Decision_Making.addV("type").addA("LoT");

        KS lot_Fleet_Coordination_and_Threat_Response= new KS("lot_Fleet_Coordination_and_Threat_Response");
        lot_Fleet_Coordination_and_Threat_Response.addV("type").addA("LoT");


        lot_Threat_Detection_and_Classification.addV("step-1").addV("Initial Detection").addA("KS_TR1").addA("Radar");
        lot_Threat_Detection_and_Classification.addV("step-1").addV("Initial Detection").addA("KS_TR2").addA("Sonobuoy Network");
        lot_Threat_Detection_and_Classification.addV("step-2").addV("Tracking and Data Fusion").addA("KS_TR3").addA("Tracking System");
        lot_Threat_Detection_and_Classification.addV("step-2").addV("Tracking and Data Fusion").addA("KS_SF1").addA("Sonobuoy Data");
        lot_Threat_Detection_and_Classification.addV("step-2").addV("Tracking and Data Fusion").addA("KS_SF3").addA("AI Fusion System");
        lot_Threat_Detection_and_Classification.addV("step-3").addV("Classification").addA("KS_EC1").addA("Intelligence Database");
        lot_Threat_Detection_and_Classification.addV("step-3").addV("Classification").addA("KS_EC2").addA("Sensor Data");
        lot_Threat_Detection_and_Classification.addV("step-3").addV("Classification").addA("KS_EC3").addA("Classification System");
        lot_Threat_Detection_and_Classification.addV("step-4").addV("Classification").addA("KS_TR4").addA("Intelligence Reports");
        lot_Threat_Detection_and_Classification.addV("step-4").addV("Classification").addA("KS_TR5").addA("Command Centre");

        lot_Operational_Readiness_Assessment.addV("step-1").addV("Status Assessment").addA("KS_OR1").addA("Fleet Readiness");
        lot_Operational_Readiness_Assessment.addV("step-1").addV("Status Assessment").addA("KS_OR2").addA("Equipment Status");
        lot_Operational_Readiness_Assessment.addV("step-1").addV("Status Assessment").addA("KS_OR3").addA("Crew Readiness");
        lot_Operational_Readiness_Assessment.addV("step-2").addV("Mission Feasibility Analysis").addA("KS_FC1").addA("Fleet Positioning System");
        lot_Operational_Readiness_Assessment.addV("step-2").addV("Mission Feasibility Analysis").addA("KS_FC2").addA("Threat Level Assessment");
        lot_Operational_Readiness_Assessment.addV("step-3").addV("Final Decision").addA("KS_FC3").addA("Tactical AI");
        lot_Operational_Readiness_Assessment.addV("step-3").addV("Final Decision").addA("KS_TR5").addA("Command Centre");



        lot_Sensor_Fusion_for_Decision_Making.addV("step-1").addV("Data Collection").addA("KS_SF1").addA("Sonobuoy Data");
        lot_Sensor_Fusion_for_Decision_Making.addV("step-1").addV("Data Collection").addA("KS_SF2").addA("Radar Contacts");
        lot_Sensor_Fusion_for_Decision_Making.addV("step-2").addV("Data Integration and Analysis").addA("KS_SF3").addA("AI Fusion System");
        lot_Sensor_Fusion_for_Decision_Making.addV("step-3").addV("Threat Classification").addA("KS_EC1").addA("Intelligence Database");
        lot_Sensor_Fusion_for_Decision_Making.addV("step-3").addV("Threat Classification").addA("KS_EC3").addA("Classification System");


        lot_Fleet_Coordination_and_Threat_Response.addV("step-1").addV("Real-Time Threat Analysis").addA("KS_FC2").addA("Threat Level Assessment");
        lot_Fleet_Coordination_and_Threat_Response.addV("step-1").addV("Real-Time Threat Analysis").addA("KS_EC3").addA("Classification System");
        lot_Fleet_Coordination_and_Threat_Response.addV("step-2").addV("Fleet Position Adjustment").addA("KS_FC1").addA("Fleet Positioning System");
        lot_Fleet_Coordination_and_Threat_Response.addV("step-2").addV("Fleet Position Adjustment").addA("KS_FC3").addA("Tactical AI");
        lot_Fleet_Coordination_and_Threat_Response.addV("step-2").addV("Engagement Decision").addA("KS_TR5").addA("Command Center");
        lot_Fleet_Coordination_and_Threat_Response.addV("step-2").addV("Engagement Decision").addA("KS_TR4").addA("Intelligence Reports");


        naval_scenario.addV("LoT").addV(lot_Threat_Detection_and_Classification);
        naval_scenario.addV("LoT").addV(lot_Operational_Readiness_Assessment);
        naval_scenario.addV("LoT").addV(lot_Sensor_Fusion_for_Decision_Making);
        naval_scenario.addV("LoT").addV(lot_Fleet_Coordination_and_Threat_Response);


