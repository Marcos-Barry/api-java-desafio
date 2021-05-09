package com.br.apiudemy.udemy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/ola")
@RestController
public class PrimeiroController {

	@GetMapping(path = {"/", "/ola"})
	public String ola() {
		return "Olá SpringBoot";
	}
}
