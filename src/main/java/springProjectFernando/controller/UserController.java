package springProjectFernando.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import springProjectFernando.entity.User;

@Controller
public class UserController {
	
	private List<User> users = new ArrayList<>();
	
	@RequestMapping("/users")
	public ModelAndView users(ModelMap map){
		ModelAndView model = new ModelAndView("users");
		User user = new User();
		map.addAttribute("user",user);
		map.addAttribute("users",users);
		return model;
	}
	
	@RequestMapping("/user/save")
	public String save(User user, ModelMap map){
		System.out.println("First name: " + user.getFirstName());
		System.out.println("Last name: " + user.getLastName());
		System.out.println("CPF: " + user.getCpf());
		
		users.add(user);
		
		user = new User();
		map.addAttribute("user",user);
		map.addAttribute("users",users);
		
		return "users";
	}
}
