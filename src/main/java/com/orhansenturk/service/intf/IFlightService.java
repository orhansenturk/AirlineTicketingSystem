package com.orhansenturk.service.intf;

import java.util.List;

import com.orhansenturk.model.Flight;

public interface IFlightService {

	Flight createFlight(Flight flight);

	Flight getFlightById(long id);

	List<Flight> getAllFlights();

	Flight updateFlight(Flight flight);
}
