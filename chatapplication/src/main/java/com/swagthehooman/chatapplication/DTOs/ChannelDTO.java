package com.swagthehooman.chatapplication.DTOs;

import java.util.UUID;

import com.swagthehooman.chatapplication.Models.Channel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ChannelDTO {
    private UUID channelId;
    private UUID userOneId;
    private String userOneName;
    private UUID userTwoId;
    private String userTwoName;

    public ChannelDTO(Channel channel) {
        // this.channelId = channel.getChannelId();
        this.userOneId = channel.getUserOneId();
        this.userOneName = channel.getUserOneName();
        this.userTwoId = channel.getUserTwoId();
        this.userTwoName = channel.getUserTwoName();
    }
}
