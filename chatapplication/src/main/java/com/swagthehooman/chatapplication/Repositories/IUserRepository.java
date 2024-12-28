package com.swagthehooman.chatapplication.Repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.swagthehooman.chatapplication.Models.User;

public interface IUserRepository extends JpaRepository<User, UUID> {

    public Optional<User> findByUsername(String userName);

    public Optional<User> findByEmail(String email);

    @Query("SELECT u.username FROM User u WHERE u.username like :prefix%")
    public List<String> findUsernameByPrefix(@Param("prefix") String prefix);
}
