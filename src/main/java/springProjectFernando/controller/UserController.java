package springProjectFernando.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import springProjectFernando.entity.User;
import springProjectFernando.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView users(ModelMap map){
		ModelAndView model = new ModelAndView("users");
		User user = new User();
		List<User> users = userService.findAll();
		map.addAttribute("user",user);
		map.addAttribute("users",users);
		return model;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String save(User user, ModelMap map){

		userService.save(user);

		user = new User();
		map.addAttribute("user",user);
		map.addAttribute("users",userService.findAll());

		return "users";
	}
}
