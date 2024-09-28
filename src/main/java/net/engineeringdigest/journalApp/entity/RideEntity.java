package net.engineeringdigest.journalApp.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Document(collection = "Ride")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RideEntity {
    @Id
    private String id;

    @DBRef
    private CustomerEntity customer;
    @DBRef
    private DriverEntity driver;
    @DBRef
    private CarEntity car;
    @DBRef
    private LocationEntity pickUpLocation;
    @DBRef
    private LocationEntity destinationLocation;
    @DBRef
    private LocationEntity liveLocation;
    @DateTimeFormat
    private Date startTime;
    @DateTimeFormat
    private Date endTime;
    private String status;
    private double fareEstimate;
    private double actualFareEstimate;
}
