package com.infy.protaskswagger.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.protaskswagger.app.dto.ProductDto;
import com.infy.protaskswagger.app.model.ProductSwag;
import com.infy.protaskswagger.app.servicei.ProductDtoServicei;
import com.infy.protaskswagger.app.servicei.productServicei;

import lombok.Delegate;

@RestController
@RequestMapping(value = "/api")
public class ProductController {

	@Autowired
	productServicei psi;
	
	@Autowired
	ProductDtoServicei mapper;
	
	// post api/product
	@PostMapping(value = "/product",consumes = {"application/json","application/xml"}
				,produces = {"application/json","application/xml"})
	public ResponseEntity<ProductSwag> savepro(@RequestBody ProductDto dto){
		
		ProductSwag pds = mapper.toEntity(dto);		 
	 	ProductSwag pro = psi.savepro(pds);
	 	ProductDto pdto = mapper.todto(pro);
	 	return new ResponseEntity<ProductSwag>(pro,HttpStatus.CREATED);
	}
	
	
	@GetMapping(value = "/products")
	public ResponseEntity<List<ProductSwag>> getAll(){
		
		 List<ProductSwag> ps= psi.getAll();
		  return new ResponseEntity<List<ProductSwag>>(ps,HttpStatus.OK);
	}
	@PutMapping(value = "/updatepro/{productId}")
	public ResponseEntity<ProductSwag> updatePro(@RequestBody ProductSwag p, @PathVariable Integer productId){
		
		ProductSwag pu = psi.savepro(p);
		return new ResponseEntity<ProductSwag>(pu,HttpStatus.OK);
	}
	@DeleteMapping(value = "/deletepro/{productId}")
	public ResponseEntity  deletePro(@PathVariable Integer productId) {
		
		psi.deletePro(productId);
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
	@GetMapping(value = "/product/{productName}")
	public ResponseEntity<ProductDto> searchName(@PathVariable String productName){
		
		ProductSwag swag = psi.searchName(productName);
		return new ResponseEntity<ProductDto>(mapper.todto(swag),HttpStatus.OK);
	}
}
