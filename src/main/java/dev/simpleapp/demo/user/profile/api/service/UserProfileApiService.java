package dev.simpleapp.demo.user.profile.api.service;

import dev.simpleapp.demo.user.profile.model.UserProfile;

public interface UserProfileApiService {
    UserProfile findUserProfileById(long userProfileId);
}
