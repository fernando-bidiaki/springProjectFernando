package springProjectFernando.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import springProjectFernando.config.springProjectConfig;
import springProjectFernando.service.UserService;

public class springProjectMain {
	public static void main(String[] args){
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(springProjectConfig.class);
		UserService user = context.getBean(UserService.class);
		user.getUserName("Fernando");
		user.getUserAddress("Belmiro Andrade");
		user.getUserPhoneNumber("12 39330630");
		context.close();
	}
}
