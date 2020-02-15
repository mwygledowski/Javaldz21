package pl.sda.service;

import pl.sda.model.User;

public interface UserService {

    User getUser(String login);
    void saveUser(User user);
}
