package fr.codeonce.examples.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.codeonce.examples.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	public ProductService productService;

	@PostMapping("/save")

	private ProductDto createProduct(@RequestBody ProductDto product) {
		return productService.createProduct(product);
	}

	@GetMapping("/get/all")
	public List<ProductDto> getAllProduct() {
		return productService.getAll();
	}

	@GetMapping("/get/{code}")
	public ProductDto getProductByCode(String code) {
		return productService.getProductByCode(code).get();
	}
}
