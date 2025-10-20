package com.example.Vehical_management.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "vehicles")
public class Vehicle {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private long serviceId;

 @Column(name = "vehicle_type",nullable = false)
 private String vehicleType;

 @Column(name = "service_year",nullable = false)
  private int serviceYear;
}
