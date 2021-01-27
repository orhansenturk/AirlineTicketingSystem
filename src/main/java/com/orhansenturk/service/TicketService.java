package com.orhansenturk.service;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orhansenturk.exception.ResourceNotFoundException;
import com.orhansenturk.model.Flight;
import com.orhansenturk.model.Ticket;
import com.orhansenturk.repository.FlightRepository;
import com.orhansenturk.repository.TicketRepository;
import com.orhansenturk.service.intf.ITicketService;

@Service
@org.springframework.transaction.annotation.Transactional
public class TicketService implements ITicketService {

	@Autowired
	TicketRepository ticketRepository;

	@Autowired
	FlightRepository flightRepository;

	@Override
	public Ticket createTicket(Ticket ticket) {
		Optional<Flight> flight = flightRepository.findById(ticket.getFlightId());

		if (!flight.isPresent()) {
			throw new ResourceNotFoundException("Flight could not be found");
		}

		ticket.setCreditCardInformation(maskCreditCardInformation(ticket.getCreditCardInformation()));

		return ticketRepository.save(ticket);

	}

	private String maskCreditCardInformation(String strText) {
		strText = strText.replaceAll("[^0-9]", "");
		String strMaskString = StringUtils.repeat('*', 6);
		return StringUtils.overlay(strText, strMaskString, 6, 12);
	}

	@Override
	public Ticket getTicketById(long id) {
		Optional<Ticket> ticket = ticketRepository.findById(id);

		if (ticket.isPresent()) {
			return ticket.get();
		} else {
			throw new ResourceNotFoundException("Record not found with id:" + id);
		}
	}

	@Override
	public List<Ticket> getAllTickets() {
		return ticketRepository.findAll();
	}

	@Override
	public Ticket updateTicket(Ticket ticket) {
		Optional<Ticket> ticketInfo = ticketRepository.findById(ticket.getId());

		if (!ticketInfo.isPresent()) {
			throw new ResourceNotFoundException("Airline company could not be found");
		} else {
			Ticket newTicket = ticketInfo.get();
			newTicket.setId(ticket.getId());
			newTicket.setTicketPrice(ticket.getTicketPrice());
			ticketRepository.save(newTicket);
			return newTicket;
		}

	}

	@Override
	public Ticket findByFlightId(long flightId) {
		return ticketRepository.findByFlightId(flightId);
	}

	@Override
	public void deleteTicket(long id) {
		ticketRepository.deleteById(id);
	}

}
