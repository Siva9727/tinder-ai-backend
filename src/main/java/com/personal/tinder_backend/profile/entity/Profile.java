package com.personal.tinder_backend.profile.entity;

import com.personal.tinder_backend.profile.enums.GENDER;

public record Profile(
        String id,
        String firstName,
        String lastName,
        int age,
        String bio,
        String imageUrl,
        String  ethnicity,
        GENDER gender
) {
}
