package com.greatlearning.tickettracker.service;

import com.greatlearning.tickettracker.entity.Ticket;

import java.util.List;

public interface ITicketService {

    List<Ticket> getAllTickets();

    Ticket saveTicket(Ticket ticket);

    Ticket getTicketById(long id);

    Ticket updateTicket(Ticket ticket);

    void deleteTicketById(long id);

    List<Ticket> searchByTitle(String keyword);
}
