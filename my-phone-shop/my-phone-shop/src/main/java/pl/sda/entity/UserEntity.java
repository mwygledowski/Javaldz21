package pl.sda.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class UserEntity {

    private String login;

    private String firstName;

    private String lastName;

    private String password;

}
