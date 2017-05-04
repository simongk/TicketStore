package com.simongk.cart;

import com.simongk.event.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Groobaz on 2017-05-03.
 */
@Controller
public class CartController {

    private final CartRepository cartRepository;
    private final CartService cartService;
    private final EventService eventService;
    private final DiscountService discountService;

    public CartController(CartRepository cartRepository,
                          CartService cartService, EventService eventService, DiscountService discountService) {
        this.cartRepository = cartRepository;
        this.cartService = cartService;
        this.eventService = eventService;
        this.discountService = discountService;
    }


    @GetMapping("/cart/{id}")
    public String checkCart(@PathVariable Long id, Model model){
        model.addAttribute("cart",cartRepository.findOne(id));
        return "cart/cart";
    }


    @PostMapping("/events/{name}/buy")
    public String submitTicketPurchase(@ModelAttribute Cart cart,
                                       @PathVariable String name) {
        cartService.addCartToDatabase(cart, name);
        eventService.updateTicketQuantity(cart, cart.getEvent());
        return "redirect:/paymentData/" + cart.getId();
    }





}
