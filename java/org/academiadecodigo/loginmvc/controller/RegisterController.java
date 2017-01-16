package org.academiadecodigo.loginmvc.controller;

import org.academiadecodigo.loginmvc.app.View;
import org.academiadecodigo.loginmvc.auth.Authenticate;
import org.academiadecodigo.loginmvc.model.User;
import org.academiadecodigo.loginmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by codecadet on 13/12/16.
 */
@Controller
public class RegisterController {


    @Autowired
    private Authenticate authenticate;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/register")
    public ModelAndView showRegister() {
        User u = new User();

        ModelAndView modelAndView = new ModelAndView("register");
        modelAndView.addObject("userReg", u);
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public ModelAndView Register(@Valid @ModelAttribute("userReg") User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ModelAndView(View.REGISTER);
        }

        if (user.getPassword().equals(user.getPassword2())) {
            userService.addUser(new User(user.getName(), user.getEmail(), user.getPassword(), user.getRole()));
            return new ModelAndView("redirect:/");
        }

        return new ModelAndView("redirect:" + View.REGISTER);
    }
}
