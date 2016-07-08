package br.com.letsgoti.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.letsgoti.model.Customer;

@Service
public interface CustomerService {
	
	Customer findById(int id);		
	
	int saveUser(Customer user);
	
	void updateUser(Customer user);		

	List<Customer> findAllCustomers();	

}