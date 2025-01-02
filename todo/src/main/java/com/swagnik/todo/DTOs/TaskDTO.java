package com.swagnik.todo.DTOs;

import java.util.Date;
import java.util.List;
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
    private List<String> assignedTo;// email addresses of the assignedto users
    private Date reminderDate;// Date on which user would like to be reminded
    private Integer repeatationsAllowed;// Daily, Weekly or Monthly repeats
    private List<String> steps;// steps as entered by the user
    private String description;// task description
    private String owner;// owner email id
}
