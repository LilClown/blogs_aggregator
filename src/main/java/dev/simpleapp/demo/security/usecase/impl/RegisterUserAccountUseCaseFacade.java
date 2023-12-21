package dev.simpleapp.demo.security.usecase.impl;

import dev.simpleapp.demo.security.mapper.RegisterRequestToUserAccountMapper;
import dev.simpleapp.demo.security.model.UserAccount;
import dev.simpleapp.demo.security.service.UserAccountService;
import dev.simpleapp.demo.security.usecase.RegisterUserAccountUseCase;
import dev.simpleapp.demo.security.web.model.RegisterRequest;
import org.springframework.stereotype.Component;

@Component
public class RegisterUserAccountUseCaseFacade implements RegisterUserAccountUseCase {

    private final UserAccountService userAccountService;
    private final RegisterRequestToUserAccountMapper mapper;

    public RegisterUserAccountUseCaseFacade(UserAccountService userAccountService,
                                            RegisterRequestToUserAccountMapper mapper) {
        this.userAccountService = userAccountService;
        this.mapper = mapper;
    }

    @Override
    public void register(RegisterRequest registerRequest) {
        UserAccount userAccount = this.mapper.map(registerRequest);
        this.userAccountService.createUserAccount(userAccount);
    }
}
