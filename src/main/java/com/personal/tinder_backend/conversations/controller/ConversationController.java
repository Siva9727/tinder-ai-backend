package com.personal.tinder_backend.conversations.controller;


import com.personal.tinder_backend.conversations.Conversation;
import com.personal.tinder_backend.conversations.repository.ConversationRepository;
import com.personal.tinder_backend.conversations.request.CreateConversationRequest;
import com.personal.tinder_backend.profile.repository.ProfileRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@RestController
public class ConversationController {

    private final ConversationRepository conversationRepository;
    private final ProfileRepository profileRepository;

    public ConversationController(ConversationRepository conversationRepository, ProfileRepository profileRepository) {
        this.conversationRepository = conversationRepository;
        this.profileRepository = profileRepository;
    }

    @PostMapping("/conversations")
    public Optional<Conversation> createNewConversation(@RequestBody CreateConversationRequest conversationRequest){
        profileRepository.findById(conversationRequest.profileId())
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));

        Conversation conversation = new Conversation(
                UUID.randomUUID().toString(),
                conversationRequest.profileId(),
                new ArrayList<>());

        conversationRepository.save(conversation);

        return conversationRepository.findById(conversation.id());

    }
}
