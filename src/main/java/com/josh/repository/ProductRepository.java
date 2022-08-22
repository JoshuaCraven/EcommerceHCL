package com.josh.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.josh.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
