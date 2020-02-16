package pl.sda.service;

import pl.sda.model.UserModel;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

public class AuthenticationService {

    UserService userService = new UserService();

    public boolean isAuthenticated(HttpServletRequest request) {
        if (request.getSession().getAttribute("isAuthenticated")!= null
                && request.getSession().getAttribute("isAuthenticated").equals(true)) {
            return true;
        }
        return false;
    }

    public boolean authenticate(HttpServletRequest request) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        UserModel user = userService.getUser(login);
        if (user != null && user.getPassword().equals(password)) {
            request.getSession().setAttribute("isAuthenticated", true);
            return true;
        } else {
            request.getSession().setAttribute("isAuthenticated", false);
            return false;
        }
    }
}
