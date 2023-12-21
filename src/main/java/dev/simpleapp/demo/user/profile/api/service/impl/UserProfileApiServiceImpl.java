package dev.simpleapp.demo.user.profile.api.service.impl;

import dev.simpleapp.demo.user.profile.api.service.UserProfileApiService;
import dev.simpleapp.demo.user.profile.model.UserProfile;
import dev.simpleapp.demo.user.profile.service.UserProfileService;
import org.springframework.stereotype.Service;

@Service
public class UserProfileApiServiceImpl implements UserProfileApiService {

    private final UserProfileService userProfileService;

    public UserProfileApiServiceImpl(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @Override
    public UserProfile findUserProfileById(long userProfileId) {
        return this.userProfileService.findUserProfileByIdRequired(userProfileId);
    }
}
