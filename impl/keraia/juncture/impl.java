//Juncture

        naval_scenario.addV("Juncture").addV("Threat Detection").addV("Dimension").addV("Sensor Data Processing").addAtoms(Arrays.asList(KS_TR1, KS_TR2, KS_SF1, KS_SF2));
        naval_scenario.addV("Juncture").addV("Threat Classification").addV("Dimension").addV("Threat Evaluation").addAtoms(Arrays.asList(KS_EC1, KS_EC2, KS_EC3, KS_TR3, KS_TR4));

        naval_scenario.addV("Juncture").addV("Sensor Fusion for Threat Confirmation").addV("Dimension").addV("Multi-Sensor Integration").addAtoms(Arrays.asList(KS_SF1, KS_SF2, KS_SF3, KS_TR3));
        naval_scenario.addV("Juncture").addV("Operational Readiness Assessment").addV("Dimension").addV("Readiness Assessment").addAtoms(Arrays.asList(KS_OR1, KS_OR2, KS_OR3));

        naval_scenario.addV("Juncture").addV("Tactical Decision Making").addV("Dimension").addV("Decision Execution").addAtoms(Arrays.asList(KS_FC2, KS_FC3, KS_TR5));
        naval_scenario.addV("Juncture").addV("Fleet Coordination").addV("Dimension").addV("Fleet Adaptation").addAtoms(Arrays.asList(KS_FC1, KS_FC2, KS_FC3));

