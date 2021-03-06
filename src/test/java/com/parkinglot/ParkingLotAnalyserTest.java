package com.parkinglot;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class ParkingLotAnalyserTest {

    Map<ParkingType, ArrayList<VehicleDetails>> slotOccupied;

    @Before
    public void setUp() {
        this.slotOccupied = new HashMap<>();
    }

    @Test
    public void givenParkingPlot_IfDriverWillParkVehicle_ShouldReturnTrue() {
        ParkingLotAnalyser parkingLotAnalyser = new ParkingLotAnalyser();
        VehicleDetails vehicleDetails;
        try {
            parkingLotAnalyser.initialParkingSlots();
            boolean slotOccupied = parkingLotAnalyser.
                    allocateEmptySlotToParkVehicles(ParkingType.NORMAL, new VehicleDetails
                            ("MH01 AY 3036", "blue", new Date()));
            assertTrue(slotOccupied);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenParkingPlot_IfMultipleDriverWillParkVehicles_ShouldReturnTrue() {
        ParkingLotAnalyser parkingLotAnalyser = new ParkingLotAnalyser();
        try {
            parkingLotAnalyser.initialParkingSlots();
            boolean slotOccupied = parkingLotAnalyser.
                    allocateEmptySlotToParkVehicles(ParkingType.NORMAL, new VehicleDetails
                            ("MH01 AY 3036", "blue", new Date()));
            boolean slotOccupied1 = parkingLotAnalyser.
                    allocateEmptySlotToParkVehicles(ParkingType.NORMAL, new VehicleDetails
                            ("MH01 AY 3037", "blue", new Date()));
            assertTrue(slotOccupied);
            assertTrue(slotOccupied1);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenParkingPlot_IfMultipleTypeOfParkingInWhichDriverWillParkVehicles_ShouldReturnTrue() {
        ParkingLotAnalyser parkingLotAnalyser = new ParkingLotAnalyser();
        try {
            parkingLotAnalyser.initialParkingSlots();
            boolean slotOccupied = parkingLotAnalyser.
                    allocateEmptySlotToParkVehicles(ParkingType.NORMAL, new VehicleDetails
                            ("MH01 AY 3036", "blue", new Date()));
            boolean slotOccupied1 = parkingLotAnalyser.
                    allocateEmptySlotToParkVehicles(ParkingType.NORMAL, new VehicleDetails
                            ("MH01 AY 3037", "blue", new Date()));
            boolean slotOccupied2 = parkingLotAnalyser.
                    allocateEmptySlotToParkVehicles(ParkingType.NORMAL, new VehicleDetails
                            ("MH01 AY 3036", "blue", new Date()));
            boolean slotOccupied3 = parkingLotAnalyser.
                    allocateEmptySlotToParkVehicles(ParkingType.NORMAL, new VehicleDetails
                            ("MH01 AY 3037", "blue", new Date()));
            assertTrue(slotOccupied);
            assertTrue(slotOccupied1);
            assertTrue(slotOccupied2);
            assertTrue(slotOccupied3);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenParkingLot_IfDriverWantsToUnparkVehicle_ShouldReturnTrue() {
        ParkingLotAnalyser analyser = new ParkingLotAnalyser();
        try {
            analyser.initialParkingSlots();
            boolean slotOccupied = analyser.
                    allocateEmptySlotToParkVehicles(ParkingType.NORMAL, new VehicleDetails
                            ("MH01 AY 3036", "blue", new Date()));
            boolean slotOccupied1 = analyser.
                    allocateEmptySlotToParkVehicles(ParkingType.NORMAL, new VehicleDetails
                            ("MH01 AY 3039", "blue", new Date()));
            boolean slotOccupied2 = analyser.
                    allocateEmptySlotToParkVehicles(ParkingType.NORMAL, new VehicleDetails
                            ("MH01 AY 3034", "blue", new Date()));
            boolean slotOccupied3 = analyser.
                    allocateEmptySlotToParkVehicles(ParkingType.NORMAL, new VehicleDetails
                            ("MH01 AY 3037", "blue", new Date()));
            boolean vehicleInParkingLot = analyser.findVehicleInParkingLotToUnparkVehicle
                    ("MH01 AY 3037");
            assertTrue(vehicleInParkingLot);
        } catch (ParkingLotException e) {
        }
    }

    @Test
    public void givenParkingLot_IfDriverWantsToUnparkVehicleButVehicleNotPresentInParkingLot_ShouldThrowException() {
        ParkingLotAnalyser analyser = new ParkingLotAnalyser();
        try {
            analyser.initialParkingSlots();
            boolean slotOccupied = analyser.
                    allocateEmptySlotToParkVehicles(ParkingType.NORMAL, new VehicleDetails
                            ("MH01 AY 3036", "blue", new Date()));
            boolean slotOccupied1 = analyser.
                    allocateEmptySlotToParkVehicles(ParkingType.NORMAL, new VehicleDetails
                            ("MH01 AY 3039", "blue", new Date()));
            boolean slotOccupied2 = analyser.
                    allocateEmptySlotToParkVehicles(ParkingType.NORMAL, new VehicleDetails
                            ("MH01 AY 3034", "blue", new Date()));
            boolean slotOccupied3 = analyser.
                    allocateEmptySlotToParkVehicles(ParkingType.NORMAL, new VehicleDetails
                            ("MH01 AY 3037", "blue", new Date()));
            boolean vehicleInParkingLot = analyser.findVehicleInParkingLotToUnparkVehicle
                    ("MH01 AY 4444");
        } catch (ParkingLotException e) {
            Assert.assertEquals(ParkingLotException.ExceptionType.VEHICLE_NOT_PRESENT, e.type);
        }
    }

    @Test
    public void givenParkingLot_IfParkingLotGetsFulledNoSpaceToParkVehicles_ShouldThrowException() {
        ParkingLotAnalyser analyser = new ParkingLotAnalyser();
        try {
            analyser.initialParkingSlots();
            boolean slotOccupied = analyser.
                    allocateEmptySlotToParkVehicles(ParkingType.NORMAL, new VehicleDetails
                            ("MH01 AY 3036", "blue", new Date()));
            boolean slotOccupied1 = analyser.
                    allocateEmptySlotToParkVehicles(ParkingType.NORMAL, new VehicleDetails
                            ("MH01 AY 3039", "blue", new Date()));
            boolean slotOccupied2 = analyser.
                    allocateEmptySlotToParkVehicles(ParkingType.NORMAL, new VehicleDetails
                            ("MH01 AY 3034", "blue", new Date()));
            boolean slotOccupied3 = analyser.
                    allocateEmptySlotToParkVehicles(ParkingType.NORMAL, new VehicleDetails
                            ("MH01 AY 3037", "blue", new Date()));
            boolean slotOccupied4 = analyser.
                    allocateEmptySlotToParkVehicles(ParkingType.NORMAL, new VehicleDetails
                            ("MH12 AY 8836", "blue", new Date()));
            boolean slotOccupied5 = analyser.
                    allocateEmptySlotToParkVehicles(ParkingType.NORMAL, new VehicleDetails
                            ("MH11 AY 5039", "blue", new Date()));
            boolean slotOccupied6 = analyser.
                    allocateEmptySlotToParkVehicles(ParkingType.NORMAL, new VehicleDetails
                            ("MH02 AY 2034", "blue", new Date()));
            boolean slotOccupied7 = analyser.
                    allocateEmptySlotToParkVehicles(ParkingType.NORMAL, new VehicleDetails
                            ("MH06 AY 1037", "blue", new Date()));
            boolean slotOccupied8 = analyser.
                    allocateEmptySlotToParkVehicles(ParkingType.NORMAL, new VehicleDetails
                            ("MH45 AY 1037", "blue", new Date()));
        } catch (ParkingLotException e) {
            Assert.assertEquals(ParkingLotException.ExceptionType.PARKING_LOT_FULLED, e.type);
        }
    }

    @Test
    public void givenParkingLot_IfParkingLotGetsFulledNoSpaceToParkVehiclesButOneVehicleRemovedThenRemoveFullSigned_ShouldReturnTrue() {
        ParkingLotAnalyser analyser = new ParkingLotAnalyser();
        try {
            analyser.initialParkingSlots();
            boolean slotOccupied = analyser.
                    allocateEmptySlotToParkVehicles(ParkingType.NORMAL, new VehicleDetails
                            ("MH01 AY 3036", "blue", new Date()));
            boolean slotOccupied1 = analyser.
                    allocateEmptySlotToParkVehicles(ParkingType.NORMAL, new VehicleDetails
                            ("MH01 AY 3039", "blue", new Date()));
            boolean slotOccupied2 = analyser.
                    allocateEmptySlotToParkVehicles(ParkingType.NORMAL, new VehicleDetails
                            ("MH01 AY 3034", "blue", new Date()));
            boolean slotOccupied3 = analyser.
                    allocateEmptySlotToParkVehicles(ParkingType.NORMAL, new VehicleDetails
                            ("MH01 AY 3037", "blue", new Date()));
            boolean slotOccupied4 = analyser.
                    allocateEmptySlotToParkVehicles(ParkingType.NORMAL, new VehicleDetails
                            ("MH12 AY 8836", "blue", new Date()));
            boolean slotOccupied5 = analyser.
                    allocateEmptySlotToParkVehicles(ParkingType.NORMAL, new VehicleDetails
                            ("MH11 AY 5039", "blue", new Date()));
        } catch (ParkingLotException e) {
            Assert.assertEquals(ParkingLotException.ExceptionType.PARKING_LOT_FULLED, e.type);
        }
        try {
            boolean unPark = analyser.findVehicleInParkingLotToUnparkVehicle("MH01 AY 3036");
            Assert.assertTrue(unPark);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }
}
