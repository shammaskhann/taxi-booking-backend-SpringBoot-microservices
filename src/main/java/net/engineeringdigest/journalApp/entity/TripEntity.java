package net.engineeringdigest.journalApp.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Document(collection = "trips")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class TripEntity {
    @Id
    private String tripId;
    @NonNull
    private String userId;
    @NonNull
    private String driverId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdAt;

}
