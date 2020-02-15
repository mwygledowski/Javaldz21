package pl.sda.mapper;

import pl.sda.entity.UserEntity;
import pl.sda.model.User;

public class UserMapper {

    private UserMapper() {
    }

    public static User mapToUser(UserEntity userEntity){

        if(userEntity==null){
            return null;
        }

        return User.builder().firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .login(userEntity.getLogin())
                .password(userEntity.getPassword()).build();
    }

    public static UserEntity mapToUserEntity(User user){

        return UserEntity.builder().firstName(user.getFirstName())
                .lastName(user.getLastName())
                .login(user.getLogin())
                .password(user.getPassword()).build();
    }
}
