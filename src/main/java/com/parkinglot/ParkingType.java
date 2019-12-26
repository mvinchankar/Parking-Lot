package com.parkinglot;

public enum ParkingType {
    VEHICLE(100);

    private final int capacity;

    ParkingType(int capacity) {
        this.capacity = capacity;
    }
}
