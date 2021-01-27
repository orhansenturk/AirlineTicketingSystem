package com.orhansenturk.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orhansenturk.exception.ResourceNotFoundException;
import com.orhansenturk.model.AirlineCompany;
import com.orhansenturk.model.Airport;
import com.orhansenturk.model.Route;
import com.orhansenturk.repository.AirlineCompanyRepository;
import com.orhansenturk.repository.AirportRepository;
import com.orhansenturk.repository.RouteRepository;
import com.orhansenturk.service.intf.IRouteService;

@Service
@org.springframework.transaction.annotation.Transactional
public class RouteService implements IRouteService {

	@Autowired
	RouteRepository routeRepository;

	@Autowired
	AirportRepository airportRepository;

	@Autowired
	AirlineCompanyRepository airlineCompanyRepository;

	@Override
	public Route createRoute(Route route) {
		Optional<Airport> departureAirport = airportRepository.findById(route.getDepartureAirportId());
		Optional<Airport> destinationAirport = airportRepository.findById(route.getDestinationAirportId());

		if (!departureAirport.isPresent() || !destinationAirport.isPresent()) {
			throw new ResourceNotFoundException("Departure or Destination Airport could not be found");
		}

		Optional<AirlineCompany> airlineCompany = airlineCompanyRepository.findById(route.getAirlineCompanyId());

		if (!airlineCompany.isPresent()) {
			throw new ResourceNotFoundException("Airline Company could not be found");
		}

		return routeRepository.save(route);
	}

	@Override
	public List<Route> getAllRoutes() {
		return routeRepository.findAll();
	}

	@Override
	public Route getRouteById(long routeId) {
		Optional<Route> route = routeRepository.findById(routeId);

		if (route.isPresent()) {
			return route.get();
		} else {
			throw new ResourceNotFoundException("Record not found with id:" + routeId);
		}
	}

	@Override
	public Route getRouteByName(String name) {
		Route route = routeRepository.findByName(name);

		if (route != null) {
			return route;
		} else {
			throw new ResourceNotFoundException("Record not found with id:" + name);
		}

	}

}
