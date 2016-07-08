package br.com.letsgoti.dao;
import java.util.Date;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.testng.Assert;
import org.testng.annotations.Test;

import br.com.letsgoti.model.Address;

public class AddressTest extends EntityDaoImplTest {
 
    @Autowired
    private Environment environment;

	@Autowired
	private AddressDao dao;	
	
	
	 
	    @Test
	    public void findById(){
	        Assert.assertNotNull(dao.findById(1));
	        Assert.assertNull(dao.findById(4));
	    }
	     
	    @Test
	    public void saveAddress(){
	    	Address address;
	    	Address addressSaved;
	    	address = getSampleAddress();
	    	System.out.println(dao.findAllAddress().size());
	    	dao.save(address);
	    	System.out.println(dao.findAllAddress().size());
	    	Assert.assertEquals(dao.findAllAddress().size(), 4);
	        addressSaved = dao.findById(4);
	        Assert.assertEquals(address.getAddressline1(), addressSaved.getAddressline1());
	    }	
	 
	    @Test
	    public void findAllEmployees(){
	        Assert.assertEquals(dao.findAllAddress().size(), 3);
	    }	     
	 
	    public Address getSampleAddress(){
	    	Address address = new Address();
	        address.setAddressline1("Rua X");
	        address.setAddressline2("800");
	        address.setCity("XPTO");
	        address.setState("SP");	        
	        return address;
	    }

		@Override
		protected IDataSet getDataSet() throws Exception {
			 IDataSet dataSet = new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Customer.xml"));
		     return dataSet;
		}
	
}
