package net.engineeringdigest.journalApp.models;

import lombok.Data;
import lombok.Getter;

@Data
@Getter

public class LoginRequest {
    private String email;
    private String password;
    private String Role;

}
