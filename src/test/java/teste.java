
 
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.context.MessageSource;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import br.com.letsgoti.controller.CustomerController;
import br.com.letsgoti.model.Customer;
import br.com.letsgoti.service.CustomerService;
 
 

 
public class teste {
 
    @Mock
    CustomerService service;
     
    @Mock
    MessageSource message;
     
    @InjectMocks
    CustomerController appController;
     
    @Spy
    List<Customer> listCustomer = new ArrayList<Customer>();
 
    @Spy
    ModelMap model;
     
    @Mock
    BindingResult result;
     
    @BeforeClass
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        listCustomer = getCustomerList();
    }
     
 /*   @Test
    public void listEmployees(){
        when(service.findAllEmployees()).thenReturn(employees);
        Assert.assertEquals(appController.listEmployees(model), "allemployees");
        Assert.assertEquals(model.get("employees"), employees);
        verify(service, atLeastOnce()).findAllEmployees();
    }
     
    @Test
    public void newEmployee(){
        Assert.assertEquals(appController.newEmployee(model), "registration");
        Assert.assertNotNull(model.get("employee"));
        Assert.assertFalse((Boolean)model.get("edit"));
        Assert.assertEquals(((Employee)model.get("employee")).getId(), 0);
    }
 
 
    @Test
    public void saveEmployeeWithValidationError(){
        when(result.hasErrors()).thenReturn(true);
        doNothing().when(service).saveEmployee(any(Employee.class));
        Assert.assertEquals(appController.saveEmployee(employees.get(0), result, model), "registration");
    }
 
    @Test
    public void saveEmployeeWithValidationErrorNonUniqueSSN(){
        when(result.hasErrors()).thenReturn(false);
        when(service.isEmployeeSsnUnique(anyInt(), anyString())).thenReturn(false);
        Assert.assertEquals(appController.saveEmployee(employees.get(0), result, model), "registration");
    }
 
     
    @Test
    public void saveEmployeeWithSuccess(){
        when(result.hasErrors()).thenReturn(false);
        when(service.isEmployeeSsnUnique(anyInt(), anyString())).thenReturn(true);
        doNothing().when(service).saveEmployee(any(Employee.class));
        Assert.assertEquals(appController.saveEmployee(employees.get(0), result, model), "success");
        Assert.assertEquals(model.get("success"), "Employee Axel registered successfully");
    }
 
    @Test
    public void editEmployee(){
        Employee emp = employees.get(0);
        when(service.findEmployeeBySsn(anyString())).thenReturn(emp);
        Assert.assertEquals(appController.editEmployee(anyString(), model), "registration");
        Assert.assertNotNull(model.get("employee"));
        Assert.assertTrue((Boolean)model.get("edit"));
        Assert.assertEquals(((Employee)model.get("employee")).getId(), 1);
    }
 
    @Test
    public void updateEmployeeWithValidationError(){
        when(result.hasErrors()).thenReturn(true);
        doNothing().when(service).updateEmployee(any(Employee.class));
        Assert.assertEquals(appController.updateEmployee(employees.get(0), result, model,""), "registration");
    }
 
    @Test
    public void updateEmployeeWithValidationErrorNonUniqueSSN(){
        when(result.hasErrors()).thenReturn(false);
        when(service.isEmployeeSsnUnique(anyInt(), anyString())).thenReturn(false);
        Assert.assertEquals(appController.updateEmployee(employees.get(0), result, model,""), "registration");
    }
 
  /*  @Test
    public void updateCustomerWithSuccess(){
        when(result.hasErrors()).thenReturn(false);
        when(service.isEmployeeSsnUnique(anyInt(), anyString())).thenReturn(true);
        doNothing().when(service).updateEmployee(any(Employee.class));
        Assert.assertEquals(appController.updateEmployee(employees.get(0), result, model, ""), "success");
        Assert.assertEquals(model.get("success"), "Employee Axel updated successfully");
    }*/
     
     

 
    public List<Customer> getCustomerList(){
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
     
         
        listCustomer.add(e1);
        listCustomer.add(e2);
        return listCustomer;
    }
}