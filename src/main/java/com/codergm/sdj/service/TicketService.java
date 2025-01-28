package com.codergm.sdj.service;

import com.codergm.sdj.entity.Ticket;
import com.codergm.sdj.repository.TicketRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;

    @Transactional
    public void bookTicket(Ticket ticket) {
        ticketRepository.save(ticket);
        throw new RuntimeException("payment failed!");
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public void doSomethingTask() throws InterruptedException {
        Thread.sleep(40000);
        ticketRepository.findById(1L);
        Thread.sleep(40000);

    }
}
