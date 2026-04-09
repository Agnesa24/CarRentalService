package org.example.carrentalservice.vehicle.api.mapper;


import org.example.carrentalservice.vehicle.api.dto.CreateVehicleRequest;
import org.example.carrentalservice.vehicle.api.dto.VehicleResponse;
import org.example.carrentalservice.vehicle.domain.model.Vehicle;
import org.example.carrentalservice.vehicle.persistence.entity.VehicleJpaEntity;

public class VehicleMapper {

    private VehicleMapper() {
    }

    public static Vehicle fromRequest(CreateVehicleRequest request) {
        return Vehicle.builder()
                .brand(request.getBrand())
                .model(request.getModel())
                .vehicleYear(request.getVehicleYear())
                .plateNumber(request.getPlateNumber())
                .status(request.getStatus())
                .dailyRate(request.getDailyRate())
                .build();
    }

    public static Vehicle fromJpa(VehicleJpaEntity entity) {
        return Vehicle.builder()
                .vehicleId(entity.getVehicleId())
                .brand(entity.getBrand())
                .model(entity.getModel())
                .vehicleYear(entity.getVehicleYear())
                .plateNumber(entity.getPlateNumber())
                .status(entity.getStatus())
                .dailyRate(entity.getDailyRate())
                .build();
    }

    public static VehicleJpaEntity toJpa(Vehicle vehicle) {
        return VehicleJpaEntity.builder()
                .vehicleId(vehicle.getVehicleId())
                .brand(vehicle.getBrand())
                .model(vehicle.getModel())
                .vehicleYear(vehicle.getVehicleYear())
                .plateNumber(vehicle.getPlateNumber())
                .status(vehicle.getStatus())
                .dailyRate(vehicle.getDailyRate())
                .build();
    }

    public static VehicleResponse toResponse(Vehicle vehicle) {
        return VehicleResponse.builder()
                .vehicleId(vehicle.getVehicleId())
                .brand(vehicle.getBrand())
                .model(vehicle.getModel())
                .vehicleYear(vehicle.getVehicleYear())
                .plateNumber(vehicle.getPlateNumber())
                .status(vehicle.getStatus())
                .dailyRate(vehicle.getDailyRate())
                .build();
    }
}