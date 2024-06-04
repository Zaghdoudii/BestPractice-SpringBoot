package fr.codeonce.examples;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.codeonce.examples.rest.ProductController;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringDbAppApplicationTest {
	
	@Autowired
	ProductController productController;

	@Test
	public void contextLoads() {
	}
	
	
}
