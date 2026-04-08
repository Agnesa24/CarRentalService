package org.example.carrentalservice.vehicle.api.mapper;

import org.example.carrentalservice.vehicle.api.dto.CreateVehicleRequest;
import org.example.carrentalservice.vehicle.api.dto.VehicleResponse;
import org.example.carrentalservice.vehicle.domain.model.Vehicle;
import org.example.carrentalservice.vehicle.infrastructure.persistence.entity.VehicleJpaEntity;

public class VehicleMapper {
    private VehicleMapper() {}
    public static Vehicle toDomain(CreateVehicleRequest request) {
        return Vehicle.builder()
                .brand(request.getBrand())
                .model(request.getModel())
                .modelYear(request.getModelYear())
                .plateNumber(request.getPlateNumber())
                .available(request.getAvailable())
                .conditionStatus(request.getConditionStatus())
                .dailyRate(request.getDailyRate())
                .build();
    }
    public static Vehicle toDomain(VehicleJpaEntity entity) {
        return Vehicle.builder()
                .vehicleId(entity.getVehicleId())
                .brand(entity.getBrand())
                .model(entity.getModel())
                .modelYear(entity.getModelYear())
                .plateNumber(entity.getPlateNumber())
                .available(entity.getAvailable())
                .conditionStatus(entity.getConditionStatus())
                .dailyRate(entity.getDailyRate())
                .build();
    }
    public static VehicleJpaEntity toJpa(Vehicle vehicle) {
        return VehicleJpaEntity.builder()
                .vehicleId(vehicle.getVehicleId())
                .brand(vehicle.getBrand())
                .model(vehicle.getModel())
                .modelYear(vehicle.getModelYear())
                .plateNumber(vehicle.getPlateNumber())
                .available(vehicle.getAvailable())
                .conditionStatus(vehicle.getConditionStatus())
                .dailyRate(vehicle.getDailyRate())
                .build();
    }
    public static VehicleResponse toResponse(Vehicle vehicle) {
        return VehicleResponse.builder()
                .vehicleId(vehicle.getVehicleId())
                .brand(vehicle.getBrand())
                .model(vehicle.getModel())
                .modelYear(vehicle.getModelYear())
                .plateNumber(vehicle.getPlateNumber())
                .available(vehicle.getAvailable())
                .conditionStatus(vehicle.getConditionStatus())
                .dailyRate(vehicle.getDailyRate())
                .build();
    }
}
