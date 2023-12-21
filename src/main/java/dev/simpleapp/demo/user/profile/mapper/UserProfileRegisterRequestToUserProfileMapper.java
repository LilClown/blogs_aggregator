package dev.simpleapp.demo.user.profile.mapper;

import dev.simpleapp.demo.security.mapper.Mapper;
import dev.simpleapp.demo.user.profile.model.UserProfile;
import dev.simpleapp.demo.user.profile.web.model.UserProfileRegisterRequest;

public interface UserProfileRegisterRequestToUserProfileMapper
        extends Mapper<UserProfile, UserProfileRegisterRequest> {
}
