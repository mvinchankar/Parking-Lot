package com.parkinglot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ParkingLotAnalyser {
    Map<ParkingType, ArrayList<VehicleDetails>> plotList;
    int maximumParkingSlots = 5;
    int getSizeOfParkingSlots = 100;
    ArrayList<VehicleDetails> detailsArrayList = new ArrayList<>();

    public ParkingLotAnalyser() {
        this.plotList = new HashMap<>();
    }

    public void initialParkingSlots() {
        for (int i = 0; i < maximumParkingSlots; i++) {
            detailsArrayList.add(null);
        }
    }

    public Map<ParkingType, ArrayList<VehicleDetails>> allocateEmptySlotToParkVehicles
            (ParkingType parkingType, VehicleDetails details) throws ParkingLotException {
        if (detailsArrayList.size() == maximumParkingSlots) {
            for (int i = 0; i < detailsArrayList.size(); i++)
                if (detailsArrayList.get(i) == null) {
                    detailsArrayList.remove(i);
                    detailsArrayList.add(i, details);
                }
        }
        if (detailsArrayList.stream().filter(vehicle -> vehicle.numberPlateOfVehicle != null).count() == maximumParkingSlots)
            throw new ParkingLotException("FULLED!!!!!!!", ParkingLotException.ExceptionType.PARKING_LOT_FULLED);
        plotList.put(parkingType, detailsArrayList);
        return plotList;
    }

    public boolean findVehicleInParkingLotToUnparkVehicle(String numberPlateOfVehicle) {
        for (int i = 0; i < detailsArrayList.size(); i++) {
            if (detailsArrayList.get(i).numberPlateOfVehicle.equals(numberPlateOfVehicle)) {
                System.out.println("Vehicle Unparked..." + detailsArrayList.get(i).numberPlateOfVehicle);
                detailsArrayList.remove(i);
                detailsArrayList.add(i, null);
                return true;
            }
        }
        return false;
    }
}
