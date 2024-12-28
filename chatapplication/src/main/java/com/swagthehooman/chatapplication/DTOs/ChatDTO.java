package com.swagthehooman.chatapplication.DTOs;

import java.util.UUID;

import com.swagthehooman.chatapplication.Models.Chat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatDTO {
    private UUID channelId;
    private String authorName;
    private UUID authorUserId;
    private String recipientName;
    private UUID recipientUserId;
    private String chatMessage;

    public ChatDTO(Chat chat) {
        this.channelId = chat.getChannelId();
        this.authorUserId = chat.getAuthorUserId();
        this.authorName = chat.getAuthorName();
        this.recipientUserId = chat.getRecipientUserId();
        this.recipientName = chat.getRecipientName();
        this.chatMessage = chat.getChatMessage();
    }
}
