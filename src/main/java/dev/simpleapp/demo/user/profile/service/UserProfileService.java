package dev.simpleapp.demo.user.profile.service;

import dev.simpleapp.demo.user.profile.model.UserProfile;

public interface UserProfileService {
    void createUserProfile(UserProfile userProfile);

    UserProfile findUserProfileByIdRequired(long userProfileId);
}
