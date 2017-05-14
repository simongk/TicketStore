package com.simongk.cart;

import com.simongk.event.Event;
import com.simongk.event.EventService;
import com.simongk.ticket.TicketService;
import org.springframework.stereotype.Service;

/**
 * Created by Groobaz on 2017-05-04.
 */
@Service
public class CartService {

    private final EventService eventService;
    private final CartRepository cartRepository;
    private final DiscountService discountService;
    private final TicketService ticketService;


    public CartService(EventService eventService, CartRepository cartRepository,
                       DiscountService discountService, TicketService ticketService) {
        this.eventService = eventService;
        this.cartRepository = cartRepository;
        this.discountService = discountService;
        this.ticketService = ticketService;
    }


    public void addCartToDatabase(Cart cart, String eventName) {
        cart.setEvent(eventService.getEventByName(eventName));
        cart.setTotalCost((int) calculateFinalPrice(cart));
        cartRepository.save(cart);
    }

    private double calculateFinalPrice(Cart cart) {
        double totalCost = ticketService.getTotalCost(cart.getEvent().getPrice(), cart.getTickets());
        return discountService.calculateCodeDiscount(totalCost, cart.getDiscountCode());
    }


}
