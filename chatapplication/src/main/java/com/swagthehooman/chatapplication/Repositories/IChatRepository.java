package com.swagthehooman.chatapplication.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swagthehooman.chatapplication.Models.Chat;
import java.util.List;

public interface IChatRepository extends JpaRepository<Chat, UUID> {
    public List<Chat> findByChannelId(UUID channelId);
}
