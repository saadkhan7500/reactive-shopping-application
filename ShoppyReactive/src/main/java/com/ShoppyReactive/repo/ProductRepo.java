package com.ShoppyReactive.repo;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.ShoppyReactive.entities.Product;

import reactor.core.publisher.Flux;


@Repository
public interface ProductRepo extends ReactiveMongoRepository<Product, String> {

    @Query("{ 'status' : 'added' }")
    Flux<Product> findAllByStatusAdded();
    
    @Query("{ 'status' : 'accept' }")
    Flux<Product> findAllByStatusAccept();
    
    Flux<Product> getProductsByCategory(String category);
    
    Flux<Product> getProductsByNameOrCategory(String name,String category);
 
}
