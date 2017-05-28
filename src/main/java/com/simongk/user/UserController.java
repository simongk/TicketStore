package com.simongk.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by Szymon Gasienica-Kotelnicki on 21.05.17.
 */
@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/user/{id}")
    public String getUserPage(Model model, @PathVariable Long id){
        model.addAttribute("user",userService.getUserById(id));
        return "user/user";
    }
}
