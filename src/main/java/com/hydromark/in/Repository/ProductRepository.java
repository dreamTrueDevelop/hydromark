package com.hydromark.in.Repository;

import com.hydromark.in.DTO.Products;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Products, Long> {
}
