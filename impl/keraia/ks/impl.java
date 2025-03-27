// Add Knowledge Sources (KS) to the Cloud
        navalRecon.addV("KS-TR1").addV("sensors").addV("Radar APS-124");
        navalRecon.addV("KS-TR2").addV("sensors").addV("Sonobuoy Network");


// Define Threat Response Knowledge Sources
        KS KS_TR1 = new KS("KS-TR1");
        KS_TR1.addV("type").addA("knowledge source")
                .addV("status").addA("active")
                .addV("detection capability").addA("radar")
                .addV("range").addA("100 nautical miles");

        KS KS_TR2 = new KS("KS-TR2");
        KS_TR2.addV("type").addA("knowledge source")
                .addV("sensor range").addA("5 nautical miles")
                .addV("detection mode").addA("passive/active");

        KS KS_TR3 = new KS("KS-TR3");
        KS_TR3.addV("type").addA("knowledge source")
                .addV("confirmed tracks").addA("3")
                .addV("tracking algorithm").addA("Kalman filter");

        KS KS_TR4 = new KS("KS-TR4");
        KS_TR4.addV("type").addA("knowledge source")
                .addV("recent sightings").addA("enemy submarine detected")
                .addV("confidence level").addA("80%");

        KS KS_TR5 = new KS("KS-TR5");
        KS_TR5.addV("type").addA("knowledge source")
                .addV("rules of engagement").addA("Engage if confirmed hostile");


// Define Operational Readiness Knowledge Sources
        KS KS_OR1 = new KS("KS-OR1");
        KS_OR1.addV("type").addA("knowledge source")
                .addV("status").addA("combat ready")
                .addV("fuel levels").addA("80%")
                .addV("ammunition").addA("90%");

        KS KS_OR2 = new KS("KS-OR2");
        KS_OR2.addV("type").addA("knowledge source")
                .addV("radar").addA("operational")
                .addV("sonobuoy network").addA("functional");

        KS KS_OR3 = new KS("KS-OR3");
        KS_OR3.addV("type").addA("knowledge source")
                .addV("fatigue level").addA("low")
                .addV("crew rotation").addA("scheduled");


// Define Sensor Fusion Knowledge Sources
        KS KS_SF1 = new KS("KS-SF1");
        KS_SF1.addV("type").addA("knowledge source")
                .addV("detection").addA("acoustic anomaly")
                .addV("confidence").addA("50%");

        KS KS_SF2 = new KS("KS-SF2");
        KS_SF2.addV("type").addA("knowledge source")
                .addV("detection").addA("object at 50m depth")
                .addV("classification").addA("unknown");

        KS KS_SF3 = new KS("KS-SF3");
        KS_SF3.addV("type").addA("knowledge source")
                .addV("fusion algorithm").addA("Bayesian Inference")
                .addV("combined confidence").addA("75%");


// Define Enemy Classification Knowledge Sources
        KS KS_EC1 = new KS("KS-EC1");
        KS_EC1.addV("type").addA("knowledge source")
                .addV("known signatures").addA("Type-212 Submarine, Kilo-Class Submarine");

        KS KS_EC2 = new KS("KS-EC2");
        KS_EC2.addV("type").addA("knowledge source")
                .addV("acoustic signature").addA("unknown")
                .addV("depth").addA("300m");

        KS KS_EC3 = new KS("KS-EC3");
        KS_EC3.addV("type").addA("knowledge source")
                .addV("classification").addA("pending")
                .addV("decision threshold").addA("90%");


// Define Fleet Coordination Knowledge Sources
        KS KS_FC1 = new KS("KS-FC1");
        KS_FC1.addV("type").addA("knowledge source")
                .addV("current formation").addA("defensive perimeter");

        KS KS_FC2 = new KS("KS-FC2");
        KS_FC2.addV("type").addA("knowledge source")
                .addV("threat level").addA("high")
                .addV("recommended action").addA("disperse");

        KS KS_FC3 = new KS("KS-FC3");
        KS_FC3.addV("type").addA("knowledge source")
                .addV("decision model").addA("Markov Decision Process");

        KS threat_Response = new KS("threat_Response");
        threat_Response.addV("type").addA("cloud");

        threat_Response.addV(KS_TR1);
        threat_Response.addV(KS_TR2);
        threat_Response.addV(KS_TR3);
        threat_Response.addV(KS_TR4);
        threat_Response.addV(KS_TR5);

        KS Operational_Readiness = new KS("Operational_Readiness");
        Operational_Readiness.addV("type").addA("cloud");

        Operational_Readiness.addV(KS_OR1);
        Operational_Readiness.addV(KS_OR2);
        Operational_Readiness.addV(KS_OR3);

        KS Sensor_Fusion = new KS("Sensor_Fusion");
        Sensor_Fusion.addV("type").addA("cloud");

        Sensor_Fusion.addV(KS_SF1);
        Sensor_Fusion.addV(KS_SF2);
        Sensor_Fusion.addV(KS_SF3);

        KS Enemy_Classification = new KS("Enemy_Classification");
        Enemy_Classification.addV("type").addA("cloud");

        Enemy_Classification.addV(KS_EC1);
        Enemy_Classification.addV(KS_EC2);
        Enemy_Classification.addV(KS_EC3);

        KS Fleet_Coordination = new KS("Fleet_Coordination");
        Fleet_Coordination.addV("type").addA("cloud");

        Fleet_Coordination.addV(KS_FC1);
        Fleet_Coordination.addV(KS_FC2);
        Fleet_Coordination.addV(KS_FC3);


