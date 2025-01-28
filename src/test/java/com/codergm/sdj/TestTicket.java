package com.codergm.sdj;

import com.codergm.sdj.entity.Ticket;
import com.codergm.sdj.service.TicketService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TestTicket {

    @Autowired
    private TicketService ticketService;

    @Test
    void test_create_ticket_transaction_failed(){
        List<Ticket> ticketsBefore = ticketService.getAllTickets();
        Ticket ticket = new Ticket("Bus stop 1",
                "Bus stop 2",
                LocalDateTime.of(2024, Month.MAY,03,14,00));
        try {
            ticketService.bookTicket(ticket);
        }catch (Exception e){
            e.printStackTrace();
        }
        List<Ticket> ticketsAfter = ticketService.getAllTickets();
        assertThat(ticketsAfter.size()).isEqualTo(ticketsBefore.size());
    }

    @Test
    void test_connection_acquisition_delay() throws InterruptedException {
        ticketService.doSomethingTask();
        Thread.sleep(40000);
    }
}
