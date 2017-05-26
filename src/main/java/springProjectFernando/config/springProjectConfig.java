package springProjectFernando.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import springProjectFernando.service.HelloWorldService;
import springProjectFernando.service.HelloWorldServiceImpl;
import springProjectFernando.service.UserService;
import springProjectFernando.service.UserServiceImp;

@Configuration
public class springProjectConfig {

	@Bean(name = "helloBean")
	@Description("Description")
	public HelloWorldService hello(){
		return new HelloWorldServiceImpl();
	}
	
	@Bean(name = "user")
	@Description("user bean")
	public UserService user(){
		return new UserServiceImp();
	}
	
}
