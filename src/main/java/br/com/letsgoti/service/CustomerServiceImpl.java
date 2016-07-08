package br.com.letsgoti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.letsgoti.dao.CustomerDao;
import br.com.letsgoti.model.Customer;


@Transactional
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao dao;

	public Customer findById(int id) {
		return dao.findById(id);
	}
	

	public int saveUser(Customer customer) {
		return dao.save(customer);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public void updateUser(Customer customer) {
		Customer entity = dao.findById(customer.getId());
		if(entity!=null){
			entity.setFirstName(customer.getFirstName());
			entity.setLastName(customer.getLastName());
			entity.setEmail(customer.getEmail());
			entity.setSex(customer.getSex());
			entity.setDateBorn(customer.getDateBorn());
			entity.setCustomerAddresses(customer.getCustomerAddresses());
		}
	}


	public List<Customer> findAllCustomers() {
		return dao.findAllCustomer();
	}

	
}
