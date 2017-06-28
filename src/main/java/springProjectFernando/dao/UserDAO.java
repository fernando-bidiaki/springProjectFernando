package springProjectFernando.dao;

import java.util.List;

import springProjectFernando.entity.User;

public interface UserDAO {

	User findById(Integer id);

	List<User> findAll();

	void save(User user);

	void update(User user);

	void delete(User user);
}
