package pl.sda.dao;

import pl.sda.entity.UserEntity;

public interface UserDao {

    UserEntity getUser(String login);
    void addUser(UserEntity user);
}
