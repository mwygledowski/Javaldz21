package pl.sda.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Builder
@Getter
@Setter
public class TaskModel {

    private Long id;
    private String title;
    private Category category;
    private LocalDate creationDate;
    private LocalDate deadline;
    private String description;
    private boolean done;
    private String userLogin;
}
