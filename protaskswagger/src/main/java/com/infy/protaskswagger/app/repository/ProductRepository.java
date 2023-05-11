package com.infy.protaskswagger.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.infy.protaskswagger.app.model.ProductSwag;


@Repository
public interface ProductRepository extends JpaRepository<ProductSwag, Integer> {

	public ProductSwag findAllByProductName(String productName);
}
