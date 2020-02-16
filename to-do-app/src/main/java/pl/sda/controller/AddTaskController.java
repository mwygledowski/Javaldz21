package pl.sda.controller;

import pl.sda.model.Category;
import pl.sda.model.TaskModel;
import pl.sda.service.TaskService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

@WebServlet ("/to-do/add-task")
public class AddTaskController extends HttpServlet  {
    private TaskService taskService = new TaskService();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        taskService.addTask("janek",mapToTaskModel(req));
        req.getRequestDispatcher("/to-do/show-tasks").forward(req, resp);
    }

    private TaskModel mapToTaskModel(HttpServletRequest req) {
        String title  = req.getParameter("title");
        String description = req.getParameter("description");
        Category category = Category.valueOf(req.getParameter("category"));
        LocalDate deadline = LocalDate.parse(req.getParameter("deadline"));
        return TaskModel.builder().done(false).title(title).description(description).deadline(deadline).category(category).build();
    }
}
