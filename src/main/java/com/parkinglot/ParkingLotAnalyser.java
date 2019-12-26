package com.parkinglot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ParkingLotAnalyser {
    Map<String, ArrayList<VehicleDetails>> plotList;

    public ParkingLotAnalyser() {
        this.plotList = new HashMap<>();
    }

    public Map<String, ArrayList<VehicleDetails>> allocateEmptySlotToParkVehicles(VehicleDetails... details) {
        if (details != null) {
            plotList.put("Normal", new ArrayList<VehicleDetails>(100));
            for (VehicleDetails i : details) {
                plotList.get("Normal").add(i);
            }
            return plotList;
        }
        return null;
    }
}
