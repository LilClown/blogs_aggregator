package dev.simpleapp.demo.security.service.impl;

import dev.simpleapp.demo.security.mapper.UserAccountToUserMapper;
import dev.simpleapp.demo.security.model.UserAccount;
import dev.simpleapp.demo.security.model.UserRole;
import dev.simpleapp.demo.security.service.UserAccountService;
import java.util.Collections;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class UserDetailsServiceImplUnitTest {
    @Mock
    private UserAccountService userAccountService;

    @Mock
    private UserAccountToUserMapper mapper;

    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;

    @Test
    void shouldReturnNonEmptyUserDetails() {
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername("demo_user@gmail.com");
        userAccount.setPassword("encodePassword");
        userAccount.setAuthorities(Collections.singleton(new UserRole()));

        User expectedResult = new User(
                userAccount.getUsername(),
                userAccount.getPassword(),
                userAccount.getAuthorities()
        );

        Mockito.when(userAccountService.findUserByUsername(userAccount.getUsername()))
                .thenReturn(Optional.of(userAccount));
        Mockito.when(mapper.map(userAccount))
                .thenReturn(expectedResult);

        UserDetails actualResult = userDetailsService
                .loadUserByUsername(userAccount.getUsername());

        assertEquals(expectedResult, actualResult);
    }
}