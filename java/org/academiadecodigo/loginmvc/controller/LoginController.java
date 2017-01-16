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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * Created by codecadet on 13/12/16.
 */
@Controller
@SessionAttributes("userlogged")
public class LoginController {

    @Autowired
    private Authenticate authenticate;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ModelAndView showLogin() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public ModelAndView doLogin(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors()){
            ModelAndView modelAndView = new ModelAndView("redirect:/");
            return modelAndView;
        }


        // If auth succeeds, render a new view
        if (authenticate.authenticate(user.getEmail(), user.getPassword())) {
            ModelAndView modelAndView = new ModelAndView("redirect:/admin");
            User user1 = userService.find(user.getEmail());
            user1.setLogged(true);
            redirectAttributes.addFlashAttribute("userlogged",user1);

            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("redirect:/");
            modelAndView.addObject("user", new User());

            return modelAndView;
        }

    }
}
