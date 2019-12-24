package com.parkinglot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ParkingLotAnalyser {
    Map<String, ArrayList<VehicleDetails>> plotList = new HashMap<>();

    public Map<String, ArrayList<VehicleDetails>> allocateEmptySlotToParkVehicles(VehicleDetails details) {
        if (details != null) {
            plotList.put("Normal", new ArrayList<VehicleDetails>());
            plotList.get("Normal").add(details);
            return plotList;
        }
        return null;
    }
}
