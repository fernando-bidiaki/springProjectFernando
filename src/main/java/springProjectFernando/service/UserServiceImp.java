package springProjectFernando.service;

public class UserServiceImp implements UserService {

	@Override
	public void getUserName(String name) {
		System.out.println("Nome " + name );

	}

	@Override
	public void getUserAddress(String address) {
		System.out.println("Endereço " + address );

	}

	@Override
	public void getUserPhoneNumber(String phoneNumber) {
		System.out.println("Telefone " + phoneNumber );

	}

}
