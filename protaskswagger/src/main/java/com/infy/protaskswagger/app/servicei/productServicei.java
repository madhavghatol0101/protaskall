package com.infy.protaskswagger.app.servicei;

import java.util.List;

import com.infy.protaskswagger.app.model.ProductSwag;

public interface productServicei {

	public ProductSwag savepro(ProductSwag p);

	public List<ProductSwag> getAll();

	public void deletePro(Integer productId);

	public ProductSwag searchName(String productName);


}
