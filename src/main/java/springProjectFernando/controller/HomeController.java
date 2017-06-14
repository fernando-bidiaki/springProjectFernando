package springProjectFernando.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home(ModelMap map) {
		map.addAttribute("nome", "Zé dos Brocoly");
		return "home";
	}
	
	@RequestMapping("/test")
	public String getId(@RequestParam("id") String id, ModelMap map) {
		map.addAttribute("id", id);
		return "home";
	}
	
	@RequestMapping("/hello")
	public String hello(@RequestHeader Map<String, String> agent, @RequestHeader(value = "Accept") String accept, ModelMap map){
		map.addAttribute("agent",agent);
		map.addAttribute("accept",accept);
		return "home";
	}
}
