package net.engineeringdigest.journalApp.services;

import net.engineeringdigest.journalApp.entity.TripEntity;
import net.engineeringdigest.journalApp.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripEntryServices {

    @Autowired
    private TripRepository tripRepository;

    public TripEntity saveEntry(final TripEntity tripEntry) {
        return tripRepository.save(tripEntry);
    }

    public List<TripEntity> getAllTripEntries(){
        return tripRepository.findAll();
    }
}
