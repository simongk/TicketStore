package com.simongk.event;

import com.simongk.cart.Cart;
import org.junit.Assert;
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

    @Test
    public void ticketQuantityShouldNotExceedLimit(){
        //given
        Cart cart = new Cart();
        Event event = new Event();

        cart.setTicketQuantity(30);
        event.setTickets(20);

        //when
        eventService.updateTicketQuantity(cart,event);

        //then
        Assert.assertEquals(cart.getTicketQuantity(), 20);
    }


}
