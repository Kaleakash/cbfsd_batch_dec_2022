package com.repository;

import org.springframework.stereotype.Repository;

import com.bean.Product;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
