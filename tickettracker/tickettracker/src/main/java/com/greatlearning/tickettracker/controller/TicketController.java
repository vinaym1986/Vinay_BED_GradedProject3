package com.greatlearning.tickettracker.controller;

import com.greatlearning.tickettracker.entity.Ticket;
import com.greatlearning.tickettracker.repository.TicketRepository;
import com.greatlearning.tickettracker.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/list")
    public String listTickets(Model model) {
        List<Ticket> tickets = ticketService.getAllTickets();
        model.addAttribute("tickets", tickets);
        return "list-tickets";
    }

    @GetMapping("/edit/{id}")
    public String editTicket(@PathVariable long id, Model model) {
        Ticket ticket = ticketService.getTicketById(id);
        model.addAttribute("ticket", ticket);
        return "edit-tickets";
    }

    @GetMapping("/create-ticket")
    public String ShowNewTicketForm(Model model) {
        Ticket ticket = new Ticket();
        model.addAttribute("ticket", ticket);
        return "create-ticket";
    }

    @PostMapping("/save")
    public String saveTicket(@ModelAttribute("ticket") Ticket ticket) {
        ticketService.saveTicket(ticket);
        return "redirect:/tickets/list";
    }

    @PostMapping("/update/{id}")
    public String UpdateTicket(@PathVariable long id, @ModelAttribute("ticket") Ticket updatedTicket) {
        Ticket ticket = ticketService.getTicketById(id);
        ticket.setDescription(updatedTicket.getDescription());
        ticket.setContent(updatedTicket.getContent());
        ticket.setTitle(updatedTicket.getTitle());
        ticketService.updateTicket(ticket);
        return "redirect:/tickets/list";
    }


    @GetMapping("/delete/{id}")
    public String deleteTicket(@PathVariable int id) {
        ticketService.deleteTicketById(id);
        return "redirect:/tickets/list";
    }

    @GetMapping("/search")
    public String searchTickets(@RequestParam String keyword, Model model) {
        List<Ticket> tickets = ticketService.searchByTitle(keyword);
        model.addAttribute("tickets", tickets);
        return "list-tickets";
    }

}

