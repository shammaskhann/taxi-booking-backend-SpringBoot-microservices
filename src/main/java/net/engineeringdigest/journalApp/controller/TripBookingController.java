package net.engineeringdigest.journalApp.controller;
import net.engineeringdigest.journalApp.entity.TripEntity;
import net.engineeringdigest.journalApp.services.TripEntryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trip")
public class TripBookingController {
    @Autowired
    TripEntryServices tripEntryServices;


@GetMapping
public ResponseEntity<?> getTripBookingEntries() {
    try {
        List<TripEntity> tripBookingEntries = tripEntryServices.getAllTripEntries();
        if (tripBookingEntries.isEmpty()) {
            return new ResponseEntity<>("No trip bookings found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tripBookingEntries, HttpStatus.OK);
    } catch (DataAccessException e) {
        // Handle database-related exceptions
        return new ResponseEntity<>("Database error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
    } catch (Exception e) {
        // Handle general exceptions
        return new ResponseEntity<>("An unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
}
