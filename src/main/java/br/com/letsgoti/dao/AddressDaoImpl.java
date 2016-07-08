package br.com.letsgoti.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import br.com.letsgoti.model.Address;


@Repository("addressDao")
public class AddressDaoImpl extends AbstractDao<Integer, Address> implements AddressDao {

	public Address findById(int id) {
		Address address = getByKey(id);
		if(address!=null){
		//	Hibernate.initialize(customer.getCustomerAddresses());
		}
		return address;
	}


	@SuppressWarnings("unchecked")
	public List<Address> findAllAddress() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("city"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Address> address = (List<Address>) criteria.list();

		return address;
	}

	public int save(Address address) {
		return persist(address);
	}


}
