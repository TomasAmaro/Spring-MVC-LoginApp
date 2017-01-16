package org.academiadecodigo.loginmvc.auth;

import org.academiadecodigo.loginmvc.model.User;
import org.academiadecodigo.loginmvc.service.MockUserService;
import org.academiadecodigo.loginmvc.service.UserService;

/**
 * Created by codecadet on 13/12/16.
 */
public class Authenticate {

    private UserService userService;

    public boolean authenticate(String email, String password) {

        User user = userService.find(email);

        return user != null && user.getEmail().equals(email) && user.getPassword().equals(password);

    }

    public void register(String name, String role, String email, String password){
        userService.addUser(new User(name, role, email, password));
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setUserService(MockUserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {
        return userService;
    }
}
