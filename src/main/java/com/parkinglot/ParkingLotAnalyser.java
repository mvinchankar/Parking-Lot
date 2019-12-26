package com.parkinglot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ParkingLotAnalyser {
    Map<ParkingType, ArrayList<VehicleDetails>> plotList;

    public ParkingLotAnalyser() {
        this.plotList = new HashMap<>();
    }

    public Map<ParkingType, ArrayList<VehicleDetails>> allocateEmptySlotToParkVehicles(ParkingType parkingType,
                                                                                       VehicleDetails... details) {
        if (details != null) {
            plotList.put(parkingType, new ArrayList<VehicleDetails>(100));
            for (VehicleDetails i : details) {
                plotList.get(parkingType).add(i);
            }
            return plotList;
        }
        return null;
    }
}
