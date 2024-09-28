package net.engineeringdigest.journalApp.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Driver")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DriverEntity {
    @Id
    private String id;
    private String name;
    private String email;
    private String phone;
    private String password;
    private String driverId;
    @DBRef
    private CarEntity carId;
}
