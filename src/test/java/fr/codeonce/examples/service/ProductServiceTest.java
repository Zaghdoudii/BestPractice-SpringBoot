package fr.codeonce.examples.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import fr.codeonce.examples.domain.Product;
import fr.codeonce.examples.mapper.ProductMapper;
import fr.codeonce.examples.mapper.ProductMapperImpl;
import fr.codeonce.examples.repository.ProductRepository;
import fr.codeonce.examples.rest.ProductDto;
import fr.codeonce.examples.service.ProductService;
import fr.codeonce.examples.service.ProductServiceImp;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

	@InjectMocks
	private ProductService productService = new ProductServiceImp();

	@Mock
	private ProductRepository productRepository;

	private ProductMapper productMapper = new ProductMapperImpl();

	@BeforeEach
	public void init() {

		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void test() {
	}

	@Test
	public void createProductShouldReturnProduct() {
		productService.setMapper(productMapper);
		ProductDto product = new ProductDto("123", "laptop", 20, new BigDecimal(40));
		Product entity = Product.builder()//
				.code("123")//
				.title("laptop")//
				.build();
		Mockito.when(productRepository.save(Mockito.any())).thenReturn(entity);
		ProductDto createdProduct = productService.createProduct(product);
		Assert.assertEquals(product, createdProduct);

	}

	@Test
	public void getProductShouldReturnAllProduct() {
		productService.setMapper(productMapper);
		ProductDto product1 = new ProductDto("123", "laptop", 20, new BigDecimal(40));
		ProductDto product2 = new ProductDto("125", "screen", 70, new BigDecimal(65));
		ProductDto product3 = new ProductDto("124", "keyboard", 60, new BigDecimal(36));
		List<ProductDto> listProductDto = new ArrayList<ProductDto>();
		listProductDto.add(product1);
		listProductDto.add(product2);
		listProductDto.add(product3);
		Product entity = Product.builder()//
				.code("123")//
				.title("laptop")//
				.build();
		Product entity2 = Product.builder()//
				.code("125")//
				.title("screen")//
				.build();
		Product entity3 = Product.builder()//
				.code("124")//
				.title("keyboard")//
				.build();
		List<Product> listProduct = new ArrayList<Product>();
		listProduct.add(entity);
		listProduct.add(entity2);
		listProduct.add(entity3);

		Mockito.when(productRepository.findAll()).thenReturn(listProduct);
		List<ProductDto> resultProductDto = productService.getAll();
		
		Assert.assertArrayEquals(listProductDto.toArray(),resultProductDto.toArray());

	}
	@Test
	public void getProductShouldReturnOneProductByCode() {
		productService.setMapper(productMapper);
		ProductDto product = new ProductDto("123", "laptop", 20, new BigDecimal(40));
		Product entity = Product.builder()//
				.code("123")//
				.title("laptop")//
				.build();
		
		Mockito.when(productRepository.save(Mockito.any())).thenReturn(entity);
		ProductDto createdProduct = productService.createProduct(product);
		Assert.assertEquals(product, createdProduct);

		Optional<Product> optionalentity = Optional.of(entity);
		Mockito.when(productRepository.findByCode("123")).thenReturn(optionalentity );
		ProductDto productDto = productService.getProductByCode("123").get();
		

		Assert.assertEquals(product,productDto );

	}

}
