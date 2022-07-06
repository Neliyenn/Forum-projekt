package com.neliyenn.controller;

import com.neliyenn.model.User;
import com.neliyenn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        User userWithEnteredEmailExists = userService.findByEmail(user.getEmail());

        if (userWithEnteredEmailExists != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "Użytkownik o takiej nazwie już istnieje");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        }
        else {
            userService.saveUser(user);

            modelAndView.addObject("successMessage", "Użytkownik został zarejestrowany");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("registration");
        }
        return modelAndView;
    }
}
