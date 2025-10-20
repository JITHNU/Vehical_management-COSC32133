package com.example.Vehical_management.service.impl;
import com.example.Vehical_management.model.Vehicle;
import com.example.Vehical_management.repository.VehicleRepository;
import com.example.Vehical_management.service.VehicleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class VehicleServiceimpl implements VehicleService {
     @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle getVehicleById(Long serviceId) {
        return vehicleRepository.findById(serviceId)
                .orElseThrow(() -> new RuntimeException("Vehicle not found with id: " + serviceId));
    }

    @Override
    public Vehicle updateVehicle(Vehicle vehicle, Long serviceId) {
        Vehicle existingVehicle = vehicleRepository.findById(serviceId)
                .orElseThrow(() -> new RuntimeException("Vehicle not found with id: " + serviceId));

        existingVehicle.setVehicleType(vehicle.getVehicleType());
        existingVehicle.setServiceYear(vehicle.getServiceYear());

        vehicleRepository.save(existingVehicle);
        return existingVehicle;
    }

    @Override
    public void deleteVehicle(Long serviceId) {
        vehicleRepository.findById(serviceId)
                .orElseThrow(() -> new RuntimeException("Vehicle not found with id: " + serviceId));
        vehicleRepository.deleteById(serviceId);
    }

    @Override
    public List<Vehicle> getVehiclesByServiceYear(int serviceYear) {
        return vehicleRepository.findByServiceYear(serviceYear);
    }

    @Override
    public Optional<String> getVehicleTypeByServiceId(Long serviceId) {
        return vehicleRepository.findVehicleTypeByServiceId(serviceId);
    }

    @Override
    public void deleteVehiclesByServiceYear(int serviceYear) {
        vehicleRepository.deleteByServiceYear(serviceYear);
    }

}
