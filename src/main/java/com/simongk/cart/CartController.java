package com.simongk.cart;

import com.simongk.event.EventService;
import com.simongk.order.Order;
import com.simongk.order.OrderService;
import com.simongk.user.User;
import com.simongk.user.UserRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Groobaz on 2017-05-03.
 */
@Controller
public class CartController {

    private final CartRepository cartRepository;
    private final CartService cartService;
    private final EventService eventService;
    private final OrderService orderService;
    private final UserRepository userRepository;

    public CartController(CartRepository cartRepository,
                          CartService cartService, EventService eventService, OrderService orderService, UserRepository userRepository) {
        this.cartRepository = cartRepository;
        this.cartService = cartService;
        this.eventService = eventService;
        this.orderService = orderService;
        this.userRepository = userRepository;
    }


    //ROLE: USER
    @PostMapping("user/event/{name}/buy")
    public String addTicketToCart(@ModelAttribute Cart cart,
                                  @PathVariable String name) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User user = userRepository.findByName(userName);
        cartService.addCartToDatabase(cart, name, user);
        user.getCarts().add(cartRepository.findOne(cart.getId()));
        eventService.updateTicketQuantity(cart, cart.getEvent());
        return "redirect:/event/" + name;
    }

    //ROLE: USER
    @PreAuthorize("#id == principal.id")
    @GetMapping("user/userOrder/{id}")
    public String getUserOrder(Model model,@PathVariable Long id){
        List<Cart> carts = userRepository.findOne(id).getCarts();
        model.addAttribute("carts", carts);
        Order order = new Order();
        order.setUser(userRepository.findOne(id));
        order.setFinalCost(orderService.calculateOrderPrice(carts));
        model.addAttribute("order", order);
        return "cart/cart";
    }






}
