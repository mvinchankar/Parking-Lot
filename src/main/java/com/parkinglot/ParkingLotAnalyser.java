package com.parkinglot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ParkingLotAnalyser {
    Map<ParkingType, ArrayList<VehicleDetails>> plotList;
    ArrayList<VehicleDetails> detailsArrayList = new ArrayList<>(100);
    int initialParkingSlots = 5;

    public ParkingLotAnalyser() {
        this.plotList = new HashMap<>();
    }

    public Map<ParkingType, ArrayList<VehicleDetails>> allocateEmptySlotToParkVehicles(ParkingType parkingType,
                                                                                       VehicleDetails... details) throws ParkingLotException {
        if (details != null) {
            int remainingSlots = 0;
            plotList.put(parkingType, detailsArrayList);
            for (VehicleDetails i : details) {
                if (detailsArrayList.size() != initialParkingSlots) {
                    plotList.get(parkingType).add(i);
                } else {
                    throw new ParkingLotException("PARKING LOT FULLED!!!!!!!!",
                            ParkingLotException.ExceptionType.PARKING_LOT_FULLED);
                }
            }
            return plotList;
        }
        return null;
    }

    public boolean findVehicleInParkingLotToUnparkVehicle(String numberPlateOfVehicle) {
        for (int i = 0; i < detailsArrayList.size(); i++) {
            if (detailsArrayList.get(i).numberPlateOfVehicle.equals(numberPlateOfVehicle)) {
                System.out.println("Vehicle Unparked..." + detailsArrayList.get(i).numberPlateOfVehicle);
                detailsArrayList.remove(i);
                return true;
            }
        }
        return false;
    }
}
