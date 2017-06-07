package springProjectFernando.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import springProjectFernando.entity.Product;
import springProjectFernando.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView products(ModelMap map) {

		ModelAndView model = new ModelAndView("products");
		Product product = new Product();
		List<Product> products = productService.findAll();
		map.addAttribute("product", product);
		map.addAttribute("products", products);
		return model;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String save(Product product, ModelMap map) {

		productService.save(product);
		product = new Product();
		map.addAttribute("product", product);
		map.addAttribute("products", productService.findAll());

		return "products";
	}

}
