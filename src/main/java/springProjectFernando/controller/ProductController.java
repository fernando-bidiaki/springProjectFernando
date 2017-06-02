package springProjectFernando.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import springProjectFernando.entity.Product;

@Controller
public class ProductController {

	@RequestMapping("/products")
	public String products(ModelMap map){
		Product product = new Product();
		map.addAttribute("product",product);
		
		return "products";
	}
	
	@RequestMapping("/product/save")
	public String save(Product product, ModelMap map){
		System.out.println("Product name: " + product.getProductName());
		System.out.println("Price: " + product.getProductPrice());
		
		product = new Product();
		map.addAttribute("product",product);
		
		return "products";
	}

}
