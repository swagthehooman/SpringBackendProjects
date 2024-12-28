package com.swagnik.todo.Utils.BusinessLogic;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swagnik.todo.Constants.Status;
import com.swagnik.todo.DTOs.TaskDTO;
import com.swagnik.todo.Models.Task;
import com.swagnik.todo.Repositories.ITaskRepository;

@Service
public class TaskLogics {

    @Autowired
    private ITaskRepository taskRepository;

    // method to create a task
    public Task createTask(TaskDTO taskToCreate) {
        Task taskObj = new Task();
        try {
            taskObj.setId(UUID.randomUUID());
            taskObj.setName(taskToCreate.getName());
            taskObj.setCreatedOnDate(new Date());
            taskObj.setOwner(taskToCreate.getOwner());
            taskObj.setTaskCompletionDate(taskToCreate.getTaskCompletionDate());
            taskObj.setStatus(Status.DRAFT.getValue());

            taskRepository.save(taskObj);
        } catch (Exception e) {
            System.console().writer().println(e);
            return null;
        }

        return taskObj;
    }

    public Task updateTask(TaskDTO taskToUpdate) {
        Task taskObj = new Task();
        try {
            Optional<Task> taskOptional = taskRepository.findById(taskToUpdate.getId());
            taskObj.setId(taskOptional.get().getId());
            taskObj.setName(taskOptional.get().getName());
            taskObj.setOwner(taskOptional.get().getOwner());
            taskObj.setCreatedOnDate(taskOptional.get().getCreatedOnDate());

            if (taskOptional.isPresent()) {
                if (taskToUpdate.getTaskCompletionDate() != null)
                    taskObj.setTaskCompletionDate(taskToUpdate.getTaskCompletionDate());
                if (taskToUpdate.getName() != null)
                    taskObj.setName(taskToUpdate.getName());
                if (taskToUpdate.getStatus() != null && taskToUpdate.getStatus().equals(Status.COMPLETED.getValue())) {
                    taskObj.setStatus(Status.COMPLETED.getValue());
                    taskObj.setCompletedOnDate(new Date());
                }
                if (taskToUpdate.getStatus() != null && !taskToUpdate.getStatus().equals(Status.COMPLETED.getValue()))
                    taskObj.setStatus(taskToUpdate.getStatus());

                // save the task
                return taskRepository.save(taskObj);

            }
        } catch (Exception e) {
            System.console().writer().println(e);
            return null;
        }
        return taskObj;
    }

    public List<Task> getAllTasks(String owner) {
        List<Task> tasks = null;
        try {
            tasks = taskRepository.findByOwner(owner);
        } catch (Exception e) {
            System.console().writer().println(e);
            return null;
        }
        return tasks;
    }
}
