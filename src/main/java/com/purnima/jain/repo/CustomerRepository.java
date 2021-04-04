package com.purnima.jain.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.purnima.jain.domain.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, String> {
	
	List<Customer> findByFirstNameAndLastName(String firstName, String lastName);

}
