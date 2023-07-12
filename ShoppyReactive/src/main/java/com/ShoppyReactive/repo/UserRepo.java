package com.ShoppyReactive.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.ShoppyReactive.entities.User;

import reactor.core.publisher.Mono;

@Repository
public interface UserRepo extends ReactiveMongoRepository<User, String> {
	
	Mono<User> findByEmailAndPassword(String email,String password);

}
