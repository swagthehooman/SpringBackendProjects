package com.swagthehooman.chatapplication.DTOs;

import com.swagthehooman.chatapplication.Models.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserAuthDTO {

    private User userInfo;
    private String token;
}
