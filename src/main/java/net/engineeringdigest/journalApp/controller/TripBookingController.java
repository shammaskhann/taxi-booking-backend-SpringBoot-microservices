//package net.engineeringdigest.journalApp.controller;
//import net.engineeringdigest.journalApp.entity.TripEntity;
//import net.engineeringdigest.journalApp.repository.TripRepository;
//import net.engineeringdigest.journalApp.services.TripEntryServices;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataAccessException;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/trip")
//public class TripBookingController {
//    @Autowired
//    private TripEntryServices tripEntryServices;
//
//
//
//
//@GetMapping
//public ResponseEntity<?> getTripBookingEntries() {
//    try {
//        List<TripEntity> tripBookingEntries;
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String username = auth.getName();
//        tripBookingEntries = tripEntryServices.getAllTripEntries(username);
//        return new ResponseEntity<>(tripBookingEntries, HttpStatus.OK);
//    } catch (DataAccessException e) {
//        // Handle database-related exceptions
//        return new ResponseEntity<>("Database error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
//    } catch (Exception e) {
//        // Handle general exceptions
//        return new ResponseEntity<>("An unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//}
//      @PostMapping
//    public ResponseEntity<?> createTrip(@RequestBody TripEntity trip) {
//     try{
//         Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//         String username = auth.getName();
//         TripEntity tripEntry = tripEntryServices.saveEntry(trip,username);
//         return new ResponseEntity<>(tripEntry, HttpStatus.CREATED);
//     } catch (Exception e) {
//         return new ResponseEntity<>("An unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
//
//     }
//      }
//
//}
