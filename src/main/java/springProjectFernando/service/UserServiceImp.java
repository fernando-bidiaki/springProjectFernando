package springProjectFernando.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import springProjectFernando.entity.User;

@Service
public class UserServiceImp implements UserService {

	List<User> users = new ArrayList<>();

	@Override
	public User findById(Integer id) {
		User found = new User();
		found.setId(id);
		List<User> list = findAll();

		if (list.contains(found)) {
			found = list.get(list.indexOf(found));
		}
		return found;
	}

	@Override
	public List<User> findAll() {

		return users;
	}

	@Override
	public void save(User user) {
		users.add(user);
	}

	@Override
	public void delete(User user) {

	}

	@Override
	public User update(Integer userId, User user) {
		
		/*
		 * O método BeanUtils.copyProperties substitui os seguintes comandos:
		 * foundUser.setFirstName(user.getFirstName());
		 * foundUser.setLastName(user.getLastName());
		 * foundUser.setCpf(user.getCpf());
		 */
		
		User foundUser = findById(userId);
		BeanUtils.copyProperties(user, foundUser, "id");
		return foundUser;

	}

}
