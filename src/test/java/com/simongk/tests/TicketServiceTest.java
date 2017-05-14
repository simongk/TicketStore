package com.simongk.tests;

import com.simongk.cart.Cart;
import com.simongk.event.Event;
import com.simongk.ticket.Ticket;
import com.simongk.ticket.TicketService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by szymon on 14.05.17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TicketServiceTest {

    @Autowired
    private TicketService service;

    @Test
    public void ticketShouldBeAddedToCart(){
        //given
        Event event = new Event();
        Cart cart = new Cart();
        Ticket ulgowy = new Ticket();
        Ticket normalny = new Ticket();
        event.setPrice(100);
        cart.setEvent(event);
        ulgowy.setType("Ulgowy");
        ulgowy.setQuantity(2);
        normalny.setType("Normalny");
        normalny.setQuantity(1);
        double price = cart.getEvent().getPrice();
        List<Ticket> ticketList = new ArrayList<>(2);
        ticketList.add(ulgowy);
        ticketList.add(normalny);

        //when
        double totalCost = service.getTotalCost(price, ticketList);

        //then
        Assert.assertEquals((int) totalCost, 260);


    }



}
