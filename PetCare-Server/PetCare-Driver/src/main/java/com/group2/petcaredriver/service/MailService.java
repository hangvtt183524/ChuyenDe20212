package com.group2.petcaredriver.service;

import com.group2.petcaredriver.entity.Mail;
import com.group2.petcaredriver.entity.User;
import com.group2.petcaredriver.repository.MailRepository;
import com.group2.petcaredriver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class MailService {

    @Autowired
    MailRepository mailRepository;

    @Autowired
    UserRepository userRepository;

    public Mail saveMail(final String mail, final Integer type) {
        Optional<User> optionalUser = userRepository.findFirstByMail(mail);
        if (!optionalUser.isPresent() || optionalUser.get() == null) {
            throw new IllegalArgumentException("No User with mail existed!");
        }

        User user = optionalUser.get();
        Mail newMail = new Mail();
        newMail.setUserId(user.getId());
        newMail.setTypeMail(type);
        newMail.setSentDate(new Date());

        return mailRepository.save(newMail);
    }
}
