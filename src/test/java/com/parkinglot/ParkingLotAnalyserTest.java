package com.parkinglot;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class ParkingLotAnalyserTest {
    Map<String, ArrayList<VehicleDetails>> plotToParkVehicles;

    @Test
    public void givenParkingPlot_IfDriverWillParkVehicle_ShouldReturnCorrectSlot() {
        ParkingLotAnalyser parkingLotAnalyser = new ParkingLotAnalyser();
        Map<String, ArrayList<VehicleDetails>> slotOccupied = parkingLotAnalyser.
                allocateEmptySlotToParkVehicles(new VehicleDetails
                        ("MH01 AY 3036", "blue", new Date()));
        Assert.assertEquals(1, slotOccupied.get("Normal").size());
    }

    @Test
    public void givenParkingPlot_IfMultipleDriverWillParkVehicles_ShouldReturnCorrectSlots() {
        ParkingLotAnalyser parkingLotAnalyser = new ParkingLotAnalyser();
        Map<String, ArrayList<VehicleDetails>> slotOccupied = parkingLotAnalyser.
                allocateEmptySlotToParkVehicles(new VehicleDetails
                        ("MH01 AY 3036", "blue", new Date()), new VehicleDetails
                        ("MH01 AY 3037", "blue", new Date()));
        Assert.assertEquals(2, slotOccupied.get("Normal").size());
    }
}
