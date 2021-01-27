package com.orhansenturk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.orhansenturk.model.Airport;
import com.orhansenturk.service.AirportService;

@RestController
public class AirportController {

	@Autowired
	private AirportService airportService;

	@GetMapping("/airports")
	public ResponseEntity<List<Airport>> getAllAirports() {
		return ResponseEntity.ok(airportService.getAllAirports());
	}

//	@GetMapping("/airports/{id}")
//	public ResponseEntity<Airport> getAirportById(@PathVariable long id) {
//		return ResponseEntity.ok(airportService.getAirportById(id));
//	}

	@GetMapping("/airports/{name}")
	public ResponseEntity<Airport> getAirportByName(@PathVariable String name) {
		return ResponseEntity.ok(airportService.getAirportByName(name));
	}

	@PostMapping("/airports")
	public ResponseEntity<Airport> createAirport(@RequestBody Airport airport) {
		return ResponseEntity.ok(airportService.createAirport(airport));
	}
}
