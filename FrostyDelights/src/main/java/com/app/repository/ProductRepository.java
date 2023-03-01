package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
