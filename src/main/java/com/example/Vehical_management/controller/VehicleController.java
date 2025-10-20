package com.example.Vehical_management.controller;
import com.example.Vehical_management.model.Vehicle;
import com.example.Vehical_management.repository.VehicleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    @Autowired
    private VehicleRepository vehicleRepository;
    @PostMapping
public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
    return vehicleRepository.save(vehicle);
}


    @GetMapping("/serviced/{year}")
    public List<Vehicle> getVehiclesByServiceYear(@PathVariable int year) {
        return vehicleRepository.findByServiceYear(year);
    }

    @GetMapping("/vehicleType/{serviceId}")
    public ResponseEntity<String> getVehicleTypeByServiceId(@PathVariable Long serviceId) {
        Optional<String> vehicleType = vehicleRepository.findVehicleTypeByServiceId(serviceId);
        return vehicleType.map(ResponseEntity::ok)
                          .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/deleteByYear/{year}")
    public ResponseEntity<String> deleteVehiclesByServiceYear(@PathVariable int year) {
        vehicleRepository.deleteByServiceYear(year);
        return ResponseEntity.ok("Deleted all vehicle records for service year: " + year);
    }

}
