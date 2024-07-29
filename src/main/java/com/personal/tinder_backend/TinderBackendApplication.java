package com.personal.tinder_backend;

import com.personal.tinder_backend.profile.entity.Profile;
import com.personal.tinder_backend.profile.enums.GENDER;
import com.personal.tinder_backend.profile.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TinderBackendApplication implements CommandLineRunner {

	@Autowired
	public ProfileRepository profileRepository;

	public static void main(String[] args) {
		SpringApplication.run(TinderBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Profile profile = new Profile("1","itachi","uchiha",18,"uchiha","foo.jpg","japanese", GENDER.MALE);

		profileRepository.save(profile);
		profileRepository.findAll().forEach(System.out::println);
	}
}
