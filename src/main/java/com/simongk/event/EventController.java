package com.simongk.event;

import com.simongk.cart.Cart;
import com.simongk.cart.CartService;
import com.simongk.user.User;
import com.simongk.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Groobaz on 2017-04-15.
 */
@Controller
public class EventController {

    private final EventService eventService;
    private final CartService cartService;
    private final UserRepository userRepository;

    @Autowired
    public EventController(EventService eventService, CartService cartService, UserRepository userRepository) {
        this.eventService = eventService;
        this.cartService = cartService;
        this.userRepository = userRepository;
    }



    @GetMapping("/mjm/wydarzenia")
    public String getAllEventsForUsersPage(Model model){
        model.addAttribute("events",eventService.getAllEvents());
        return "userEvents";
    }
    //admin
    @GetMapping("/admin/wydarzenia")
    public String getAllEvents(Model model) {
        model.addAttribute("events", eventService.getAllEvents());
        return "allEvents";
    }

    //admin
    @GetMapping("/admin/dodajWydarzenie")
    public String getEventForm(Model model) {
        model.addAttribute("event", new Event());
        return "addEvent";
    }

    //admin only
    @PostMapping("/admin/dodajWydarzenie")
    public String submitEvent(Event event) {
        eventService.addEventToDatabase(event);
        return "redirect:/admin/wydarzenia";
    }

    //all avaible
    @GetMapping("mjm/{name}")
    public String getEventByName(@PathVariable String name, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User user = userRepository.findByName(userName);
        model.addAttribute("event", eventService.getEventByName(name));
        model.addAttribute("cart", new Cart());
        model.addAttribute("cartList", user.getCarts());
        model.addAttribute("userId",user.getId());
        return "singleEvent";
    }

    //ROLE: admin
    @GetMapping("admin/{eventId}/edit")
    public String editEvent(@PathVariable Long eventId, Model model) {
        model.addAttribute("event", eventService.getEventById(eventId));
        return "events/addEvent";
    }
}
