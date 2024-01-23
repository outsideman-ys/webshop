package com.example.servingwebcontent.repo;

import com.example.servingwebcontent.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
