package com.simongk.event;

import com.simongk.cart.Cart;
import com.simongk.cart.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Groobaz on 2017-04-16.
 */
@Service
public class EventService {

    private final CartRepository cartRepository;
    private final EventRepository eventRepository;

    @Autowired
    public EventService(CartRepository cartRepository, EventRepository eventRepository) {
        this.cartRepository = cartRepository;
        this.eventRepository = eventRepository;
    }

    void addCartToDatabase(Cart cart, String eventName) {
        Event event = getEventByName(eventName);
        cart.setEvent(event);
        cart.setTotalCost(cart.getTicketQuantity() * event.getPrice());
        cartRepository.save(cart);
    }

    Event getEventByName(String name) {
        return eventRepository.findByName(name);
    }

    void updateTicketQuantity(Cart cart, Event event) {
        if(event.getTickets() < cart.getTicketQuantity()) {
            cart.setTicketQuantity(event.getTickets());
        }
        event.setTickets(event.getTickets() - cart.getTicketQuantity());
        addEventToDatabase(event);
    }

    List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    void addEventToDatabase(Event event) {
        eventRepository.save(event);
    }

}
