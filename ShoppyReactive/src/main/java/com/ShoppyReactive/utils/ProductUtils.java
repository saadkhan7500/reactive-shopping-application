package com.ShoppyReactive.utils;

import org.springframework.beans.BeanUtils;


import com.ShoppyReactive.dto.ProductDto;
import com.ShoppyReactive.entities.Product;

public class ProductUtils {

	public static ProductDto entityToDto(Product product)
	{
		ProductDto productDto = new ProductDto();
		BeanUtils.copyProperties(product, productDto);
		return productDto;
	}
	
	public static Product dtoToEntity(ProductDto productDto)
	{
		Product product = new Product();
		BeanUtils.copyProperties(productDto, product);
		return product;
	}
	
}
