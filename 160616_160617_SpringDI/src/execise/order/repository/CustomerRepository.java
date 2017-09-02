package execise.order.repository;

import java.util.List;

import execise.order.entity.CustomerEntity;

public interface CustomerRepository {
	CustomerEntity findOne(long id);
	List<CustomerEntity> findAll();
	void save(CustomerEntity customer);
	void delete(long id);
}
