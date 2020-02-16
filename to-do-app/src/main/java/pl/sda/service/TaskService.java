package pl.sda.service;


import pl.sda.model.Category;
import pl.sda.model.TaskModel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class TaskService {
    private static AtomicLong counter = new AtomicLong(0);
    private static List<TaskModel> tasks = loadMockData();

    public void addTask(String login, TaskModel task) {
    }

    public void deleteTask(Long taskId) {
        tasks.remove(getTask(taskId));
    }

    public List<TaskModel> getTasks(String login) {
        return tasks.stream().filter(t -> t.getUserLogin().equals(login)).collect(Collectors.toList());
    }

    public void editTask(String login, TaskModel task) {
    }

    public void markAsDone(Long id) {
       TaskModel taskModel = getTask(id);
       taskModel.setDone(true);
    }
    public TaskModel getTask(Long id) {
        return tasks.stream().filter(task -> task.getId().equals(id)).findFirst().orElse(null);
    }

    private static List<TaskModel> loadMockData() {
        List<TaskModel> mockData = new ArrayList<>();
        TaskModel taskModel = TaskModel.builder()
                .category(Category.WORK)
                .creationDate(LocalDateTime.now())
                .deadline(LocalDateTime.now().plusDays(7))
                .description("drink coffee")
                .title("coffee break")
                .id(generateId())
                .done(true)
                .userLogin("janek")
                .build();
        TaskModel taskModel2 = TaskModel.builder()
                .category(Category.WORK)
                .creationDate(LocalDateTime.now())
                .deadline(LocalDateTime.now().plusDays(7))
                .description("drink coffee")
                .title("coffee break")
                .id(generateId())
                .done(false)
                .userLogin("janek")
                .build();

        mockData.add(taskModel);
        mockData.add(taskModel2);
        return mockData;
    }

    private static Long generateId() {
        return counter.incrementAndGet();
    }
}
