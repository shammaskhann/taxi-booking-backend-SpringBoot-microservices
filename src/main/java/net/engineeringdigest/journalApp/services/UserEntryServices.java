package net.engineeringdigest.journalApp.services;

import lombok.NonNull;
import net.engineeringdigest.journalApp.entity.UserEntity;
import net.engineeringdigest.journalApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserEntryServices {
    @Autowired
    private UserRepository userRepository;
    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserEntity saveEntry(final UserEntity userEntity) {
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userRepository.save(userEntity);
        return userEntity;
    }

    public List<UserEntity> getUserEntries() {
        return userRepository.findAll();
    }

    public boolean isPresent(@NonNull String userName) {
        return userRepository.findByUserName(userName).isPresent();
    }

    public UserEntity findByUserName(final String userName) {
        return userRepository.findByUserName(userName).orElse(null);
    }

}
