package com.infy.protaskswagger.app.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import com.infy.protaskswagger.app.model.ProductSwag;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlRootElement
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProductDto {
	
	private Integer productId;
	private String productName;
	private String productPrice;

}
