package com.purnima.jain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.purnima.jain.domain.Customer;
import com.purnima.jain.repo.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerService {
	
	private final CustomerRepository customerRepository;
	
	public CustomerService(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}
	
	public Customer getCustomerById(String customerId) {
		log.info("Inside the CustomerService::getCustomerById() for customerId :: {}", customerId);
		Customer customer = customerRepository.findById(customerId).orElse(null);
		return customer;
	}
	
	public Customer saveCustomer(Customer customer) {
		log.info("Inside the CustomerService::saveCustomer() for customer :: {}", customer.toString());
		Customer savedCustomer = customerRepository.save(customer);
		return savedCustomer;
	}
	
	public List<Customer> getAllCustomers() {
		log.info("Inside the CustomerService::getAllCustomers()................");
		List<Customer> customerList = (List<Customer>) customerRepository.findAll();
		return customerList;
	}
	
	public Customer updateCustomer(Customer customer) {
		log.info("Inside the CustomerService::updateCustomer() for customer :: {}", customer.toString());
		Customer updatedCustomer = customerRepository.save(customer);
		return updatedCustomer;
	}
	
	public void deleteCustomerById(String customerId) {
		log.info("Inside the CustomerService::deleteCustomer() for customerId :: {}", customerId);
		customerRepository.deleteById(customerId);
	}

}
