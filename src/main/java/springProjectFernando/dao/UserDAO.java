package springProjectFernando.dao;

import java.util.List;

import springProjectFernando.entity.User;
import springProjectFernando.generic.JPAGeneric;

public interface UserDAO extends JPAGeneric<User>{

	User findByCpf(String cpf);

	List<User> findBy(String lastName, String firstName, String cpf);
}
