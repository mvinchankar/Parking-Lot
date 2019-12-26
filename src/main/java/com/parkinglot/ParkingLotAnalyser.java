package com.parkinglot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ParkingLotAnalyser {
    Map<ParkingType, ArrayList<VehicleDetails>> plotList;
    ArrayList<VehicleDetails> detailsArrayList = new ArrayList<>(100);
    int initialParkingSlots = 100;

    public ParkingLotAnalyser() {
        this.plotList = new HashMap<>();
    }

    public Map<ParkingType, ArrayList<VehicleDetails>> allocateEmptySlotToParkVehicles(ParkingType parkingType,
                                                                                       VehicleDetails... details) {
        if (details != null) {
            int remainingSlots = 0;
            plotList.put(parkingType, detailsArrayList);
            for (VehicleDetails i : details) {
                plotList.get(parkingType).add(i);
                remainingSlots = initialParkingSlots - plotList.get(parkingType).size();
            }
            System.out.println("RemainingSlots:" + remainingSlots);
            return plotList;
        }
        return null;
    }

    public boolean findVehicleInParkingLotToUnparkVehicle(String numberPlateOfVehicle) {
        System.out.println(detailsArrayList.size());
        for (int i = 0; i < detailsArrayList.size(); i++) {
            if (detailsArrayList.get(i).numberPlateOfVehicle.equals(numberPlateOfVehicle)) {
                System.out.println("Vehicle Unparked..."+detailsArrayList.get(i).numberPlateOfVehicle);
                detailsArrayList.remove(i);
                return true;
            }
        }
        return false;
    }
}
