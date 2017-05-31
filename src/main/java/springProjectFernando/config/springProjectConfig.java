package springProjectFernando.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import springProjectFernando.service.HelloWorldService;
import springProjectFernando.service.HelloWorldServiceImpl;
import springProjectFernando.service.UserService;
import springProjectFernando.service.UserServiceImp;

@Configuration
@EnableWebMvc
@ComponentScan("springProjectFernando")
public class springProjectConfig {

	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver resourceViewResolver = new InternalResourceViewResolver();
		resourceViewResolver.setPrefix("/WEB-INF/views/pages/");
		resourceViewResolver.setSuffix(".jsp");
		return resourceViewResolver;
	}
	
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
