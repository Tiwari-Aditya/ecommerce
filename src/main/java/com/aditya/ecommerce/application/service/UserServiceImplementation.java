package com.aditya.ecommerce.application.service;

import com.aditya.ecommerce.application.config.JwtProvider;
import com.aditya.ecommerce.application.exception.UserException;
import com.aditya.ecommerce.application.model.User;
import com.aditya.ecommerce.application.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService {
    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;

    @Override
    public User findUserById(Long userId) throws UserException {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            return user.get();
        }
        throw new UserException("user not found with  id: " + userId);

    }

    @Override
    public User findUserProfileByJwt(String jwt) throws UserException {
        String email = jwtProvider.getEmailFromToken(jwt);
        User user = userRepository.findByEmail(email);
        if (user==null){
            throw new UserException("User not found with email " + email);
        }
        return user;
    }
}
