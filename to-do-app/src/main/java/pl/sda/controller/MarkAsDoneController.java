package pl.sda.controller;

import pl.sda.service.TaskService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/mark-as-done")
public class MarkAsDoneController extends HttpServlet {
    private TaskService taskService = new TaskService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String taskId = req.getParameter("taskId");
        taskService.markAsDone(Long.valueOf(taskId));
        req.getRequestDispatcher("/show-tasks").forward(req,resp);
    }
}
