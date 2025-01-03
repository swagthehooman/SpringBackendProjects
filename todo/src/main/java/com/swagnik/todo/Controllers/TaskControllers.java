package com.swagnik.todo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.swagnik.todo.DTOs.TaskDTO;
import com.swagnik.todo.Models.Task;
import com.swagnik.todo.Services.TaskService.TaskLogics;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/task")
public class TaskControllers {

    @Autowired
    private TaskLogics taskLogics;

    @GetMapping("/alltask/")
    public ResponseEntity<List<Task>> getAllTasks(@RequestParam String ownerName) {
        try {
            List<Task> tasks = taskLogics.getAllTasks(ownerName);
            return new ResponseEntity<>(tasks, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/createtask")
    public ResponseEntity<Task> createTask(@RequestBody TaskDTO taskToCreate) {
        try {
            Task createdTask = taskLogics.createTask(taskToCreate);
            return new ResponseEntity<>(createdTask, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/updatetask")
    public ResponseEntity<Task> updateTask(@RequestBody TaskDTO taskToUpdate) {
        try {
            Task updatedTask = taskLogics.updateTask(taskToUpdate);
            return new ResponseEntity<>(updatedTask, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
