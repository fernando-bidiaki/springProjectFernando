package springProjectFernando.service;

import java.util.List;

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

	@Override
	public User findById(Integer id) {
		return userDao.findById(id);
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public void save(User user) {
		userDao.save(user);
	}

	@Override
	public User update(User user) {
		userDao.update(user);
		return user;
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
	}

	@Override
	public User findByCpf(String cpf) {
		return userDao.findByCpf(cpf);
	}

	@Override
	public List<User> findBy(String lastName, String firstName, String cpf) {
		
		return userDao.findBy(lastName,firstName,cpf);
	}

}
