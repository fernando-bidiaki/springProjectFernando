package springProjectFernando.service;

import java.util.List;

import springProjectFernando.entity.Address;

public interface AddressService {
	
	Address findById(Integer id);

	List<Address> findAll();

	void save(Address address);

	void update(Address address);

	void delete(Address address);
}
