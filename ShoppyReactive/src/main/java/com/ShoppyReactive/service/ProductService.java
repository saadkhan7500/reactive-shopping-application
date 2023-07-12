package com.ShoppyReactive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ShoppyReactive.dto.ProductDto;
import com.ShoppyReactive.repo.ProductRepo;
import com.ShoppyReactive.utils.ProductUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productRepo;
	
	public Mono<ProductDto> getProduct(String id)
	{
		return productRepo.findById(id).map(ProductUtils::entityToDto);
	}
	
	public Flux<ProductDto> getProducts()
	{
		return productRepo.findAll().map(ProductUtils::entityToDto);
	}
	
	public Mono<ProductDto> saveProduct(Mono<ProductDto> productDto)
	{
		return productDto.map(ProductUtils::dtoToEntity)
				          .flatMap(productRepo::insert)
				          .map(ProductUtils::entityToDto);
	}
	
	public Mono<ProductDto> updateProduct(Mono<ProductDto> productDto , String id)
	{
		 return productRepo.findById(id)
				            .flatMap(p->productDto.map(ProductUtils::dtoToEntity)
				            .doOnNext(e->e.setId(id)))
				            .flatMap(productRepo::save)
				            .map(ProductUtils::entityToDto);
	}
	
	public Mono<ProductDto> deleteProduct(String id)
	{
		return productRepo.findById(id)
				           .flatMap(existingUser -> productRepo
				           .delete(existingUser)
				           .then(Mono.just(existingUser)))
				           .map(ProductUtils::entityToDto);
	}

	public Mono<ProductDto> uploadImage(String id, String url) {
		
		 return productRepo.findById(id)
		            .flatMap(product -> {
		                product.setImagePath(url); 
		                return productRepo.save(product); 
		            })
		            .map(ProductUtils::entityToDto); 		    
	}

	public Flux<ProductDto> getProductbyStatus() {
		return productRepo.findAllByStatusAdded()
				          .map(ProductUtils :: entityToDto);
	}

	public Mono<ProductDto> updateStatus(String id, String status) {
		return productRepo.findById(id)
	            .flatMap(product -> {
	                product.setStatus(status); 
	                return productRepo.save(product); 
	            })
	            .map(ProductUtils::entityToDto); 
	}

	public Flux<ProductDto> showProducts() {
		return productRepo.findAllByStatusAccept()
		                  .map(ProductUtils :: entityToDto);
	}

	public Flux<ProductDto> getProductsByCategory(String category) {
		
		return productRepo.getProductsByCategory(category)
				          .map(ProductUtils :: entityToDto);
	}

	public Flux<ProductDto> getProductsByNameOrCategory(String search) {
		
		return productRepo.getProductsByNameOrCategory(search , search)
				          .map(ProductUtils :: entityToDto);
	}

}
