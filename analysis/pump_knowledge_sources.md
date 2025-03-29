
```
knowledge_source PumpCommunicationFault {
  warning_and_alarm_codes: 
        "Pump communication fault (EPCF) Alarm";
  fault: 
        "Communication fault between different parts of the electronics.";
  auto_reset_and_restart: 
        "Yes";
  corrective_action: 
        "Replace the pump, or call service for assistance. Check if the pump 
        is running in turbine operation. See code (EFP) Forced pumping.";
}

knowledge_source ForcedPumping {
  warning_and_alarm_codes: 
        "Forced pumping (EFP) Alarm";
  fault: 
        "Other pumps or sources force flow through the pump even if the pump 
        is stopped and switched off.";
  auto_reset_and_restart: 
        "Yes";
  corrective_action: 
        "Switch off the pump on the main switch. If the light is on, 
        the pump is running in forced-pumping mode. 
        Check the system for defective non-return valves and replace, 
        if necessary. Check the system for correct position of non-return 
        valves, etc";
}

knowledge_source Undervoltage {
  warning_and_alarm_codes: 
        "Undervoltage (EUV) Alarm";
  fault: 
        "Supply voltage to the pump too low.";
  auto_reset_and_restart: 
        "Yes";
  corrective_action: 
        "Check that the power supply is within the specified range.";
}

knowledge_source BlockedPump {
  warning_and_alarm_codes: 
        "Blocked pump (EBP) Alarm";
  fault: 
        "The pump is blocked.";
  auto_reset_and_restart: 
        "No";
  corrective_action: 
        "Dismantle the pump, and remove any foreign matter or impurities preventing 
        the pump from rotating.";
}

knowledge_source DryRunning {
  warning_and_alarm_codes: 
        "Dry running (EDR) Alarm";
  fault: 
        "No water at the pump inlet or the water contains too much air.";
  auto_reset_and_restart: 
        "No";
  corrective_action: 
        "Prime and vent the pump before a new start-up. Check that the pump is 
        operating correctly. If not, replace the pump, or call service for 
        assistance.";
}

knowledge_source HighMotorTemperature {
  warning_and_alarm_codes: 
        "High motor temperature (EHMT) Alarm";
  fault: 
        "Temperature in stator windings too high";
  auto_reset_and_restart: 
        "No";
  corrective_action: 
        Check the winding resistance according to the M3 service instructions
}

knowledge_source InternalFault {
  warning_and_alarm_codes: 
        "Internal fault (72, 84, 155, 157) Warning/alarm";
  fault: 
        "Internal fault in the pump electronics";
  auto_reset_and_restart: 
        "Yes";
  corrective_action: 
        "Replace the pump, or call service for assistance.";
}

knowledge_source Overvoltage {
  warning_and_alarm_codes: 
        "Overvoltage (EOV) Alarm";
  fault: 
        "Supply voltage to the pump too high.";
  auto_reset_and_restart: 
        "Yes";
  corrective_action: 
        "Check that the power supply is within the specified range.";
}

knowledge_source CommunicationFaultTwinHeadPump {
  warning_and_alarm_codes: 
        "Communication fault, twin-head pump (ECF) Warning";
  fault: 
        "Communication between pump heads disturbed or broken.";
  auto_reset_and_restart: 
        "Yes";
  corrective_action: 
        "Check that the second pump head is powered or connected to the 
        power supply.";
}

knowledge_source InternalSensorFault {
  warning_and_alarm_codes: 
        "Internal sensor fault (EIS) Warning";
  fault: 
        "The pump is receiving a signal from the internal sensor which is 
        outside the normal range.";
  auto_reset_and_restart: 
        "Yes";
  corrective_action: 
        "Check that the plug and cable are connected correctly in the 
        sensor. The sensor is located on the back of the pump housing. 
        Replace the sensor, or call service for assistance.";
}

knowledge_source ExternalSensorFault {
  warning_and_alarm_codes: 
        "External sensor fault (EES) Warning";
  fault: 
        "The pump is receiving a signal from the external sensor which is 
        outside the normal range.";
  auto_reset_and_restart: 
        "Yes";
  corrective_action: 
        "Does the electrical signal set (0-10 V or 4-20 mA) match the 
        sensor output signal? If not, change the setting of the analog 
        input, or replace the sensor with one that matches the setup. 
        Check the sensor cable for damage. Check the cable connection 
        at the pump and at the sensor. Correct the connection, if 
        required. The sensor has been removed, but the analog input has 
        not been disabled. Replace the sensor, or call service for 
        assistance.";
}
```
