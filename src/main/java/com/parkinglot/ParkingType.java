package com.parkinglot;

public enum ParkingType {
    HANDICAPPED(34),
    SMALL(34),
    LARGE(32);

    private final int capacity;

    ParkingType(int capacity) {
        this.capacity = capacity;
    }
}
