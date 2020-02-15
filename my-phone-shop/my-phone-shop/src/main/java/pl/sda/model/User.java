package pl.sda.model;

import lombok.Builder;
import lombok.Getter;
@Builder
@Getter
public class User {

    private String login;

    private String firstName;

    private String lastName;

    private String password;

}
