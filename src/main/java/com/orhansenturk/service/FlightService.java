package com.orhansenturk.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orhansenturk.exception.ResourceNotFoundException;
import com.orhansenturk.model.AirlineCompany;
import com.orhansenturk.model.Flight;
import com.orhansenturk.model.Route;
import com.orhansenturk.model.Ticket;
import com.orhansenturk.repository.AirlineCompanyRepository;
import com.orhansenturk.repository.FlightRepository;
import com.orhansenturk.repository.RouteRepository;
import com.orhansenturk.repository.TicketRepository;
import com.orhansenturk.service.intf.IFlightService;

@Service
@org.springframework.transaction.annotation.Transactional
public class FlightService implements IFlightService {

	@Autowired
	FlightRepository flightRepository;

	@Autowired
	AirlineCompanyRepository airlineCompanyRepository;

	@Autowired
	RouteRepository routeRepository;

	@Autowired
	TicketRepository ticketRepository;

	@Autowired
	TicketService ticketService;

	@Override
	public Flight createFlight(Flight flight) {

		Optional<AirlineCompany> airlineCompany = airlineCompanyRepository.findById(flight.getAirlineCompanyId());

		if (!airlineCompany.isPresent()) {
			throw new ResourceNotFoundException("Airline company could not be found");
		}

		Optional<Route> route = routeRepository.findById(flight.getRouteId());

		if (!route.isPresent()) {
			throw new ResourceNotFoundException("Route could not be found");
		}

		return flightRepository.save(flight);

	}

	@Override
	public Flight getFlightById(long id) {
		Optional<Flight> flight = flightRepository.findById(id);

		if (flight.isPresent()) {
			return flight.get();
		} else {
			throw new ResourceNotFoundException("Record not found with id:" + id);
		}
	}

	@Override
	public List<Flight> getAllFlights() {
		return flightRepository.findAll();
	}

	@Override
	public Flight updateFlight(Flight flight) {
		// TODO: Quota %10 artarsa ticket price -> %10 artar
		Optional<Flight> flightInfo = flightRepository.findById(flight.getId());
		Flight newFlight = flightInfo.get();
		if (!flightInfo.isPresent()) {
			throw new ResourceNotFoundException("Airline company could not be found");
		} else {

			int oldQuota = newFlight.getQuota();

			newFlight.setId(flight.getId());
			newFlight.setQuota(flight.getQuota());
			flightRepository.save(newFlight);

			if (oldQuota < newFlight.getQuota() && Math.round(oldQuota / (newFlight.getQuota() - oldQuota)) == 10) {
				updateTicketPrice(flight.getId());
			}
		}

		return newFlight;

	}

	private void updateTicketPrice(long flightId) {

		Ticket ticket = ticketService.findByFlightId(flightId);
		if (ticket != null) {
			ticket.setTicketPrice(ticket.getTicketPrice().multiply(new BigDecimal(1.1)));
			ticketService.updateTicket(ticket);
		}
	}

}
