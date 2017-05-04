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

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void updateTicketQuantity(Cart cart, Event event) {
        if (event.getTickets() < cart.getTicketQuantity()) {
            cart.setTicketQuantity(event.getTickets());
        }
        event.setTickets(event.getTickets() - cart.getTicketQuantity());
        addEventToDatabase(event);
    }
    public Event getEventByName(String name) {
        return eventRepository.findByName(name);
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
