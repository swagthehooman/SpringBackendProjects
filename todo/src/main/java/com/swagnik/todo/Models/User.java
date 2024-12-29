package com.swagnik.todo.Models;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    private UUID userId;
    private String email;
    private String username;
    private String password;
    private long fileSize;
    private Boolean isActive;

    // @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    // @JoinTable(name = "USER_ROLES", joinColumns = {
    // @JoinColumn(name = "USER_ID")
    // }, inverseJoinColumns = {
    // @JoinColumn(name = "ROLE_ID") })
    // private Set<Role> roles;
    private String roles;
}