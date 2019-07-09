package com.tyn.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyn.boot.service.TynUserService;

@RestController
public class TynController {
	
	@Autowired
	TynUserService service;
	
	@GetMapping("/hello")
	public String hello() {
		
		return "hello"+service.getName();
	}
	

}
