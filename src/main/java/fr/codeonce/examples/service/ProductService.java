package fr.codeonce.examples.service;

import java.util.List;
import java.util.Optional;

import fr.codeonce.examples.mapper.ProductMapper;
import fr.codeonce.examples.rest.ProductDto;

public interface ProductService {
	
	public ProductDto createProduct(ProductDto product) ;
    public Optional<ProductDto> getProductByCode(String code);
    public List<ProductDto> getAll();
	void setMapper(ProductMapper mapper);
		
		

	
}
