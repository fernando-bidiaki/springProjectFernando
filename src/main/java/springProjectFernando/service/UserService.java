package springProjectFernando.service;

import springProjectFernando.entity.User;
import springProjectFernando.generic.JPAGeneric;


public interface UserService extends JPAGeneric<User>{
	
	User findByCpf(String cpf);
}
