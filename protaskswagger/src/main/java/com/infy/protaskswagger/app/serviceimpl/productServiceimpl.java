package com.infy.protaskswagger.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.infy.protaskswagger.app.model.ProductSwag;
import com.infy.protaskswagger.app.repository.ProductRepository;
import com.infy.protaskswagger.app.servicei.productServicei;

@Service
public class productServiceimpl implements productServicei{
	
	@Autowired
	ProductRepository pr;

	@Override
	public ProductSwag savepro(ProductSwag p) {
		
		ProductSwag pro = pr.save(p);
		System.out.println("this  is serviceimpl");
		return pro;
	}

	@Override
	public List<ProductSwag> getAll() {
		
		List<ProductSwag> ps = pr.findAll();
		return ps;
	}

	@Override
	public void deletePro(Integer productId) {
		
		pr.deleteById(productId);
	}

	@Override
	public ProductSwag searchName(String productName) {
		ProductSwag proname = pr.findAllByProductName(productName);
		return proname;
	}

	

	
}
