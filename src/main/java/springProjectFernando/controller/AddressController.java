package springProjectFernando.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import springProjectFernando.entity.Address;
import springProjectFernando.service.AddressService;

@Controller
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView address(ModelMap map) {
		ModelAndView model = new ModelAndView("addresses");
		Address address = new Address();
		List<Address> addresses = addressService.findAll();
		map.addAttribute("address", address);
		map.addAttribute("addresses", addresses);
		return model;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String save(Address address, ModelMap map) {

		addressService.save(address);

		address = new Address();
		map.addAttribute("address", address);
		map.addAttribute("addresses", addressService.findAll());

		return "addresses";
	}
}
