package com.example.Simulated.Annealing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimulatedAnnealingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimulatedAnnealingApplication.class, args);
		Service service = new Service();
		service.run();
	}

}
