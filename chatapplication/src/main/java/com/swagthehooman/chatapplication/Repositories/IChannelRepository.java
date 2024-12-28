package com.swagthehooman.chatapplication.Repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.swagthehooman.chatapplication.Models.Channel;

public interface IChannelRepository extends JpaRepository<Channel, UUID> {
    @Query(" FROM Channel c WHERE :Id IN (c.userOneId, c.userTwoId)")
    public List<Channel> findByAuthorIdOrRecipientId(@Param("Id") UUID id);
}
