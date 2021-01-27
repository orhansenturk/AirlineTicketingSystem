package com.orhansenturk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.orhansenturk.model.AirlineCompany;
import com.orhansenturk.service.AirlineCompanyService;

@RestController
public class AirlineCompanyController {

	@Autowired
	private AirlineCompanyService airlineCompanyService;

	@GetMapping("/airlinecompanies")
	public ResponseEntity<List<AirlineCompany>> getAllAirlineCompanies() {
		return ResponseEntity.ok(airlineCompanyService.getAllAirlineCompanies());
	}

//	@GetMapping("/airlinecompanies/{id}")
//	public ResponseEntity<AirlineCompany> getAirlineCompanyById(@PathVariable long id) {
//		return ResponseEntity.ok(airlineCompanyService.getAirlineCompanyById(id));
//	}

	@GetMapping("/airlinecompanies/{name}")
	public ResponseEntity<AirlineCompany> getAirlineCompanyByName(@PathVariable String name) {
		return ResponseEntity.ok(airlineCompanyService.getAirlineCompanyByName(name));
	}

	@PostMapping("/airlinecompanies")
	public ResponseEntity<AirlineCompany> createAirlineCompany(@RequestBody AirlineCompany airlineCompany) {
		return ResponseEntity.ok(airlineCompanyService.createAirlineCompany(airlineCompany));
	}
}
