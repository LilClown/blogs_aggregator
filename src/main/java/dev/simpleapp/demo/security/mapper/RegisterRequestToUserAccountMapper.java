package dev.simpleapp.demo.security.mapper;

import dev.simpleapp.demo.security.model.UserAccount;
import dev.simpleapp.demo.security.web.model.RegisterRequest;

public interface RegisterRequestToUserAccountMapper extends Mapper<UserAccount, RegisterRequest> {
}
