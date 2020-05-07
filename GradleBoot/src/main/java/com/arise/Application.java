package com.arise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.arise.dao.CustomerRepository;
import com.arise.model.Customer;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	private static final Logger LOG = LoggerFactory.getLogger(Application.class);
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
	
	/**
	 * This shite is to test the JPA thingie.
	 * @param repository
	 * @return
	 */
	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Customer("Jack", "Bauer"));
			repository.save(new Customer("Chloe", "O'Brian"));
			repository.save(new Customer("Kim", "Bauer"));
			repository.save(new Customer("David", "Palmer"));
			repository.save(new Customer("Michelle", "Dessler"));

			// fetch all customers
			LOG.info("Customers found with findAll():");
			LOG.info("-------------------------------");
			for (Customer customer : repository.findAll()) {
				LOG.info(customer.toString());
			}
			LOG.info("");

			// fetch an individual customer by ID
			Customer customer = repository.findOne(1L);
			LOG.info("Customer found with findOne(1L):");
			LOG.info("--------------------------------");
			LOG.info(customer.toString());
			LOG.info("");

			// fetch customers by last name
			LOG.info("Customer found with findByLastName('Bauer'):");
			LOG.info("--------------------------------------------");
			for (Customer bauer : repository.findByLastName("Bauer")) {
				LOG.info(bauer.toString());
			}
			LOG.info("");
			
			// fetch customers by first name
			LOG.info("Customer found with findByFirstName('David'):");
			LOG.info("--------------------------------------------");
			for (Customer bauer : repository.findByFirstName("David")) {
				LOG.info(bauer.toString());
			}
			LOG.info("");
		};
	}

}