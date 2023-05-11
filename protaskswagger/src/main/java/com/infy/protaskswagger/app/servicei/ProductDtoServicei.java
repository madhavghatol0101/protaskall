package com.infy.protaskswagger.app.servicei;

import java.util.List;

import org.mapstruct.Mapper;

import com.infy.protaskswagger.app.dto.ProductDto;
import com.infy.protaskswagger.app.model.ProductSwag;

@Mapper(componentModel = "spring")
public interface ProductDtoServicei {

	public ProductSwag toEntity(ProductDto dto);
	
	public ProductDto todto(ProductSwag pswag);
	
	public List<ProductDto> todtos(List<ProductSwag> pslist);
	
}
