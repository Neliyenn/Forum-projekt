package com.neliyenn.controller;

import com.neliyenn.model.User;
import com.neliyenn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {

        model.addAttribute("user", new User());
        return "/registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String createNewUser(@Valid User user,
                                BindingResult bindingResult,
                                Model model) {

        if (userService.findByUsername(user.getUsername()).isPresent()) {
            bindingResult
                    .rejectValue("username", "error.user",
                            "Użytkownik o takiej nazwie już istnieje");
        }

        if (userService.findByEmail(user.getEmail()).isPresent()) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "Użytkownik o takim mailu już istnieje");
        }

        if (!bindingResult.hasErrors()) {
            //rejestracja pomyslna, nadanie uzytkownkowi roli USER i aktywacja
            userService.saveUser(user);


            model.addAttribute("successMessage", "Użytkownik zarejestrowany pomyślnie");
            model.addAttribute("user", new User());
        }

        return "/registration";
    }
}
