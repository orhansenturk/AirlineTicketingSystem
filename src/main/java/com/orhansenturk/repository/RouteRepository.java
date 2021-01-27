package com.orhansenturk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orhansenturk.model.Route;

public interface RouteRepository extends JpaRepository<Route, Long> {

	Route findByName(String name);

}
