package br.com.letsgoti.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import br.com.letsgoti.model.Customer;
import br.com.letsgoti.service.CustomerService;

@Controller
@RequestMapping("/")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
    @RequestMapping(value = { "/new-customer" }, method = RequestMethod.GET)
    public String newForm(ModelMap model) {
        Customer customer = new Customer();
                
        model.addAttribute("customer", customer);
        model.addAttribute("edit", false);
        return "customerform";
    }
 
    @RequestMapping(value = { "/new-customer" }, method = RequestMethod.POST)
    public String savecustomer(@Valid Customer customer, BindingResult result, ModelMap model){
 
        if(result.hasErrors()) {
                return "customerform";
        }
 
        model.addAttribute("customer", customer);
        customerService.saveUser(customer);
        return "success";
    }
	
	@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	public String listUsers(ModelMap model) {

		List<Customer> listCustomers = customerService.findAllCustomers();
		model.addAttribute("customers", listCustomers);
		return "customerlist";
	}

	@RequestMapping(value = { "/edit-customer-{id}" }, method = RequestMethod.GET)
	public String editCustomer(@PathVariable String id, ModelMap model) {
		Customer customer = customerService.findById(new Integer(id));
		model.addAttribute("customer", customer);
		model.addAttribute("edit", true);
		return "customerform";
	}
	@RequestMapping(value = { "/edit-customer-{id}" }, method = RequestMethod.POST)	  
	public String editCustomerSave(@Valid Customer customer, BindingResult result, ModelMap model) {
		 
        if(result.hasErrors()) {
                return "customerform";
        }
 
        model.addAttribute("customer", customer);
        customerService.saveUser(customer);
        return "success";
	}

}
