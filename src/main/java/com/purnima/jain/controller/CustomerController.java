package com.purnima.jain.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.purnima.jain.domain.Customer;
import com.purnima.jain.json.CustomerPostRequestDto;
import com.purnima.jain.json.CustomerPutRequestDto;
import com.purnima.jain.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/redis-as-database/customers")
@Slf4j
public class CustomerController {

	private final CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	@GetMapping("/{customerId}")
	public Customer getCustomerById(@PathVariable("customerId") String customerId) {
		log.info("Inside the CustomerController REST Controller for GET::getCustomerById() for customerId :: {}", customerId);
		return customerService.getCustomerById(customerId);

	}

	@PostMapping
	public Customer saveCustomer(@RequestBody CustomerPostRequestDto customerPostRequestDto) {
		log.info("Inside the CustomerController REST Controller for POST::saveCustomer() for customerPostRequestDto :: {}", customerPostRequestDto.toString());
		Customer customer = new Customer(UUID.randomUUID().toString(), customerPostRequestDto.getFirstName(), customerPostRequestDto.getLastName());
		customer = customerService.saveCustomer(customer);

		return customer;
	}

	@GetMapping
	public List<Customer> getAllCustomers() {
		log.info("Inside the CustomerController REST Controller for GET::getAllCustomers()..................");
		return customerService.getAllCustomers();
	}

	@PutMapping("/update")
	public Customer updateCustomer(@RequestBody CustomerPutRequestDto customerPutRequestDto) {
		log.info("Inside the CustomerController REST Controller for PUT::updateCustomer() for customerPutRequestDto :: {}", customerPutRequestDto.toString());
		Customer customer = new Customer(customerPutRequestDto.getCustomerId(), customerPutRequestDto.getFirstName(), customerPutRequestDto.getLastName());
		return customerService.updateCustomer(customer);
	}

	@DeleteMapping("/{customerId}/delete")
	public void deleteCustomerById(@PathVariable("customerId") String customerId) {
		log.info("Inside the CustomerController REST Controller for DELETE::deleteCustomerById() for customerId :: {}", customerId);
		customerService.deleteCustomerById(customerId);
	}

}