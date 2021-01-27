package com.orhansenturk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orhansenturk.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

	Ticket findByFlightId(long flightId);

}
