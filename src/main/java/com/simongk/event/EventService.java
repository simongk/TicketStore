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
        calculateDiscount(event, cart.getTicketType());
        cart.setTotalCost(cart.getTicketQuantity() * event.getPrice());
        cartRepository.save(cart);
        System.out.println(cart.getId());
    }

    Event getEventByName(String name) {
        return eventRepository.findByName(name);
    }

    void updateTicketQuantity(Cart cart, Event event) {
        if (event.getTickets() < cart.getTicketQuantity()) {
            cart.setTicketQuantity(event.getTickets());
        }
        event.setTickets(event.getTickets() - cart.getTicketQuantity());
        addEventToDatabase(event);
    }

    public void calculateDiscount(Event event, String ticketType){
        if (ticketType.equals("Ulgowy")) {
            event.setPrice((int) (event.getPrice()*0.8));
            System.out.println("nowa suma");
        } else {
            event.setPrice(event.getPrice());
        }
    }


    List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public void addEventToDatabase(Event event) {
        eventRepository.save(event);
    }

    Event getEventById(Long id) {
        return eventRepository.findOne(id);
    }


}
