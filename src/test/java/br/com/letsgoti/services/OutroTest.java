package br.com.letsgoti.services;

import java.util.Date;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import br.com.letsgoti.dao.CustomerDao;
import br.com.letsgoti.dao.EntityDaoImplTest;
import br.com.letsgoti.model.Customer;
import br.com.letsgoti.service.CustomerService;
import br.com.letsgoti.service.CustomerServiceImpl;

public class OutroTest extends EntityDaoImplTest {

	private CustomerService service;

	@Autowired
	private CustomerDao dao;

	@Test
	public void findById() {
		service = new CustomerServiceImpl();
		Customer customer = new Customer();
		Assert.assertNotNull(dao.findById(1));
		customer = dao.findById(1);
		Assert.assertEquals(service.findById(customer.getId()), customer);
		Assert.assertNotNull(dao.findById(1));
		Assert.assertNull(dao.findById(5));

	}

	@Test
	public void saveCustomer() {
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
	public void findAllEmployees() {
		Assert.assertEquals(dao.findAllCustomer().size(), 4);
	}

	public Customer getSampleCustomer() {
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
