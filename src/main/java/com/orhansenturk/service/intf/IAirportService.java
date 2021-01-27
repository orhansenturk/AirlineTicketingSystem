package com.orhansenturk.service.intf;

import java.util.List;

import com.orhansenturk.model.Airport;

public interface IAirportService {
	Airport createAirport(Airport airport);

	List<Airport> getAllAirports();

	Airport getAirportById(long id);

	Airport getAirportByName(String name);
}
