package execise.order.service;

import java.util.List;

import execise.order.domain.Customer;

public interface CustomerService {
	Customer getCustomer(long id);
	List<Customer> getCustomers();
	void saveCustomer(Customer customer);
	void updateCustomer(Customer customer);
	void deleteCustomer(long id);
}
