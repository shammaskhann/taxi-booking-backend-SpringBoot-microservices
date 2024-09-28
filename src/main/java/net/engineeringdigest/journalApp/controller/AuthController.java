package net.engineeringdigest.journalApp.controller;

import lombok.extern.slf4j.Slf4j;
import net.engineeringdigest.journalApp.entity.CustomerEntity;
import net.engineeringdigest.journalApp.entity.UserEntity;
import net.engineeringdigest.journalApp.models.LoginRequest;
import net.engineeringdigest.journalApp.services.CustomerDetailsServiceImpl;
import net.engineeringdigest.journalApp.services.CustomerEntryServices;
import net.engineeringdigest.journalApp.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    CustomerEntryServices customerEntryServices;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private CustomerDetailsServiceImpl customerDetailsService;
    @Autowired
    private JwtUtil jwtUtil;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/signup")
    public ResponseEntity<?> addUser(@RequestBody CustomerEntity userEntity) {
        if (userEntity == null ||
                userEntity.getName() == null ||
                userEntity.getName().isEmpty() ||
                userEntity.getEmail() == null ||
                userEntity.getEmail().isEmpty() ||
                userEntity.getPassword() == null ||
                userEntity.getPassword().isEmpty() || userEntity.getPhoneNumber() == null ||
                userEntity.getPhoneNumber().isEmpty()) {

            return new ResponseEntity<>("Invalid Response",HttpStatus.BAD_REQUEST);
        }
        try {
            // Log the user entity
            System.out.println("UserEntity Details: " + userEntity);

            if (customerEntryServices.isPresent(userEntity.getEmail())) {
                return new ResponseEntity<>("Username already Exist",HttpStatus.BAD_REQUEST);
            }
            CustomerEntity entry = customerEntryServices.saveNewEntry(userEntity);
            return new ResponseEntity<>(entry, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace for debugging
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/login")
     public ResponseEntity<?> login(@RequestBody LoginRequest user) {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
            UserDetails userDetails = customerDetailsService.loadUserByUsername(user.getEmail());
            String jwtToken = jwtUtil.generateToken(userDetails.getUsername());

            return new ResponseEntity<>(jwtToken, HttpStatus.OK);
        } catch (AuthenticationException e) {
            log.error("Exception occurred while createAuthenticationToken", e);
           return new ResponseEntity<>("Incorrect Email or Password", HttpStatus.BAD_REQUEST);
        }

    }
}
