package org.kholoud.customerservice;

import org.kholoud.customerservice.entities.Customer;
import org.kholoud.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository)
    {
        return args -> {
            customerRepository.save(Customer.builder()
                    .name("Kholoud").email("kholoud@gmail.com")
                    .build());
            customerRepository.save(Customer.builder()
                    .name("Aouatif").email("Aouatif@gmail.com")
                    .build());
            customerRepository.save(Customer.builder()
                    .name("Aya").email("Aya@gmail.com")
                    .build());
            customerRepository.save(Customer.builder()
                    .name("Reda").email("Reda@gmail.com")
                    .build());
            customerRepository.findAll().forEach(c -> {
                System.out.println("============== Customers ==============");
                System.out.println("ID: " + c.getId());
                System.out.println("Name: " + c.getName());
                System.out.println("Email: " + c.getEmail());
                System.out.println("========================================");
            });
        };
    }
}