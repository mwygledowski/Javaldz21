package pl.sda.service;


import pl.sda.model.UserModel;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private static List<UserModel> users = loadMockData();

    public UserModel getUser(String login) {
      return users.stream()
              .filter(user -> user.getLogin().equals(login)).findFirst().orElse(null);
    }


    private static List<UserModel> loadMockData() {
        List<UserModel> mockData = new ArrayList<>();
        mockData.add(new UserModel("roman", "giertych"));
        return mockData;
    }

}
