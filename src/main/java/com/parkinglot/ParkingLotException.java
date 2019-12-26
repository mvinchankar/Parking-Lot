package com.parkinglot;

public class ParkingLotException extends Exception {
    ExceptionType type;

    public ParkingLotException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

    enum ExceptionType {
        PARKING_LOT_FULLED, VEHICLE_DETAILS_NOT_MENTIONED;;
    }
}
