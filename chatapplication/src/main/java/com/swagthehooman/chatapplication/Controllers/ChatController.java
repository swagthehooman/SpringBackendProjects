package com.swagthehooman.chatapplication.Controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.swagthehooman.chatapplication.DTOs.ChatDTO;
import com.swagthehooman.chatapplication.Models.Chat;
import com.swagthehooman.chatapplication.Repositories.IChatRepository;

@RestController
@RequestMapping("/chats/")
public class ChatController {

    @Autowired
    private IChatRepository chatRepo;

    @GetMapping("/allchats/channel")
    public List<ChatDTO> getAllChats(@RequestParam UUID channelid) {
        return chatRepo.findByChannelId(channelid).stream().map(i -> new ChatDTO(i)).toList();
    }

    @PostMapping("/savechat")
    public ChatDTO saveChats(@RequestBody ChatDTO dto) {
        Chat chat = new Chat();
        chat.setAuthorName(dto.getAuthorName());
        chat.setRecipientName(dto.getRecipientName());
        chat.setAuthorUserId(dto.getAuthorUserId());
        chat.setRecipientUserId(dto.getRecipientUserId());
        chat.setChatMessage(dto.getChatMessage());
        chat.setChannelId(dto.getChannelId());
        chat.setChatId(UUID.randomUUID());

        return new ChatDTO(chatRepo.save(chat));
    }
}
