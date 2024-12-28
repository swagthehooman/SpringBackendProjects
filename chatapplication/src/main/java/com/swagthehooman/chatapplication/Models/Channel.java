package com.swagthehooman.chatapplication.Models;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "channel")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Channel {
    @Id
    private UUID channelId;
    private UUID userOneId;
    private String userOneName;
    private UUID userTwoId;
    private String userTwoName;
}
