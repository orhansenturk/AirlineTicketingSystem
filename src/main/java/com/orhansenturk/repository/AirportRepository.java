package com.orhansenturk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orhansenturk.model.Airport;

public interface AirportRepository extends JpaRepository<Airport, Long> {

	Airport findByName(String name);

}
