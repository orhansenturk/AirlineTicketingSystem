package com.orhansenturk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.orhansenturk.model.Route;
import com.orhansenturk.service.RouteService;

@RestController
public class RouteController {

	@Autowired
	private RouteService routeService;

	@GetMapping("/routes")
	public ResponseEntity<List<Route>> getAllRoutes() {
		return ResponseEntity.ok(routeService.getAllRoutes());
	}

//	@GetMapping("/routes/{id}")
//	public ResponseEntity<Route> getRouteById(@PathVariable long id) {
//		return ResponseEntity.ok(routeService.getRouteById(id));
//	}

	@GetMapping("/routes/{name}")
	public ResponseEntity<Route> getRouteByName(@PathVariable String name) {
		return ResponseEntity.ok(routeService.getRouteByName(name));
	}

	@PostMapping("/routes")
	public ResponseEntity<Route> createRoute(@RequestBody Route route) {
		return ResponseEntity.ok(routeService.createRoute(route));
	}

}
