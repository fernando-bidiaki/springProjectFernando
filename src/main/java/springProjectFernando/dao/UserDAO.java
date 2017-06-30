package springProjectFernando.dao;

import springProjectFernando.entity.User;
import springProjectFernando.generic.JPAGeneric;

public interface UserDAO extends JPAGeneric<User>{

	User findByCpf(String cpf);
}
