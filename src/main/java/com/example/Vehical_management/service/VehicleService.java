package com.example.Vehical_management.service;

import com.example.Vehical_management.model.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleService {
Vehicle saveVehicle(Vehicle vehicle);

    List<Vehicle> getAllVehicles();

    Vehicle getVehicleById(Long serviceId);

    Vehicle updateVehicle(Vehicle vehicle, Long serviceId);

    void deleteVehicle(Long serviceId);

    // Custom method: get vehicles by serviceYear
    List<Vehicle> getVehiclesByServiceYear(int serviceYear);

    // Custom method: get vehicleType by serviceId
    Optional<String> getVehicleTypeByServiceId(Long serviceId);

    // Custom method: delete vehicles by serviceYear
    void deleteVehiclesByServiceYear(int serviceYear);
}
