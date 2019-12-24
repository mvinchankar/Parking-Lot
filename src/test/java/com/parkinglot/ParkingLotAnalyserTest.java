package com.parkinglot;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;

public class ParkingLotAnalyserTest {
    @Test
    public void givenParkingPlot_IfDriverWillParkVehicle_ShouldReturnCorrectSlot() {
        ParkingLotAnalyser parkingLotAnalyser = new ParkingLotAnalyser();
        Map<String, ArrayList<VehicleDetails>> plotToParkVehicles = parkingLotAnalyser.
                allocateEmptySlotToParkVehicles(new VehicleDetails
                        ("MH01 AY 3036", "blue", "12.25"));
        Assert.assertEquals(1, plotToParkVehicles.size());
    }

    @Test
    public void givenParkingPlot_IfSecondDriverWillParkVehicle_ShouldReturnCorrectSlot() {
        ParkingLotAnalyser parkingLotAnalyser = new ParkingLotAnalyser();
        Map<String,ArrayList<VehicleDetails>> plotToParkVehicles = parkingLotAnalyser.
                allocateEmptySlotToParkVehicles(new VehicleDetails
                        ("MH01 AY 3037","blue","11.25"));
        Assert.assertEquals( 2,plotToParkVehicles.size());
    }
}
