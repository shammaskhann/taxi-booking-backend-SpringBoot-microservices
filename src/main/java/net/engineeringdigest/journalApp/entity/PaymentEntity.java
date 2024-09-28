package net.engineeringdigest.journalApp.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Document(collection = "Payment")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentEntity {
    @Id
    private  String id;
   @DBRef
    private CustomerEntity customer;
    @DBRef
    private RideEntity ride;
    private String paymentMethod;
    private double amount;
    @DateTimeFormat
    private Date paymentTime;

}
