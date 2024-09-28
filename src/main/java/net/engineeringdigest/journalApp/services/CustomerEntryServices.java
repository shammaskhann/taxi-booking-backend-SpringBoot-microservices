package net.engineeringdigest.journalApp.services;

import lombok.NonNull;
import net.engineeringdigest.journalApp.entity.CustomerEntity;
import net.engineeringdigest.journalApp.entity.TripEntity;
import net.engineeringdigest.journalApp.entity.UserEntity;
import net.engineeringdigest.journalApp.repository.CustomerRepository;
import net.engineeringdigest.journalApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerEntryServices {
    @Autowired
    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Autowired
    private CustomerRepository customerRepository;

    public CustomerEntity saveNewEntry(final CustomerEntity userEntity) {
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        customerRepository.save(userEntity);
        return userEntity;
    }

    public CustomerEntity resaveEntry(final CustomerEntity customerEntity) {
        return customerRepository.save(customerEntity);
    }

//    public List<UserEntity> getUserEntries() {
//        return userRepository.findAll();
//    }

    public boolean isPresent(@NonNull String email) {
        return customerRepository.findByEmail(email).isPresent();
    }

    public CustomerEntity findByEmail(final String email) {
        return customerRepository.findByEmail(email).orElse(null);
    }


}
