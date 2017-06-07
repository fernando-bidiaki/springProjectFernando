package springProjectFernando.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import springProjectFernando.entity.Address;

@Service
public class AddressServiceImpl implements AddressService {

	List<Address> address = new ArrayList<>();
	
	@Override
	public Address findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Address> findAll() {
		// TODO Auto-generated method stub
		return address;
	}

	@Override
	public void save(Address address) {
		this.address.add(address);

	}

	@Override
	public void update(Address address) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Address address) {
		// TODO Auto-generated method stub

	}

}
