package fr.codeonce.examples.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.codeonce.examples.mapper.ProductMapper;
import fr.codeonce.examples.repository.ProductRepository;
import fr.codeonce.examples.rest.ProductDto;

@Service
public class ProductServiceImp implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductMapper mapper;

	

	public void setMapper(ProductMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public ProductDto createProduct(ProductDto product) {
		return mapper.productToDto(productRepository.save(mapper.dtoToProduct(product)));
	}

	@Override
	public Optional<ProductDto> getProductByCode(String code) {
		return productRepository.findByCode(code).map(c -> mapper.productToDto(c));
	}

	@Override
	public List<ProductDto> getAll() {
		return productRepository.findAll().stream().map(product -> mapper.productToDto(product))
				.collect(Collectors.toList());
	}

}
