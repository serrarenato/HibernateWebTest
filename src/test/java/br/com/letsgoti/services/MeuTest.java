package br.com.letsgoti.services;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import org.springframework.core.env.Environment;


import br.com.letsgoti.dao.CustomerDao;
import br.com.letsgoti.dao.EntityDaoImplTest;
import br.com.letsgoti.model.Customer;
import br.com.letsgoti.service.CustomerService;
import br.com.letsgoti.service.CustomerServiceImpl;

public class MeuTest extends EntityDaoImplTest{


  //  @Mock
  //  CustomerDao dao;
     
 ///   @InjectMocks
 //   CustomerServiceImpl service;
    
    
  //  CustomerService service;
    
    @Autowired     
    CustomerDao dao;
    
    @BeforeClass
    public void setUp(){
   //     MockitoAnnotations.initMocks(this);   
  //      service = new CustomerServiceImpl();
    }
    
    @Test
    public void findById2(){
        Customer customer = new Customer();
    	Assert.assertNotNull(dao.findById(1));
        customer = dao.findById(1);    	
   //     Assert.assertEquals(service.findById(customer.getId()),customer);
    }
    
   // @Test
   // public void findById(){
    //    Customer customer = new Customer();
      //  when(dao.findById(anyInt())).thenReturn(customer);
     //   Assert.assertEquals(service.findById(customer.getId()),customer);
  //  }
    
	@Test
	public void findById(){
		Assert.assertNotNull(dao.findById(1));
		Assert.assertNull(dao.findById(5));
	}
    


	@Override
	protected IDataSet getDataSet() throws Exception {
		IDataSet dataSet = new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Customer.xml"));
		return dataSet;
	}
}
