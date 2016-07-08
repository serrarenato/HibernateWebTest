package br.com.letsgoti.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import br.com.letsgoti.dao.CustomerDao;
import br.com.letsgoti.dao.EntityDaoImplTest;
import br.com.letsgoti.model.Customer;
import br.com.letsgoti.service.CustomerService;

public class CustomerServiceTest extends EntityDaoImplTest {	



//	@Autowired
//	CustomerDao dao;
	
	 /*@Mock
	    EmployeeDao dao;
	     
	 @InjectMocks
	    EmployeeServiceImpl employeeService;*/
	@Mock
	CustomerDao dao;
    
	 @InjectMocks
	CustomerService customerService;
	 
	 @BeforeClass
	    public void setUp(){
	        MockitoAnnotations.initMocks(this);	        
	    }

	@Test
	public void findById(){			
		Customer customer = getCustomerList().get(0);
	//	Customer customer = dao.findById(1);	        
		Assert.assertEquals(customerService.findById(customer.getId()),customer);

	}

/*	@Test
	public void findAllCustomers(){
		List <Customer> listCustomer = dao.findAllCustomer();
		Assert.assertEquals(customerService.findAllCustomers(), listCustomer);
	}

	@Test
	public void saveEmployee(){
		List <Customer> listCustomer= getCustomerList();
		customerService.saveUser(listCustomer.get(0));
		Assert.assertEquals(dao.findAllCustomer().size(),5);
	}

	/*  @Test
	    public void updateEmployee(){
	    	Customer customer = getCustomerList(0);
	        when(dao.findById(anyInt())).thenReturn(emp);
	        employeeService.updateEmployee(emp);
	        verify(dao, atLeastOnce()).findById(anyInt());
	    }*/ 



	public List<Customer> getCustomerList(){
		List <Customer> listCustomers = new ArrayList<Customer>(); 
		Customer e1 = new Customer();
		e1.setId(1);
		e1.setFirstName("Axel");
		e1.setDateBorn(new Date("15/12/1990"));
		e1.setLastName("Last");
		e1.setSex("M");
		e1.setEmail("asdasd@adsd.com");

		Customer e2 = new Customer();
		e1.setId(2);
		e1.setFirstName("Jeremy");
		e1.setDateBorn(new Date("15/12/1990"));
		e1.setLastName("Last");
		e1.setSex("M");
		e1.setEmail("asdasd@adsd.com");


		listCustomers.add(e1);
		listCustomers.add(e2);
		return listCustomers;
	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		IDataSet dataSet = new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Customer.xml"));
		return dataSet;
	}
}


