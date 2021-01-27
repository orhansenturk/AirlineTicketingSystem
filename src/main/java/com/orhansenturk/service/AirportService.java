package com.orhansenturk.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orhansenturk.exception.ResourceNotFoundException;
import com.orhansenturk.model.Airport;
import com.orhansenturk.repository.AirportRepository;
import com.orhansenturk.service.intf.IAirportService;

@Service
@org.springframework.transaction.annotation.Transactional
public class AirportService implements IAirportService {

	@Autowired
	AirportRepository airportRepository;

	@Override
	public Airport createAirport(Airport airport) {
		return airportRepository.save(airport);
	}

	@Override
	public List<Airport> getAllAirports() {
		return airportRepository.findAll();
	}

	@Override
	public Airport getAirportById(long airportId) {
		Optional<Airport> airport = airportRepository.findById(airportId);

		if (airport.isPresent()) {
			return airport.get();
		} else {
			throw new ResourceNotFoundException("Record not found with id:" + airportId);
		}
	}

	@Override
	public Airport getAirportByName(String name) {
		Airport airport = airportRepository.findByName(name);

		if (airport != null) {
			return airport;
		} else {
			throw new ResourceNotFoundException("Record not found with id:" + name);
		}

	}

}
