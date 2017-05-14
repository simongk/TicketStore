package com.simongk.event;

import com.simongk.cart.Cart;
import com.simongk.cart.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Created by Groobaz on 2017-04-15.
 */
@Controller
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/all")
    public String getAllEvents(Model model) {
        model.addAttribute("events", eventService.getAllEvents());
        return "events/allEvents";
    }

    @GetMapping("/add")
    public String getEventForm(Model model) {
        model.addAttribute("event", new Event());
        return "events/addEvent";
    }

    @PostMapping("/add")
    public String submitEvent(Event event) {
        eventService.addEventToDatabase(event);
        return "redirect:/events/all";
    }

    @GetMapping("/{name}")
    public String getEventByName(@PathVariable String name, Model model) {
        model.addAttribute("event", eventService.getEventByName(name));
        model.addAttribute("cart", new Cart(new ArrayList<>(2)));
        return "events/event";
    }

    @GetMapping("/{id}/edit")
    public String editEvent(@PathVariable Long id, Model model) {
        model.addAttribute("event", eventService.getEventById(id));
        return "events/addEvent";
    }
}
