package com.orhansenturk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.orhansenturk.model.Ticket;
import com.orhansenturk.service.TicketService;

@RestController
public class TicketController {

	@Autowired
	private TicketService ticketService;

	@GetMapping("/tickets")
	public ResponseEntity<List<Ticket>> getAllTickets() {
		return ResponseEntity.ok(ticketService.getAllTickets());
	}

	@GetMapping("/tickets/{id}")
	public ResponseEntity<Ticket> getTicketById(@PathVariable long id) {
		return ResponseEntity.ok(ticketService.getTicketById(id));
	}

	@PostMapping("/tickets")
	public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
		return ResponseEntity.ok(ticketService.createTicket(ticket));
	}

	@PutMapping("/tickets")
	public ResponseEntity<Ticket> updateTicket(@RequestBody Ticket ticket) {
		return ResponseEntity.ok(ticketService.updateTicket(ticket));
	}

	@DeleteMapping("tickets/{id}")
	public String deleteTicket(@PathVariable long id) {
		ticketService.deleteTicket(id);
		return "Delete operation successfully completed";
	}
}
