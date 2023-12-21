package dev.simpleapp.demo.user.profile.usecase.impl;

import dev.simpleapp.demo.user.profile.mapper.UserProfileRegisterRequestToUserProfileMapper;
import dev.simpleapp.demo.user.profile.model.UserProfile;
import dev.simpleapp.demo.user.profile.service.UserProfileService;
import dev.simpleapp.demo.user.profile.usecase.UserProfileRegisterUseCase;
import dev.simpleapp.demo.user.profile.web.model.UserProfileRegisterRequest;
import org.springframework.stereotype.Component;

@Component
public class UserProfileRegisterUseCaseFacade implements UserProfileRegisterUseCase {

    private final UserProfileService userProfileService;
    private final UserProfileRegisterRequestToUserProfileMapper mapper;

    public UserProfileRegisterUseCaseFacade(UserProfileService userProfileService,
                                            UserProfileRegisterRequestToUserProfileMapper mapper) {
        this.userProfileService = userProfileService;
        this.mapper = mapper;
    }

    @Override
    public void registerUserProfile(UserProfileRegisterRequest registerRequest) {
        UserProfile userProfile = this.mapper.map(registerRequest);
        this.userProfileService.createUserProfile(userProfile);
    }
}
