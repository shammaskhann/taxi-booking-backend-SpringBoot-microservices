//package net.engineeringdigest.journalApp.services;
//
//import net.engineeringdigest.journalApp.entity.TripEntity;
//import net.engineeringdigest.journalApp.entity.UserEntity;
//import net.engineeringdigest.journalApp.repository.TripRepository;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.time.LocalDate;
//import java.util.List;
//
//@Service
//
//public class TripEntryServices {
//
//    @Autowired
//    private TripRepository tripRepository;
//   private  final static Logger logger = LoggerFactory.getLogger(TripEntryServices.class);
//
//    @Autowired
//    private CustomerEntryServices customerEntryServices;
//
////    @Transactional
////    public TripEntity saveEntry(final TripEntity tripEntry,String username) {
////        try{
////            UserEntity user = userEntryServices.findByUserName(username);
////            tripEntry.setCreatedAt(LocalDate.now());
////            TripEntity trip = tripRepository.save(tripEntry);
////            user.getTripBookings().add(trip);
////            userEntryServices.resaveEntry(user);
////            return trip;
////        }catch(Exception e){
////            logger.error("Error Occurred {}",e.getMessage(),e);
////            throw new RuntimeException("Error saving entry",e);
////        }
////    }
//
////    public List<TripEntity> getAllTripEntries(String username){
////        try {
////            UserEntity user = customerEntryServices.findByUserName(username);
////            List<TripEntity> trips = user.getTripBookings();
////            return trips;
////        }catch (Exception e){
////            e.printStackTrace();
////            throw new RuntimeException("Error getting trips",e);
////        }
////    }
//}
