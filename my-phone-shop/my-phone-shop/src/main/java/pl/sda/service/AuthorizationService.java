package pl.sda.service;

import javax.servlet.http.HttpServletRequest;

public interface AuthorizationService {

    boolean authorize(HttpServletRequest req);
    boolean isAuthorize(HttpServletRequest req);
    void logout(HttpServletRequest req);
}
