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

import com.swagthehooman.chatapplication.DTOs.ChannelDTO;
import com.swagthehooman.chatapplication.Models.Channel;
import com.swagthehooman.chatapplication.Repositories.IChannelRepository;

@RestController
@RequestMapping("/channels/")
public class ChannelController {

    @Autowired
    private IChannelRepository channelRepo;

    @GetMapping("/allchannels/all")
    public List<ChannelDTO> getAllChannels() {
        return channelRepo.findAll().stream().map(i -> new ChannelDTO(i)).toList();
    }

    @GetMapping("/allchannels/user")
    public List<ChannelDTO> getAllChannelsByUserId(@RequestParam UUID userid) {
        return channelRepo.findByAuthorIdOrRecipientId(userid).stream().map(i -> new ChannelDTO(i)).toList();
    }

    @PostMapping("/createchannel")
    public ChannelDTO saveChannel(@RequestBody ChannelDTO dto) {
        Channel channel = new Channel();
        channel.setChannelId(UUID.randomUUID());
        channel.setUserOneId(dto.getUserOneId());
        channel.setUserTwoId(dto.getUserTwoId());
        channel.setUserOneName(dto.getUserOneName());
        channel.setUserTwoName(dto.getUserTwoName());

        channelRepo.save(channel);
        dto.setChannelId(channel.getChannelId());
        return dto;
    }

}
