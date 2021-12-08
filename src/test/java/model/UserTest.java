package model;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    @DisplayName("Test of twee vergelijkbare Users als dezelfde User gelden.")
    void testOfTweeVergelijkbareUsersAlsDezelfdeUserGelden() {
        // Arrange
        User user1 = new User("Vincent", "");
        User user2 = new User("Vincent", "");

        // Activate
        boolean areEqual = user1.equals(user2);

        // Assert
        assertTrue(areEqual);
    }

    @Test
    @DisplayName("Twee verschillende Users zijn echt verschillend")
    void tweeVerschillendeUsersZijnEchtVerschillend() {
        // Arrange
        User user1 = new User("Vincent", "");
        User user2 = new User("Vincent2", "");

        // Activate
        boolean areEqual = user1.equals(user2);

        // Assert
        assertFalse(areEqual);
    }
}