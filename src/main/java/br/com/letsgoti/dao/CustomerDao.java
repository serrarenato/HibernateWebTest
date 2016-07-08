package br.com.letsgoti.dao;

import java.util.List;

import br.com.letsgoti.model.Customer;




public interface CustomerDao {

	Customer findById(int id);	
	
	int save(Customer customer);	
	
	List<Customer> findAllCustomer();	

}

