package pl.sda.service;

import pl.sda.dao.UserDao;
import pl.sda.dao.UserDaoImpl;
import pl.sda.entity.UserEntity;
import pl.sda.mapper.UserMapper;
import pl.sda.model.User;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public User getUser(String login) {

        return UserMapper.mapToUser(userDao.getUser(login));

    }

    @Override
    public void saveUser(User user) {

        userDao.addUser(UserMapper.mapToUserEntity(user));
    }
}
