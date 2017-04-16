package com.simongk.user;

import com.simongk.cart.Cart;
import com.simongk.cart.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by Groobaz on 2017-04-15.
 */
@Controller
public class UserController {

    private final CartRepository cartRepository;

    @Autowired
    public UserController(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @GetMapping("/paymentData/{id}")
    public String getPaymentData(Model model, @PathVariable Long id) {
        Cart cart = cartRepository.findOne(id);
        model.addAttribute("cart", cart);
        return "user/paymentData";
    }
}
