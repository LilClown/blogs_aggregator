package dev.simpleapp.demo.security.api.service;

import dev.simpleapp.demo.security.api.model.CurrentUserApiModel;

import java.util.Optional;

public interface IdentityApiService {
    Optional<CurrentUserApiModel> currentUserAccount();
}
