//package org.example.carrentalservice;
//
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//
//@SpringBootApplication(scanBasePackages = {
//        "org.example.carrentalservice",
//        "customer",
//        "vehicle",
//        "rental",
//        "billing",
//        "shared"
//})
//@EnableJpaRepositories(basePackages = {
//        "customer.persistence.repository",
//        "vehicle.persistence.repository"
//})
//@EntityScan(basePackages = {
//        "customer.persistence.entity",
//        "vehicle.persistence.entity"
//})
//public class CarRentalServiceApplication {
//
//    public static void main(String[] args) {
//        SpringApplication.run(CarRentalServiceApplication.class, args);
//    }
//}
//



package org.example.carrentalservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarRentalServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarRentalServiceApplication.class, args);
    }
}