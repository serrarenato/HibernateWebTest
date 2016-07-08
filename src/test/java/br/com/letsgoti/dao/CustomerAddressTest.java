package br.com.letsgoti.dao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.testng.Assert;
import org.testng.annotations.Test;

import br.com.letsgoti.model.Address;
import br.com.letsgoti.model.Customer;
import br.com.letsgoti.model.CustomerAddress;

public class CustomerAddressTest extends EntityDaoImplTest {
 
	@Autowired
	private CustomerDao dao;	
	
	
	 
	    @Test
	    public void findById(){
	    	Customer customer = dao.findById(1);
	        Assert.assertNotNull(customer);
	        Assert.assertEquals(customer.getCustomerAddresses().size(), 2);	        
	    }
	     
	    @Test
	    public void saveCustomer(){
	    	Customer customer;
	    	Customer customerSaved;
	    	Address address = getSampleAddress();
	    	customer = getSampleCustomer(getSampleAddress());
	    	System.out.println(dao.findAllCustomer().size());
	    	dao.save(customer);
	    	System.out.println(dao.findAllCustomer().size());
	    	Assert.assertEquals(dao.findAllCustomer().size(), 5);
	        customerSaved = dao.findById(5);
	        Address addressSaved = customerSaved.getCustomerAddresses().get(0).getAddress();	        
	        Assert.assertEquals(customer.getFirstName(), customerSaved.getFirstName());
	        Assert.assertEquals(address.getAddressline1(), addressSaved.getAddressline1());
	    }	
	 
	    @Test
	    public void findAllEmployees(){
	        Assert.assertEquals(dao.findAllCustomer().size(), 4);
	    }	     
	    
	    public Address getSampleAddress(){
		   	Address address = new Address();
		    address.setAddressline1("Rua X");
		    address.setAddressline2("800");
		    address.setCity("XPTO");
		    address.setState("SP");	        
		    return address;
		}
	    
	    public Customer getSampleCustomer(Address address){
	    	Customer customer = new Customer();
	        customer.setFirstName("Karen");
	        customer.setEmail("12345@asdas.com");
	        customer.setLastName("last");
	        customer.setSex("M");
	        customer.setDateBorn(new Date("01/01/1991"));
	        CustomerAddress customerAddress = new CustomerAddress();
	        customerAddress.setAddress(address);
	        customerAddress.setTypeAddress("RES");
	        List<CustomerAddress> listCustomerAddress=new ArrayList<CustomerAddress>();
	        listCustomerAddress.add(customerAddress);
	        customer.setCustomerAddresses(listCustomerAddress);
	        return customer;
	    }

		@Override
		protected IDataSet getDataSet() throws Exception {
			 IDataSet dataSet = new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Customer.xml"));
		     return dataSet;
		}
	
}
