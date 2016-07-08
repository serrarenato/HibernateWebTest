package br.com.letsgoti.dao;

import java.util.Date;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.testng.Assert;
import org.testng.annotations.Test;

import br.com.letsgoti.model.Customer;

public class CustomerTest extends EntityDaoImplTest {


	@Autowired
	private CustomerDao dao;	



	@Test
	public void findById(){
		Assert.assertNotNull(dao.findById(1));
		Assert.assertNull(dao.findById(5));
	}

	@Test
	public void saveCustomer(){
		Customer customer;
		Customer customerSaved;
		customer = getSampleCustomer();
		System.out.println(dao.findAllCustomer().size());
		dao.save(customer);
		System.out.println(dao.findAllCustomer().size());
		Assert.assertEquals(dao.findAllCustomer().size(), 5);
		customerSaved = dao.findById(5);
		Assert.assertEquals(customer.getFirstName(), customerSaved.getFirstName());
	}	

	@Test
	public void findAllEmployees(){
		Assert.assertEquals(dao.findAllCustomer().size(), 4);
	}	     

	public Customer getSampleCustomer(){
		Customer customer = new Customer();
		customer.setFirstName("Karen");
		customer.setEmail("12345@asdas.com");
		customer.setLastName("last");
		customer.setSex("M");
		customer.setDateBorn(new Date("01/01/1991"));
		return customer;
	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		IDataSet dataSet = new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Customer.xml"));
		return dataSet;
	}

}
