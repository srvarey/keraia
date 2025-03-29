```
KS pump         = new KS("pump");
KS installation = new KS("installation");
KS vent         = new KS("vent");

// Define a dynamic relationship between pump and installation

KS pumpInstallationRel = 
ontology.aquire( "installed_in",  
                 "installation_of", 
                 pump, 
                 installation, 
                 "location",     
                 "pump_location",  installation_location");

// Define a dynamic relationship between vent and installation

KS ventInstallationRel = 
ontology.aquire("located_in",  
                "location_of",  
                vent,  
                installation,  
                "position",  
                "vent_position",  
                "installation_position");

// Define a dynamic relationship between pump and vent

KS pumpVentRel = 
ontology.aquire( "connected_to",  
                 "connected_to",  
                 pump,  
                 vent,  
                 "status",  
                 "pump_status", 
                 "vent_status");
```