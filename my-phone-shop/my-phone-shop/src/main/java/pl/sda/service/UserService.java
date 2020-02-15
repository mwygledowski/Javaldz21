package pl.sda.service;

import pl.sda.exception.ValidationException;
import pl.sda.model.User;

public interface UserService {

    User getUser(String login);
    void saveUser(User user);
    void validate(User login) throws ValidationException;
}
