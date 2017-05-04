package com.simongk.cart;

import com.simongk.event.Event;
import com.simongk.event.EventService;
import org.springframework.stereotype.Service;

/**
 * Created by Groobaz on 2017-05-04.
 */
@Service
public class CartService {

    private final EventService eventService;
    private final CartRepository cartRepository;
    private final DiscountService discountService;


    public CartService(EventService eventService, CartRepository cartRepository, DiscountService discountService) {
        this.eventService = eventService;
        this.cartRepository = cartRepository;
        this.discountService = discountService;
    }


    public void addCartToDatabase(Cart cart, String eventName) {
        Event event = eventService.getEventByName(eventName);
        cart.setEvent(event);
        setActualTicketCost(cart, event.getPrice());
        cartRepository.save(cart);
    }

    private void setActualTicketCost(Cart cart, double price) {
        double priceAfterTypeDiscount =
                discountService.calculateTicketTypeDiscount(price, cart.getTicketType());
        double finalPrice = discountService.calculateCodeDiscount(priceAfterTypeDiscount, cart.getDiscountCode());
        cart.setTotalCost((int) (cart.getTicketQuantity() * finalPrice));
    }

}
