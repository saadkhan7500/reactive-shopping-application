package com.ShoppyReactive.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;


import com.ShoppyReactive.entities.Vendor;

import reactor.core.publisher.Mono;

@Repository
public interface VendorRepo extends ReactiveMongoRepository<Vendor, String> {
	
	Mono<Vendor> findByEmailAndPassword(String email,String password);

}
