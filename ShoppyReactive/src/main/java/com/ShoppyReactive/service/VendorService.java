package com.ShoppyReactive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ShoppyReactive.dto.VendorDto;
import com.ShoppyReactive.repo.VendorRepo;
import com.ShoppyReactive.userAuthentication.UserAuthentication;
import com.ShoppyReactive.utils.VendorUtils;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class VendorService {

	@Autowired
	private VendorRepo vendorRepo;
	
	public Mono<VendorDto> getVendor(String id)
	{
		return vendorRepo.findById(id).map(VendorUtils::entityToDto);
	}
	
	public Flux<VendorDto> getVendors()
	{
		return vendorRepo.findAll().map(VendorUtils::entityToDto);
	}
	
	public Mono<VendorDto> saveVendor(Mono<VendorDto> vendorDto)
	{
		return vendorDto.map(VendorUtils::dtoToEntity)
				          .flatMap(vendorRepo::insert)
				          .map(VendorUtils::entityToDto);
	}
	
	public Mono<VendorDto> updateVendor(Mono<VendorDto> vendorDto , String id)
	{
		 return vendorRepo.findById(id)
				            .flatMap(p->vendorDto.map(VendorUtils::dtoToEntity)
				            .doOnNext(e->e.setId(id)))
				            .flatMap(vendorRepo::save)
				            .map(VendorUtils::entityToDto);
	}
	
	public Mono<VendorDto> deleteVendor(String id)
	{
		return vendorRepo.findById(id)
				           .flatMap(existingUser -> vendorRepo
				           .delete(existingUser)
				           .then(Mono.just(existingUser)))
				           .map(VendorUtils::entityToDto);
	}

	public Mono<VendorDto> userAuthentication(UserAuthentication userAuthentication) {
		
		Mono<VendorDto> vendorDto= vendorRepo.findByEmailAndPassword(userAuthentication.getEmail(), 
				                               userAuthentication.getPassword())
				       .map(VendorUtils::entityToDto);
		System.out.println(vendorDto);
		return vendorDto;
	}
}
