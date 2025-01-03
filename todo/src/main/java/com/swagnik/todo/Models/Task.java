package com.swagnik.todo.Models;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "task", uniqueConstraints = @UniqueConstraint(columnNames = { "id", "name" }))
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;// unique uuid of record
    private String name;// task name
    private Date createdOnDate;// task creation date
    private Date completedOnDate;// task completion date
    private Integer status;// status of the task
    private Date taskCompletionDate;// task completion date as entered by user
    private String description;// task description
    private List<String> assignedTo;// email addresses of the assignedto users
    private Date reminderDate;// Date on which user would like to be reminded
    private Integer repeatationsAllowed;// Daily, Weekly or Monthly repeats
    private List<String> steps;// steps as entered by the user
    // add file attachments columns
    private String owner;// owner email id
}
