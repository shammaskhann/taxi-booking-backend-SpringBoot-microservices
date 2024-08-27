package net.engineeringdigest.journalApp;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordEncoderTest {

    @Test
    void testPasswordEncoding() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "test123"; // Raw password used for testing
        String encodedPassword = "$2a$10$0kXEITVWv1z6/LOx8ux6Ie/YrgOQxc4iXPjbhN/OOlsGPhMY2xQ/u"; // Update this with the new encoded password

        // Verify that the raw password matches the encoded password
        boolean matches = encoder.matches(rawPassword, encodedPassword);
        assertTrue(matches, "The password should match the encoded password.");
    }
}
