package com.orhansenturk.service.intf;

import java.util.List;

import com.orhansenturk.model.Ticket;

public interface ITicketService {
	Ticket createTicket(Ticket ticket);

	Ticket getTicketById(long id);

	List<Ticket> getAllTickets();

	Ticket updateTicket(Ticket ticket);

	void deleteTicket(long id);

	Ticket findByFlightId(long flightId);
}
