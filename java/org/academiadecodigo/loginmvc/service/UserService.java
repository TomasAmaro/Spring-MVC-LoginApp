package org.academiadecodigo.loginmvc.service;

import org.academiadecodigo.loginmvc.model.User;

import java.util.Collection;
import java.util.Map;

/**
 * Created by codecadet on 13/12/16.
 */
public interface UserService {

    public void addUser(User user);

    public User find(String toFind);

    public int count();

    public Collection showAll();

    public void remove(String toFind);
}
