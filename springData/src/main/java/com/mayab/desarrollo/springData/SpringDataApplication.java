package com.mayab.desarrollo.springData;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class SpringDataApplication {
	
	private static final Logger log = LoggerFactory.getLogger(SpringDataApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return(args) -> {
			//save few customers
			repository.save(new Customer("Lebron", "Halner"));
			repository.save(new Customer("John", "Cena"));
			repository.save(new Customer("Jaimie", "Waller"));
			repository.save(new Customer("Dwayne", "Johnson"));
			repository.save(new Customer("Lebron", "James"));
			repository.save(new Customer("Lebron", "Waller"));
			
			//fetch all customers
			log.info("Customers found with findAll()");
			log.info("------------------------------");
			for(Customer customer: repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");
			
			//fetch all customers
			Optional<Customer>customer = repository.findById(1L);
			log.info("Customers found with findById(1L)");
			log.info("------------------------------");
			log.info(customer.toString());
			log.info("");
			
			//fetch customers by last name
			log.info("Customers found with findByLastName('Waller')");
			log.info("------------------------------");
			repository.findByLastName("Waller").forEach(waller -> {
				log.info(waller.toString());
			});
			log.info("");
			
			//fetch customers by first name
			log.info("Customers found with findByFirstName('Lebron')");
			log.info("------------------------------");
			repository.findByFirstName("Lebron").forEach(lebron -> {
				log.info(lebron.toString());
			});
			log.info("");
			
			
		};
	}

}
