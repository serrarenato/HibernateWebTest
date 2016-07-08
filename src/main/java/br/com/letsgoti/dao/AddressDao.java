package br.com.letsgoti.dao;

import java.util.List;

import br.com.letsgoti.model.Address;
import br.com.letsgoti.model.Customer;




public interface AddressDao {

	Address findById(int id);	
	
	int save(Address address);	
	
	List<Address> findAllAddress();

}

