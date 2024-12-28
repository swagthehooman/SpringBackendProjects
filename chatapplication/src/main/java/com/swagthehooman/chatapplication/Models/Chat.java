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
@Table(name = "chat")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Chat {
    @Id
    private UUID chatId;
    private String authorName;
    private UUID authorUserId;
    private String recipientName;
    private UUID recipientUserId;
    private String chatMessage;
    private UUID channelId;
}
