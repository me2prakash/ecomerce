package com.vimco.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vimco.ecommerce.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
