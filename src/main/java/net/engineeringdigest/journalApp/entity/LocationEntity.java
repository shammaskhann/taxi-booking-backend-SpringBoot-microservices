package net.engineeringdigest.journalApp.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Document(collection = "Location")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocationEntity {
    @Id
    String id;

    @DBRef
    private RideEntity ride;

    private double latitude;
    private double longitude;
    @DateTimeFormat
    private LocalDate updatedAt;
}
