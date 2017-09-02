package execise.order.service;

import java.util.ArrayList;
import java.util.List;

import execise.order.domain.Customer;
import execise.order.entity.CustomerEntity;
import execise.order.repository.CustomerRepository;

public class CustomerServiceImpl  implements CustomerService {
	private CustomerRepository repository;
	/* 생성자 의존성 주입
	public CustomerServiceImpl(CustomerRepository repository) {
		this.repository = repository;
	}
	*/
	/* 필드 의존성 주입 */
	public void setCustomerRepository(CustomerRepository repository) {
		this.repository = repository;
	}
	@Override
	public Customer getCustomer(long id) {
		CustomerEntity entity =  repository.findOne(id);
		return entity.buildDomain();
	}

	@Override
	public List<Customer> getCustomers() {
		List<Customer> customers = new ArrayList<Customer>();
		List<CustomerEntity> entities = repository.findAll();
		for(CustomerEntity entity : entities) {
			Customer customer = entity.buildDomain();
			customers.add(customer);
		}
		return customers;
	}

	
	@Override
	public void saveCustomer(Customer customer) {
		CustomerEntity entity = new CustomerEntity();
		entity.buildEntity(customer);
		repository.save(entity);
	}

	@Override
	public void updateCustomer(Customer customer) {
		CustomerEntity entity = new CustomerEntity();
		entity.buildEntity(customer);
		repository.save(entity);
	}

	@Override
	public void deleteCustomer(long id) {
		repository.delete(id);
	}
}
