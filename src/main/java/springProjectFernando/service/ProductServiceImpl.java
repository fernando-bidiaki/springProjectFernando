package springProjectFernando.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import springProjectFernando.entity.Product;

@Service
public class ProductServiceImpl implements ProductService{

	List<Product> products = new ArrayList<>();
	
	@Override
	public Product findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return products;
	}

	@Override
	public void save(Product product) {
		products.add(product);
		
	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Product product) {
		// TODO Auto-generated method stub
		
	}

}
