package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotAnalyser {
    Map<Integer, String> plotList = new HashMap<>();

    public boolean allocateEmptySlotToParkVehicles(String vehicleNamePlate) {
        if (vehicleNamePlate != null) {
            plotList.put(1, vehicleNamePlate);
            return true;
        }
        return false;

    }
}
