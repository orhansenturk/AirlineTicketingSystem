package com.orhansenturk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.orhansenturk.model.Flight;
import com.orhansenturk.service.FlightService;

@RestController
public class FlightController {

	@Autowired
	private FlightService flightService;

	@GetMapping("/flights")
	public ResponseEntity<List<Flight>> getAllFlights() {
		return ResponseEntity.ok(flightService.getAllFlights());
	}

	@GetMapping("/flights/{id}")
	public ResponseEntity<Flight> getFlightById(@PathVariable long id) {
		return ResponseEntity.ok(flightService.getFlightById(id));
	}

	@PostMapping("/flights")
	public ResponseEntity<Flight> createFlight(@RequestBody Flight flight) {
		return ResponseEntity.ok(flightService.createFlight(flight));
	}

	@PutMapping("/flights/{id}")
	public ResponseEntity<Flight> updateFlight(@PathVariable long id, @RequestBody Flight flight) {
		flight.setId(id);
		return ResponseEntity.ok(flightService.updateFlight(flight));
	}
}
