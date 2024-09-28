package net.engineeringdigest.journalApp.services;

import net.engineeringdigest.journalApp.entity.CustomerEntity;
import net.engineeringdigest.journalApp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CustomerDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<CustomerEntity> userOptional = customerRepository.findByEmail(email); // Assuming you have a method to find by email

        if (userOptional.isPresent()) {
            CustomerEntity customerEntity = userOptional.get();

            // Convert CustomerEntity to UserDetails using email as username
            return org.springframework.security.core.userdetails.User.builder()
                    .username(customerEntity.getEmail())  // Use email as the username
                    .password(customerEntity.getPassword())  // Password remains the same
                    .roles("CUSTOMER")
                    .build();
        } else {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
    }
}
