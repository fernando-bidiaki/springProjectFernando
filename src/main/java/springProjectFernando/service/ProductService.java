package springProjectFernando.service;

import java.util.List;

import springProjectFernando.entity.Product;

public interface ProductService {

	Product findById(Integer id);

	List<Product> findAll();

	void save(Product product);

	void update(Product product);

	void delete(Product product);
}
