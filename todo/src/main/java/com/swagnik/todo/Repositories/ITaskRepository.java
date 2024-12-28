package com.swagnik.todo.Repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swagnik.todo.Models.Task;

@Repository
public interface ITaskRepository extends JpaRepository<Task, UUID> {
    public List<Task> findByOwner(String owner);
}
