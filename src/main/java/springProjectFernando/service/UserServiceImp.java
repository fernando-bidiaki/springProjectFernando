package springProjectFernando.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springProjectFernando.dao.UserDAO;
import springProjectFernando.entity.User;

@Service
@Transactional
public class UserServiceImp implements UserService {

	@Autowired
	private UserDAO userDao;

	List<User> users = new ArrayList<>();

	@Override
	public User findById(Integer id) {

		return userDao.findById(id);
	}

	@Override
	public List<User> findAll() {

		return users;
	}

	@Override
	public void save(User user) {
		userDao.save(user);
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
		userDao.update(foundUser);
		return foundUser;

	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
	}
}
