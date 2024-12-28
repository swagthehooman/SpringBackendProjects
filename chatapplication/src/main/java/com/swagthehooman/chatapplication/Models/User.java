package com.swagthehooman.chatapplication.Models;

import java.util.Set;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
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
