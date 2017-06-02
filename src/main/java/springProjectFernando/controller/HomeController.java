package springProjectFernando.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home(ModelMap map){
		map.addAttribute("nome","Zé dos Brocoly");
		return "home";
	}
}
