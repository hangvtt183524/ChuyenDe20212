package com.group2.petcareinfotype.service;

import com.group2.petcareinfotype.entity.User;
import com.group2.petcareinfotype.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    UserRepository userRepository;

    public String handleLogin(final String mail, final String password) {
        Optional<User> optionalUser = userRepository.findFirstByMail(mail);

        if (!optionalUser.isPresent() || optionalUser.get() == null) {
            return "No accont with mail existed!";
        } else {
            User user = optionalUser.get();
            if (!user.getPassword().equals(password)) {
                return "Wrong password!";
            } else {
                return "Login success!";
            }
        }
    }
}
