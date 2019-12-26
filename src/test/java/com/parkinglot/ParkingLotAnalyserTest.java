package com.parkinglot;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ParkingLotAnalyserTest {

    Map<ParkingType, ArrayList<VehicleDetails>> slotOccupied;

    @Before
    public void setUp() {
        this.slotOccupied = new HashMap<>();
    }

    @Test
    public void givenParkingPlot_IfDriverWillParkVehicle_ShouldReturnCorrectSlot() {
        ParkingLotAnalyser parkingLotAnalyser = new ParkingLotAnalyser();
        try {
            slotOccupied = parkingLotAnalyser.
                    allocateEmptySlotToParkVehicles(ParkingType.SMALL, new VehicleDetails
                            ("MH01 AY 3036", "blue", new Date()));
            assertEquals(1, slotOccupied.get(ParkingType.SMALL).size());
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenParkingPlot_IfMultipleDriverWillParkVehicles_ShouldReturnCorrectSlotsOccupied() {
        ParkingLotAnalyser parkingLotAnalyser = new ParkingLotAnalyser();
        try {
            slotOccupied = parkingLotAnalyser.
                    allocateEmptySlotToParkVehicles(ParkingType.HANDICAPPED, new VehicleDetails
                            ("MH01 AY 3036", "blue", new Date()), new VehicleDetails
                            ("MH01 AY 3037", "blue", new Date()));
            assertEquals(2, slotOccupied.get(ParkingType.HANDICAPPED).size());
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenParkingPlot_IfLargeTypeOfParkingInWhichDriverWillParkVehicles_ShouldReturnOccupiedSlots() {
        ParkingLotAnalyser parkingLotAnalyser = new ParkingLotAnalyser();
        try {
            slotOccupied = parkingLotAnalyser.
                    allocateEmptySlotToParkVehicles(ParkingType.LARGE, new VehicleDetails
                            ("MH01 AY 3036", "blue", new Date()), new VehicleDetails
                            ("MH01 AY 3037", "blue", new Date()));
            assertEquals(2, slotOccupied.get(ParkingType.LARGE).size());
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenParkingPlot_IfMultipleTypeOfParkingInWhichDriverWillParkVehicles_ShouldReturnCorrectSlotsOccupied() {
        ParkingLotAnalyser parkingLotAnalyser = new ParkingLotAnalyser();
        try {
            slotOccupied = parkingLotAnalyser.
                    allocateEmptySlotToParkVehicles(ParkingType.LARGE, new VehicleDetails
                            ("MH01 AY 3036", "blue", new Date()), new VehicleDetails
                            ("MH01 AY 3037", "blue", new Date()), new VehicleDetails
                            ("MH01 AY 3036", "blue", new Date()), new VehicleDetails
                            ("MH01 AY 3037", "blue", new Date()));
            assertEquals(4, slotOccupied.get(ParkingType.LARGE).size());
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenParkingLot_IfDriverWantsToUnparkVehicle_ShouldReturnTrue() {
        ParkingLotAnalyser analyser = new ParkingLotAnalyser();
        try {
            slotOccupied = analyser.
                    allocateEmptySlotToParkVehicles(ParkingType.LARGE, new VehicleDetails
                            ("MH01 AY 3036", "blue", new Date()), new VehicleDetails
                            ("MH01 AY 3039", "blue", new Date()), new VehicleDetails
                            ("MH01 AY 3034", "blue", new Date()), new VehicleDetails
                            ("MH01 AY 3037", "blue", new Date()));
            boolean vehicleInParkingLot = analyser.findVehicleInParkingLotToUnparkVehicle("MH01 AY 3037");
            assertTrue(vehicleInParkingLot);
        } catch (ParkingLotException e) {
        }
    }

    @Test
    public void givenParkingLot_IfParkingLotGetsFulledNoSpaceToParkVehicles_ShouldReturnTrue() {
        ParkingLotAnalyser analyser = new ParkingLotAnalyser();
        try {
            slotOccupied = analyser.
                    allocateEmptySlotToParkVehicles(ParkingType.LARGE, new VehicleDetails
                            ("MH01 AY 3036", "blue", new Date()), new VehicleDetails
                            ("MH01 AY 3039", "blue", new Date()), new VehicleDetails
                            ("MH01 AY 3034", "blue", new Date()), new VehicleDetails
                            ("MH01 AY 3037", "blue", new Date()), new VehicleDetails
                            ("MH12 AY 8836", "blue", new Date()), new VehicleDetails
                            ("MH11 AY 5039", "blue", new Date()), new VehicleDetails
                            ("MH02 AY 2034", "blue", new Date()), new VehicleDetails
                            ("MH06 AY 1037", "blue", new Date()));
        } catch (ParkingLotException e) {
            Assert.assertEquals(ParkingLotException.ExceptionType.PARKING_LOT_FULLED, e.type);
        }
    }

    @Test
    public void givenParkingLot_IfParkingLotGetsFulledNoSpaceToParkVehiclesButOneVehicleUnparked_ShouldReturnTrue() {
        ParkingLotAnalyser analyser = new ParkingLotAnalyser();
        try {
            slotOccupied = analyser.
                    allocateEmptySlotToParkVehicles(ParkingType.LARGE, new VehicleDetails
                            ("MH01 AY 3036", "blue", new Date()), new VehicleDetails
                            ("MH01 AY 3039", "blue", new Date()), new VehicleDetails
                            ("MH01 AY 3034", "blue", new Date()), new VehicleDetails
                            ("MH01 AY 3037", "blue", new Date()), new VehicleDetails
                            ("MH12 AY 8836", "blue", new Date()));
            boolean vehicleInParkingLot = analyser.findVehicleInParkingLotToUnparkVehicle("MH01 AY 3037");
            slotOccupied = analyser.
                    allocateEmptySlotToParkVehicles(ParkingType.LARGE, new VehicleDetails
                            ("MH01 AY 4444", "blue", new Date()));
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
        assertEquals(5, slotOccupied.get(ParkingType.LARGE).size());
    }
}
