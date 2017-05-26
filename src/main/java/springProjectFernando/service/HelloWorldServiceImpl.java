package springProjectFernando.service;

public class HelloWorldServiceImpl implements HelloWorldService{

	@Override
	public void sayHello( String name) {
		System.out.println("Hello " + name);
		
	}

}
