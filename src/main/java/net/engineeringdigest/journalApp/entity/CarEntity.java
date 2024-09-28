package net.engineeringdigest.journalApp.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Car")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarEntity {
    @Id
    private String id;
    @DBRef
    private DriverEntity driverId;
    private String model;
    private String color;
    private String licensePlate;
    private int seats;
}
