package dev.simpleapp.demo.user.profile.api.service.impl;

import dev.simpleapp.demo.security.api.model.CurrentUserApiModel;
import dev.simpleapp.demo.security.api.service.IdentityApiService;
import dev.simpleapp.demo.user.profile.api.service.CurrentUserProfileApiService;
import dev.simpleapp.demo.user.profile.model.UserProfile;
import dev.simpleapp.demo.user.profile.service.UserProfileService;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserProfileApiServiceImpl
        implements CurrentUserProfileApiService {

    private final IdentityApiService identityApiService;
    private final UserProfileService userProfileService;

    public CurrentUserProfileApiServiceImpl(IdentityApiService identityApiService,
                                            UserProfileService userProfileService) {
        this.identityApiService = identityApiService;
        this.userProfileService = userProfileService;
    }

    @Override
    public UserProfile currentUserProfile() {
        CurrentUserApiModel currentUserApiModel = this.identityApiService.currentUserAccount()
                .orElseThrow(() -> new RuntimeException("Пользователь должен быть авторизован в системе"));

        return this.userProfileService
                .findUserProfileByIdRequired(currentUserApiModel.userAccountId());
    }
}
