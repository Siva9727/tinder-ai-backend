package com.personal.tinder_backend;

import com.personal.tinder_backend.conversations.ChatMessage;
import com.personal.tinder_backend.conversations.Conversation;
import com.personal.tinder_backend.conversations.repository.ConversationRepository;
import com.personal.tinder_backend.profile.entity.Profile;
import com.personal.tinder_backend.profile.enums.GENDER;
import com.personal.tinder_backend.profile.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class TinderBackendApplication implements CommandLineRunner {

	@Autowired
	public ProfileRepository profileRepository;

	@Autowired
	public ConversationRepository conversationRepository;

	public static void main(String[] args) {
		SpringApplication.run(TinderBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Profile profile = new Profile("1","itachi","uchiha",18,"uchiha","foo.jpg","japanese", GENDER.MALE);
		profileRepository.save(profile);
		profileRepository.findAll().forEach(System.out::println);

		Conversation conversation = new Conversation(
				"1",
				profile.id(),
				List.of(new ChatMessage("hello", profile.id(), LocalDateTime.now()))
		);

		conversationRepository.save(conversation);
		conversationRepository.findAll().forEach(System.out::println);
	}


}
