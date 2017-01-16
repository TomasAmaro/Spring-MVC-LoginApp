package org.academiadecodigo.loginmvc.controller;

import org.academiadecodigo.loginmvc.app.View;
import org.academiadecodigo.loginmvc.auth.Authenticate;
import org.academiadecodigo.loginmvc.model.User;
import org.academiadecodigo.loginmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by codecadet on 14/12/16.
 */
@Controller
@SessionAttributes("userlogged")
public class UserController {

    @Autowired
    private Authenticate authenticate;

    @Autowired
    private UserService userService;


    @RequestMapping(method = RequestMethod.GET, value = "/admin")
    public ModelAndView showAdmin(Model model) {
        User user = (User) model.asMap().get("userlogged");

       if(user == null){
            user = new User();
        }

        if (user.isLogged() && user.getRole().equals("mastercoder")) {
            ModelAndView modelAndView = new ModelAndView(View.ADMIN);
            modelAndView.addObject("users", userService.showAll());
            return modelAndView;
        } else {
            return new ModelAndView("redirect:/");
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/admin/logout")
    public ModelAndView logout(SessionStatus sessionStatus) {

        sessionStatus.setComplete();

        return new ModelAndView("redirect:/");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/admin/{email}/remove")
    public ModelAndView remove(@PathVariable("email") String email) {
        userService.remove(email);
        return new ModelAndView("redirect:/admin");
    }

}
