package pl.sda.service;

import pl.sda.dao.UserDao;
import pl.sda.dao.UserDaoImpl;
import pl.sda.entity.UserEntity;
import pl.sda.exception.ValidationException;
import pl.sda.mapper.UserMapper;
import pl.sda.model.User;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public User getUser(String login) {

        return UserMapper.mapToUser(userDao.getUser(login));

    }

    @Override
    public void saveUser(User user) throws ValidationException {

        validate(user);
        userDao.addUser(UserMapper.mapToUserEntity(user));

    }

    @Override
    public void validate(User user) throws ValidationException{

        if(getUser(user.getLogin())!=null){
            throw new ValidationException();
        }


    }
}
