package fr.codeonce.examples.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import fr.codeonce.examples.rest.ProductController;
import fr.codeonce.examples.rest.ProductDto;
import fr.codeonce.examples.service.ProductService;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@WebMvcTest(ProductController.class)
public class ProductControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private ProductService productService;
	
	@Test
	public void testGetAllController() throws Exception {
		ProductDto product = new ProductDto("123", "laptop", 20, new BigDecimal(40));
		ProductDto createdProduct = productService.createProduct(product);
		mvc.perform(get("/api/product/get/all")).andDo(print()).andExpect(status().isOk());
	}
}
