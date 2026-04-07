package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"customer", "Shared", "vehicle", "rental", "billing"})
public class CarRentalServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CarRentalServiceApplication.class, args);
    }
}