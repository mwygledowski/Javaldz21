package pl.sda.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class TaskModel {

    private Long id;
    private String title;
    private Category category;
    private LocalDateTime creationDate;
    private LocalDateTime deadline;
    private String description;
    private boolean done;
    private String userLogin;
}
