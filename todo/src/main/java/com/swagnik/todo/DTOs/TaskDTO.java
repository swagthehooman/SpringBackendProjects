package com.swagnik.todo.DTOs;

import java.util.Date;
import java.util.UUID;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TaskDTO {
    private UUID id;// unique uuid of record
    private String name;// task name
    private Date createdOnDate;// task creation date
    private Integer status;// status of the task
    private Date taskCompletionDate;// task completion date as entered by user
    private String owner;// owner email id
}
