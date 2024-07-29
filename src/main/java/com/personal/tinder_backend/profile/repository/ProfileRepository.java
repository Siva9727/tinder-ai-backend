package com.personal.tinder_backend.profile.repository;

import com.personal.tinder_backend.profile.entity.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfileRepository extends MongoRepository<Profile,String> {
}
