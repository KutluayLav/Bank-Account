package com.kutluayulutas.account;

import com.kutluayulutas.account.modal.Customer;
import com.kutluayulutas.account.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;

@SpringBootApplication
public class AccountApplication implements CommandLineRunner {

	private final CustomerRepository customerRepository;

	public AccountApplication(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Customer customer=customerRepository.save(new Customer("","Kutluay","lav",new HashSet<>()));
		Customer customer2=customerRepository.save(new Customer("","Ahmet","lav",new HashSet<>()));
		Customer customer3=customerRepository.save(new Customer("","Mustafa","lav",new HashSet<>()));
		Customer customer4=customerRepository.save(new Customer("","Hamza","lav",new HashSet<>()));
		Customer customer7=customerRepository.save(new Customer("","kemal","lav",new HashSet<>()));
		Customer customer8=customerRepository.save(new Customer("","buse","lav",new HashSet<>()));
		Customer customer9=customerRepository.save(new Customer("","cansu","lav",new HashSet<>()));
		Customer customer10=customerRepository.save(new Customer("","özgür","lav",new HashSet<>()));
		Customer customer11=customerRepository.save(new Customer("","ali","lav",new HashSet<>()));
		Customer customer12=customerRepository.save(new Customer("","irem","lav",new HashSet<>()));

		System.out.println(customer);
	}
}
