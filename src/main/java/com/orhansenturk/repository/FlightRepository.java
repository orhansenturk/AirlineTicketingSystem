package com.orhansenturk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orhansenturk.model.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

}
