package springProjectFernando.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import springProjectFernando.service.HelloWorldService;
import springProjectFernando.service.HelloWorldServiceImpl;
import springProjectFernando.service.UserService;
import springProjectFernando.service.UserServiceImp;

@Configuration
@EnableWebMvc
@ComponentScan("springProjectFernando")
public class springProjectConfig extends WebMvcConfigurerAdapter{

/*	@Bean
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
	}*/

	@Bean
	public TilesConfigurer tilesConfigure(){
		TilesConfigurer tiles = new TilesConfigurer();
		tiles.setDefinitions(new String[]{"/WEB-INF/views/**/tiles.xml"});
		tiles.setCheckRefresh(true);
		return tiles;
	}
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry){
		TilesViewResolver viewResolver = new TilesViewResolver();
		registry.viewResolver(viewResolver);
	}
}
