package com.justvl.script.service;

import com.justvl.script.entity.User;
import com.justvl.script.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public User createUser(String username, @NonNull CharSequence password) {
        User user = new User(username, Objects.requireNonNull(passwordEncoder.encode(password)));
        return userRepository.save(user);
    }


}
