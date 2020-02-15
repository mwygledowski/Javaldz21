package pl.sda.dao;

import pl.sda.entity.ProductEntity;
import pl.sda.entity.UserEntity;
import pl.sda.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private static List<UserEntity> userEntities = loadMockData();


    @Override
    public UserEntity getUser(String login) {

        return userEntities.stream().filter(user -> user.getLogin().equals(login)).findFirst().orElse(null);
    }

    @Override
    public void addUser(UserEntity user) {
        userEntities.add(user);
    }


    private static List<UserEntity> loadMockData() {

        List<UserEntity> users = new ArrayList<>();
        UserEntity user = new UserEntity("janek", "Jan", "Nowak", "janek");

        users.add(user);

        return users;
    }
}



