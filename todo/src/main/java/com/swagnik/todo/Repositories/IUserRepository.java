package com.swagnik.todo.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swagnik.todo.Models.User;
import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, UUID> {
    public List<User> findByEmail(String email);
}
