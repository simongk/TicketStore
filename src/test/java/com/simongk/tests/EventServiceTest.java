package com.simongk.tests;

import com.simongk.cart.Cart;
import com.simongk.event.Event;
import com.simongk.event.EventService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Groobaz on 2017-04-25.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EventServiceTest {

    @Autowired
    private EventService eventService;

    private Cart cart;
    private Event event;

    @Before
    public void setup(){
        cart = new Cart();
        event = new Event();
    }

    @Test
    public void ticketQuantityShouldNotExceedLimit(){
        //given
        cart.setTicketQuantity(30);
        event.setTickets(20);

        //when
        eventService.updateTicketQuantity(cart,event);

        //then
        Assert.assertEquals(cart.getTicketQuantity(), 20);
    }


}
