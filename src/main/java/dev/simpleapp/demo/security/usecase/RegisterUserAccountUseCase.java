package dev.simpleapp.demo.security.usecase;

import dev.simpleapp.demo.security.web.model.RegisterRequest;

public interface RegisterUserAccountUseCase {
    void register(RegisterRequest registerRequest);
}
