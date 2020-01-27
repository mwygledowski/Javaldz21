package pl.sda;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value="/life-cycle" , loadOnStartup = 1)
public class LifeCycleServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger();

    public LifeCycleServlet() {
        super();
        LOGGER.debug("Inside the no-arg constructor()");
    }

    @Override
    public void init() throws ServletException {
        LOGGER.debug("Inside the init()");
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.print("<html><body><h1>Servlet life cycle</h1></body></html>");
        LOGGER.debug("Inside the doGet()");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.debug("Inside the service(HttpServletRequest req, HttpServletResponse resp)");
        super.service(req, resp);
    }

    @Override
    public void destroy() {
        LOGGER.debug("Inside the destroy()");
        super.destroy();
    }
}
