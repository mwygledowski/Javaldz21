package pl.sda.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
@Builder
@Getter
@AllArgsConstructor
public class User {

    private String login;

    private String firstName;

    private String lastName;

    private String password;

}
