package dev.simpleapp.demo.user.profile.usecase;

import dev.simpleapp.demo.user.profile.web.model.UserProfileRegisterRequest;

public interface UserProfileRegisterUseCase {
    void registerUserProfile(UserProfileRegisterRequest registerRequest);
}
