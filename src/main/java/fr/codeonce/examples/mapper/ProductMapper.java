package fr.codeonce.examples.mapper;

import org.mapstruct.Mapper;

import fr.codeonce.examples.domain.Product;
import fr.codeonce.examples.rest.ProductDto;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto productToDto(Product source);
    Product dtoToProduct(ProductDto  destination);

}

