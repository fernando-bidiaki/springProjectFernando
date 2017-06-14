package springProjectFernando.service;

import java.util.List;

import springProjectFernando.entity.User;


public interface UserService {

	User findById(Integer id);
	
	List<User> findAll();
	
	void save(User user);
	
	User update(Integer userId, User user);
	
	void delete(User user);
	
}
