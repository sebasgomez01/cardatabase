package com.csgp.cardatabase;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.csgp.cardatabase.domain.Car;
import com.csgp.cardatabase.domain.CarRepository;
import com.csgp.cardatabase.domain.OwnerRepository;
import com.csgp.cardatabase.domain.Owner;

@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);

	private final CarRepository repository;

	private final OwnerRepository orepository;

	public CardatabaseApplication(CarRepository repository, OwnerRepository oRepository) {
		this.repository = repository;
		this.orepository = oRepository;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		Owner owner1 = new Owner("Sebastián", "Gómez");
		Owner owner2 = new Owner("Elmo", "Lesto"); 
		orepository.saveAll(Arrays.asList(owner1, owner2));

		repository.save(new Car("Ford", "Mustang", "Red", 
		"ADF-1121", 2023, 59000, owner1));

		repository.save(new Car("Nissan", "Leaf", "White", 
		"SSJ-3002", 2020, 29000, owner2));

		repository.save(new Car("Toyota", "Prius", "Silver", 
		"KKO-0212", 2022, 39000, owner1));
		
		for(Car car : repository.findAll()) {
			logger.info("brand: {}, model: {}", car.getBrand(), car.getModel());
		}

		// logger.info("hola sebas q haces");
	

	}

}
