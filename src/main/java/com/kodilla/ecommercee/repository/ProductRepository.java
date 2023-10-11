package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface ProductRepository extends CrudRepository<Product, Long> {

    @Override
    List<Product> findAll();
    List<Product> findByNameIgnoreCase(String name);

    @Override
    Product save(Product product);
  
    @Override
    void deleteById(Long id);
  
    @Override
    Optional<Product> findById(Long id);

}