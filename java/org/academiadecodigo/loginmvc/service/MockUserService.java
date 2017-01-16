package org.academiadecodigo.loginmvc.service;

import org.academiadecodigo.loginmvc.model.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by codecadet on 13/12/16.
 */
public class MockUserService implements UserService {

    private Map<String,User> users;

    public MockUserService(){
        users = new LinkedHashMap<>();
    }

    public MockUserService(Map<String, User> users) {
        this.users = users;
    }

    @Override
    public void addUser(User user) {
        users.put(user.getEmail(),user);
    }

    @Override
    public User find(String toFind) {
        return users.get(toFind);
    }

    @Override
    public int count() {
        return users.size();
    }

    @Override
    public Collection<User> showAll() {
        return users.values();
    }

    @Override
    public void remove(String toFind) {
        users.remove(toFind);
    }
}
