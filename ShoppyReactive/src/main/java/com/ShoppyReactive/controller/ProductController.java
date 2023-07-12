package com.ShoppyReactive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ShoppyReactive.dto.ProductDto;
import com.ShoppyReactive.service.ProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {

	@Autowired
	private ProductService productService;
	
	
	@GetMapping("/getProduct/{id}")
	public Mono<ProductDto> getProduct(@PathVariable String id)
	{
		return productService.getProduct(id);
	}
	
	
	@GetMapping("/getProducts")
	public Flux<ProductDto> getProducts()
	{
		return productService.getProducts();
	}
	
	@PostMapping("/saveProduct")
	public Mono<ProductDto> saveProduct(@RequestBody Mono<ProductDto> productDto)
	{
		return productService.saveProduct(productDto);
	}
	
	@PutMapping("/updateProduct/{id}")
	public Mono<ProductDto> updateProduct(@RequestBody Mono<ProductDto> productDto , @PathVariable String id)
	{
		return productService.updateProduct(productDto,id);
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public Mono<ProductDto> deleteProduct(@PathVariable String id)
	{
		return productService.deleteProduct(id);
	}
	
	@PutMapping("/uploadImage/{id}/{url}")
	public Mono<ProductDto> uploadImage(@PathVariable("id") String id,@PathVariable("url") String imageUrl)
	{
		
		
		return productService.uploadImage(id , imageUrl);
	}
	
	@GetMapping("/getProductByStatus")
	public Flux<ProductDto> getProductByStatus()
	{
	  return productService.getProductbyStatus();	
	}
	
	@PutMapping("/update-status/{id}/{status}")
	public Mono<ProductDto> updateStatus(@PathVariable("id") String id, @PathVariable("status") String status)
	{
		return productService.updateStatus(id , status);
	}
	
	@GetMapping("/show-products")
	public Flux<ProductDto> showProducts()
	{
		return productService.showProducts();
	}
	
	@GetMapping("/get-products-by-category/{category}")
	public Flux<ProductDto> getProductsByCategory(@PathVariable String category)
	{
		return productService.getProductsByCategory(category);
	}
	
	@GetMapping("/get-products-by-name-category/{search}")
	public Flux<ProductDto> getProductsByNameOrCategory(@PathVariable String search)
	{
		return productService.getProductsByNameOrCategory(search);
	}
	
}