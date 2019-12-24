package com.parkinglot;

import org.junit.Assert;
import org.junit.Test;

public class ParkingLotAnalyserTest {

    @Test
    public void givenParkingPlot_OwnerWillCheckForEmptySlotToParkVehicle() {
        ParkingLotAnalyser parkingLotAnalyser = new ParkingLotAnalyser();
        boolean plotToParkVehicles = parkingLotAnalyser.
                allocateEmptySlotToParkVehicles("MH30 AY 3036");
        Assert.assertTrue(plotToParkVehicles);
    }
}
