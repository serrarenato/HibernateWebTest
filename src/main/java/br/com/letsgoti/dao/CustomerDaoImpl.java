package br.com.letsgoti.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import br.com.letsgoti.model.Customer;


@Repository("customerDao")
public class CustomerDaoImpl extends AbstractDao<Integer, Customer> implements CustomerDao {

	public Customer findById(int id) {
		Customer customer = getByKey(id);
		if(customer!=null){
		//	Hibernate.initialize(customer.getCustomerAddresses());
		}
		return customer;
	}


	@SuppressWarnings("unchecked")
	public List<Customer> findAllCustomer() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("firstName"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Customer> users = (List<Customer>) criteria.list();

		return users;
	}

	public int save(Customer customer) {
		return persist(customer);
	}


}
