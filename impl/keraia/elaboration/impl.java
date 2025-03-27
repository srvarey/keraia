        CloudElaborationService elaborationService = new CloudElaborationService();


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


        // Perform elaboration to create Cloud B
        List<KS> CloudB = elaborationService.elaborateKS();

