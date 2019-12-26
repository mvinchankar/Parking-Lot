package com.parkinglot;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;

public class VehicleDetails {

    public String numberPlateOfVehicle;
    public String colorOfVehicle;
    public Date time;

    public VehicleDetails(String numberPlateOfVehiclePlate, String color, Date time) {
        this.numberPlateOfVehicle = numberPlateOfVehiclePlate;
        this.colorOfVehicle = color;
        this.time = time;
    }
}
