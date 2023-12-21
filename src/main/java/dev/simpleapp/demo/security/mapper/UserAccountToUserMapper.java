package dev.simpleapp.demo.security.mapper;

import dev.simpleapp.demo.security.model.UserAccount;
import org.springframework.security.core.userdetails.User;

public interface UserAccountToUserMapper extends Mapper<User, UserAccount>{
}
