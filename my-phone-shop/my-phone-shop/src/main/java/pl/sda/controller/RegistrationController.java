package pl.sda.controller;

import pl.sda.exception.ValidationException;
import pl.sda.model.User;
import pl.sda.service.UserService;
import pl.sda.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/registration")
public class RegistrationController extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = createUser(req);


        try {
            userService.saveUser(user);
            req.setAttribute("invalidRegistration",false);
            req.getRequestDispatcher("/login").forward(req,resp);
        } catch (ValidationException e) {
            req.setAttribute("invalidRegistration",true);
            req.getRequestDispatcher("/login").forward(req,resp);
        }

    }

    private User createUser(HttpServletRequest req) {
        return new User(req.getParameter("login"), req.getParameter("firstName"),
                req.getParameter("lastName"), req.getParameter("password"));
    }
}
