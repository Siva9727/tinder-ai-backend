package com.personal.tinder_backend.conversations.repository;

import com.personal.tinder_backend.conversations.Conversation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConversationRepository extends MongoRepository<Conversation,String> {
}
