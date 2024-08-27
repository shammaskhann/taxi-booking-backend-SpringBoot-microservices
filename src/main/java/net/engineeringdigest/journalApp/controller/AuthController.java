package net.engineeringdigest.journalApp.controller;
import net.engineeringdigest.journalApp.entity.UserEntity;
import net.engineeringdigest.journalApp.services.UserEntryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserEntryServices userEntryServices;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/signup")
    public ResponseEntity<?> addUser(@RequestBody UserEntity userEntity) {
        if (userEntity == null ||
                userEntity.getUserName() == null ||
                userEntity.getUserName().isEmpty() ||
                userEntity.getPassword() == null ||
                userEntity.getPassword().isEmpty()) {
            return new ResponseEntity<>("Invalid Response",HttpStatus.BAD_REQUEST);
        }
        try {
            // Log the user entity
            System.out.println("UserEntity Details: " + userEntity);

            if (userEntryServices.isPresent(userEntity.getUserName())) {
                return new ResponseEntity<>("Username already Exist",HttpStatus.BAD_REQUEST);
            }
            UserEntity entry = userEntryServices.saveEntry(userEntity);
            return new ResponseEntity<>(entry, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace for debugging
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
