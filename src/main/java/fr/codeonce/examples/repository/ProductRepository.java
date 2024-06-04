package fr.codeonce.examples.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.codeonce.examples.domain.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product,String>
{
    public Optional<Product> findByCode(String code);
    public List<Product> findAll();
}	

