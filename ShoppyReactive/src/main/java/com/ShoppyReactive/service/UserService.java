package com.ShoppyReactive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ShoppyReactive.dto.UserDto;
import com.ShoppyReactive.repo.UserRepo;
import com.ShoppyReactive.userAuthentication.UserAuthentication;
import com.ShoppyReactive.utils.UserUtils;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	public Mono<UserDto> getUser(String id)
	{
		return userRepo.findById(id).map(UserUtils::entityToDto);
	}
	
	public Flux<UserDto> getUsers()
	{
		return userRepo.findAll().map(UserUtils::entityToDto);
	}
	
	public Mono<UserDto> saveUser(Mono<UserDto> userDto)
	{
		return userDto.map(UserUtils::dtoToEntity)
				          .flatMap(userRepo::insert)
				          .map(UserUtils::entityToDto);
	}
	
	public Mono<UserDto> updateUser(Mono<UserDto> userDto , String id)
	{
		 return userRepo.findById(id)
				            .flatMap(p->userDto.map(UserUtils::dtoToEntity)
				            .doOnNext(e->e.setId(id)))
				            .flatMap(userRepo::save)
				            .map(UserUtils::entityToDto);
	}
	
	public Mono<UserDto> deleteUser(String id)
	{
		return userRepo.findById(id)
				           .flatMap(existingUser -> userRepo
				           .delete(existingUser)
				           .then(Mono.just(existingUser)))
				           .map(UserUtils::entityToDto);
	}

	public Mono<UserDto> userAuthentication(UserAuthentication userAuthentication) {
		
		Mono<UserDto> userDto= userRepo.findByEmailAndPassword(userAuthentication.getEmail(), 
				                               userAuthentication.getPassword())
				       .map(UserUtils::entityToDto);
		System.out.println(userDto);
		return userDto;
	}
}
