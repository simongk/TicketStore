package com.simongk.pastEvent;

import com.simongk.event.Event;
import com.simongk.event.EventRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;

/**
 * Created by Szymon Gasienica-Kotelnicki on 23.05.17.
 */
@Controller
public class PastEventController {
    private final EventRepository eventRepository;
    private final PastEventRepository pastEventRepository;

    public PastEventController(EventRepository eventRepository, PastEventRepository pastEventRepository) {
        this.eventRepository = eventRepository;
        this.pastEventRepository = pastEventRepository;
    }

    //admin
    @GetMapping("admin/setToPast/{eventId}")
    public String setEventAsPast(@PathVariable Long eventId){
        Event event = eventRepository.findOne(eventId);
        PastEvent pastEvent = new PastEvent();
        pastEvent.setName(event.getName());
        pastEvent.setEventPrice(new BigDecimal(event.getPrice()));
        pastEvent.setLocation(event.getLocation());
        pastEvent.setSoldTickets(event.getSoldTickets());
        pastEvent.setTotalCash(pastEvent.getEventPrice().multiply(BigDecimal.valueOf(pastEvent.getSoldTickets())));
        pastEventRepository.save(pastEvent);
        eventRepository.delete(event);
        return "redirect:/admin/allEvents";
    }

    //admin
    @GetMapping("admin/allPastEvents")
    public String getAllPastEvents(Model model){
        model.addAttribute("pastEvents", pastEventRepository.findAll());
        return "admin/pastEvent";
    }




}
