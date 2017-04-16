package com.simongk.event;

import com.simongk.cart.Cart;
import com.simongk.cart.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

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

    Event getEventByName(@PathVariable String name) {
        return eventRepository.findByName(name);
    }

    void updateTicketQuantity(Cart cart, Event event) {
        event.setTickets(event.getTickets() - cart.getTicketQuantity());
        addEventToDatabase(event);
    }

    List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    void addEventToDatabase(@ModelAttribute Event event) {
        eventRepository.save(event);
    }

}
