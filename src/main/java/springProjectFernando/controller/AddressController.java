package springProjectFernando.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import springProjectFernando.entity.Address;

@Controller
public class AddressController {

	@RequestMapping("/address")
	public String address(ModelMap map){
		Address address = new Address();
		map.addAttribute("address",address);
		return "address";
	}
	
	@RequestMapping("/address/save")
	public String save(Address address, ModelMap map){
		System.out.println("City: " + address.getCity());
		System.out.println("Street: " + address.getStreet());
		System.out.println("Number: " + address.getNumber());
		
		
		address = new Address();
		map.addAttribute("address",address);
		
		return "address";
	}
}
