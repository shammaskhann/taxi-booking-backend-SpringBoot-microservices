package net.engineeringdigest.journalApp.entity;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "customer")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity {
    @Id
    private String id;
    private String email;
    private String password;
    private String phoneNumber;
    private String name;
//    @DBRef
    List<String> rideHistory = new ArrayList<>();

}
