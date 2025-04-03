package com.cafeShop.cafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cafeShop.cafe.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
