package com.group2.petcareinfotype.service;

import com.group2.petcareinfotype.entity.User;
import com.group2.petcareinfotype.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User getUserById(final String id) {
        User user = null;
        if (id != null) {
            Optional<User> optionalUser = userRepository.findById(Long.parseLong(id));
            if (optionalUser.isPresent()) {
                user = optionalUser.get();
            } else {
                throw new IllegalArgumentException("No User existed!");
            }
        }

        return user;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<User> getUser(final String username, final String mail, final String phone, final String address) {
        return userRepository.findAll().stream().filter(user -> {
            boolean equalUsername = true;
            boolean equalMail = true;
            boolean equalPhone = true;
            boolean equalAddress = true;

            if (username != null) {
                equalUsername = user.getUsername().contains(username);
            }
            if (mail != null) {
                equalMail = user.getMail().equals(mail);
            }
            if (phone != null) {
                equalPhone = user.getPhone().equals(phone);
            }
            if (address != null) {
                equalAddress = user.getAddress().equals(address);
            }

            return equalUsername && equalMail && equalPhone && equalAddress;
        }).collect(Collectors.toList());
    }

    public User updateUser(final User user) {
        if (user.getId() == null || !userRepository.findById(user.getId()).isPresent()) {
            throw new IllegalArgumentException("No matching user existed!");
        } else {
           return userRepository.save(user);
        }
    }

    public void deleteUser(final User user) {
        if (user.getId() == null || !userRepository.findById(user.getId()).isPresent()) {
            throw new IllegalArgumentException("No matching user existed!");
        } else {
            userRepository.delete(user);
        }
    }
}
