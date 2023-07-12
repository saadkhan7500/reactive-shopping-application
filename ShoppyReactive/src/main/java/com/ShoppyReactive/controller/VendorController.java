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


import com.ShoppyReactive.dto.VendorDto;
import com.ShoppyReactive.service.VendorService;
import com.ShoppyReactive.userAuthentication.UserAuthentication;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/vendor")
@CrossOrigin
public class VendorController {

	@Autowired
	private VendorService vendorService;
	
	
	@GetMapping("/getVendor/{id}")
	public Mono<VendorDto> getVendor(@PathVariable String id)
	{
		return vendorService.getVendor(id);
	}
	
	
	@GetMapping("/getVendors")
	public Flux<VendorDto> getVendors()
	{
		return vendorService.getVendors();
	}
	
	@PostMapping("/saveVendor")
	public Mono<VendorDto> saveVendor(@RequestBody Mono<VendorDto> userDto)
	{
		return vendorService.saveVendor(userDto);
	}
	
	@PutMapping("/updateVendor/{id}")
	public Mono<VendorDto> updateVendor(@RequestBody Mono<VendorDto> userDto , @PathVariable String id)
	{
		return vendorService.updateVendor(userDto,id);
	}
	
	@DeleteMapping("/deleteVendor/{id}")
	public Mono<VendorDto> deleteVendor(@PathVariable String id)
	{
		return vendorService.deleteVendor(id);
	}
	
	@PostMapping("/checkVendor")
	public Mono<VendorDto> checkVendor(@RequestBody UserAuthentication userAuthentication)
	{
		return vendorService.userAuthentication(userAuthentication);
	}
}