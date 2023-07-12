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

import com.ShoppyReactive.dto.UserDto;
import com.ShoppyReactive.service.UserService;
import com.ShoppyReactive.userAuthentication.UserAuthentication;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@GetMapping("/getUser/{id}")
	public Mono<UserDto> getUser(@PathVariable String id)
	{
		return userService.getUser(id);
	}
	
	
	@GetMapping("/getUsers")
	public Flux<UserDto> getUsers()
	{
		return userService.getUsers();
	}
	
	@PostMapping("/saveUser")
	public Mono<UserDto> saveUser(@RequestBody Mono<UserDto> userDto)
	{
		return userService.saveUser(userDto);
	}
	
	@PutMapping("/updateUser/{id}")
	public Mono<UserDto> updateUser(@RequestBody Mono<UserDto> userDto , @PathVariable String id)
	{
		return userService.updateUser(userDto,id);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public Mono<UserDto> deleteUser(@PathVariable String id)
	{
		return userService.deleteUser(id);
	}
	
	@PostMapping("/checkUser")
	public Mono<UserDto> checkUser(@RequestBody UserAuthentication userAuthentication)
	{
		return userService.userAuthentication(userAuthentication);
	}
}