package com.infy.protaskswagger.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProductSwag {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;
	private String productName;
	private String productPrice;

}
