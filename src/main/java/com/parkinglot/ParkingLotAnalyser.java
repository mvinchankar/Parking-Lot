package com.parkinglot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ParkingLotAnalyser {
    Map<ParkingType, ArrayList<VehicleDetails>> plotList;
    int maximumParkingSlots = 5;
    ArrayList<VehicleDetails> detailsArrayList = new ArrayList<>();

    public ParkingLotAnalyser() {
        this.plotList = new HashMap<>();
    }

    public void initialParkingSlots() {
        for (int i = 0; i < maximumParkingSlots; i++) {
            detailsArrayList.add(null);
        }
    }

    public boolean allocateEmptySlotToParkVehicles
            (ParkingType parkingType, VehicleDetails details) throws ParkingLotException {
        for (int i = 0; i < detailsArrayList.size(); i++)
            if (detailsArrayList.get(i) == null) {
                detailsArrayList.remove(i);
                detailsArrayList.add(i, details);
                plotList.put(parkingType, detailsArrayList);
                return true;
            }
        throw new ParkingLotException("FULLED!!!!!!", ParkingLotException.ExceptionType.PARKING_LOT_FULLED);
    }

    public boolean findVehicleInParkingLotToUnparkVehicle(String numberPlateOfVehicle) throws ParkingLotException {
        for (int i = 0; i < detailsArrayList.size(); i++)
            try {
                if (detailsArrayList.get(i).numberPlateOfVehicle.equals(numberPlateOfVehicle)) {
                    System.out.println("Vehicle Unparked..." + detailsArrayList.get(i).numberPlateOfVehicle);
                    detailsArrayList.remove(i);
                    detailsArrayList.add(i, null);
                    return true;
                }
            } catch (NullPointerException e) {
                throw new ParkingLotException("VEHICLES NOT PRESENT IN THIS SLOT!!!!!!", ParkingLotException.ExceptionType.VEHICLE_NOT_PRESENT);
            }
        return false;
    }
}