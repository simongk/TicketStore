package com.simongk.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by Szymon Gasienica-Kotelnicki on 21.05.17.
 */
@Controller
public class RegistrationController {
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model){
        model.addAttribute("form", new RegistrationForm());
        return "user/register";
    }

    //TODO: validation to be done

    @PostMapping("/register")
    public String addUser(@ModelAttribute("form") RegistrationForm form){
        userService.createUser(form);
        return "redirect:/allEvents";
    }

}
