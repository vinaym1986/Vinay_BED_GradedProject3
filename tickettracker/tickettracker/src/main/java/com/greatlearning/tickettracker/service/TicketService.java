package com.greatlearning.tickettracker.service;

import com.greatlearning.tickettracker.entity.Ticket;
import com.greatlearning.tickettracker.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService implements  ITicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket saveTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket getTicketById(long id) {
        return ticketRepository.findById(id).get();
    }

    @Override
    public Ticket updateTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public void deleteTicketById(long id) {
        ticketRepository.deleteById(id);
    }

    @Override
    public List<Ticket> searchByTitle(String keyword) {
        return ticketRepository.findByTitleContaining(keyword);
    }
}
