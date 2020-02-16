package pl.sda.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
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
