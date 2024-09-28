package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.CustomerEntity;
import net.engineeringdigest.journalApp.entity.UserEntity;
import net.engineeringdigest.journalApp.repository.UserRepository;
import net.engineeringdigest.journalApp.services.CustomerEntryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {


    @Autowired
    private CustomerEntryServices customerEntryServices;
    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @GetMapping
    public ResponseEntity<?> findAll() {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();

//            List<UserEntity> users = userEntryServices.getUserEntries();
            return new ResponseEntity<>("", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();  // Log exception for debugging
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody CustomerEntity customer) {

        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            System.out.println(auth.toString());
            String username = auth.getName();
            System.out.println(username);
            CustomerEntity userInDb = customerEntryServices.findByEmail(username);
            if (userInDb != null) {
                userInDb.setEmail(customer.getEmail());
                userInDb.setPassword(passwordEncoder.encode(customer.getPassword()));  // Ensure password is encoded
                userInDb.setPhoneNumber(customer.getPhoneNumber());
                userInDb.setName(customer.getName());
                CustomerEntity updatedCutomemr = customerEntryServices.resaveEntry(userInDb);
                return new ResponseEntity<>(updatedCutomemr, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();  // Log exception for debugging
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
