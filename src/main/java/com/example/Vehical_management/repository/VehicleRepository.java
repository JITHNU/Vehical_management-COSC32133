package com.example.Vehical_management.repository;
import com.example.Vehical_management.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>{
List<Vehicle> findByServiceYear(int serviceYear);

    // 2. Find vehicleType by serviceId
    @Query("SELECT v.vehicleType FROM Vehicle v WHERE v.serviceId = :serviceId")
    Optional<String> findVehicleTypeByServiceId(Long serviceId);

    // 3. Delete vehicles by serviceYear
    @Transactional
    @Modifying
    @Query("DELETE FROM Vehicle v WHERE v.serviceYear = :serviceYear")
    void deleteByServiceYear(int serviceYear);
}
