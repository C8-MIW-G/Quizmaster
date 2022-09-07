package database.mysql;

import model.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {

    static UserDAO userDAO;

    @BeforeAll
    static void resetDatabase(){
        TestDB.resetDatabase();
        userDAO = new UserDAO(TestDB.getDbAccess());
    }

    @AfterAll
    static void closeDatabaseConnection() {
        TestDB.getDbAccess().closeConnection();
    }

    @Test
    void storeOne() {
        // Arrange
        User user = new User("Vincent", "VincentPW");
        UserDAO userDAO = new UserDAO(TestDB.getDbAccess());
        int defaultUserId = user.getUserId();

        // Activate
        userDAO.storeOne(user);

        // Assert
        assertNotEquals(defaultUserId, user.getUserId());
    }

    @Test
    void updateOne() {
        // Arrange
        User user = new User("Laurens", "LaurensPW");
        userDAO.storeOne(user);
        String newUserName = "Martinus";

        // Activate
        user.setUsername(newUserName);
        userDAO.updateOne(user);

        user = userDAO.getOneById(user.getUserId());

        // Assert
        assertEquals(newUserName, user.getUsername());
    }

    @Test
    @DisplayName("Update One should fail on new User object")
    void updateOneShouldFailOnNewUserObject() {
        // Arrange
        User user = new User("test", "test");

        // Activate / Assert
        assertThrows(IllegalArgumentException.class, () -> userDAO.updateOne(user));
    }

    @Test
    @DisplayName("getAllUsersFromDatabase")
    void getAllUsersFromDatabase() {
        // Arrange
        User user1 = new User("Martin", "MartinPW");
        User user2 = new User("Petra", "PetraPW");
        userDAO.storeOne(user1);
        userDAO.storeOne(user2);

        // Activate
        ArrayList<User> usersInDb = userDAO.getAll();

        // Assert
        assertTrue(usersInDb.contains(user1));
        assertTrue(usersInDb.contains(user2));
    }

    @Test
    @DisplayName("fail to confirm identity for non existent user")
    void failToConfirmIdentityForNonExistentUser() {
        // Activate
        User user = userDAO.confirmUserIdentity("NonExistent", "NonExistent");

        // Assert
        assertNull(user);
    }

    @Test
    @DisplayName("fail to confirm identity for wrong password")
    void failToConfirmIdentityForWrongPassword() {
        // Arrange
        userDAO.storeOne(new User("Robin", "RobinPW"));

        // Activate
        User user = userDAO.confirmUserIdentity("Robin", "PWRobin");

        // Assert
        assertNull(user);
    }

    @Test
    @DisplayName("confirm identity for correct credentials")
    void confirmIdentityForCorrectCredentials() {
        // Arrange
        String username = "Louise";
        String password = "LouisePW";
        userDAO.storeOne(new User(username, password));

        // Activate
        User user = userDAO.confirmUserIdentity(username, password);

        // Assert
        assertNotNull(user);
    }

}