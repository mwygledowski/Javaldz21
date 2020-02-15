package pl.sda.service;

import pl.sda.model.User;

import javax.servlet.http.HttpServletRequest;

public class AuthorizationServiceImpl implements AuthorizationService {

    private static final String IS_AUTHORIZE = "isAuthorize";
    private UserService userService = new UserServiceImpl();

    @Override
    public boolean authorize(HttpServletRequest req) {
        User user = userService.getUser(req.getParameter("login"));

        if (user != null && user.getPassword().equals(req.getParameter("password"))) {
            req.getSession().setAttribute(IS_AUTHORIZE, true);
            return true;
        } else {
            req.getSession().setAttribute(IS_AUTHORIZE, false);
            return false;
        }
    }


    @Override
    public void logout(HttpServletRequest req) {

        req.getSession().setAttribute(IS_AUTHORIZE,false);
    }



    @Override
    public boolean isAuthorize(HttpServletRequest req) {

        return false;
    }


}
