package com.greatlearning.tickettracker.repository;

import com.greatlearning.tickettracker.entity.Ticket;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findByTitleContaining(String keyword);
}

