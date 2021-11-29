package database.mysql;

import model.User;
import org.junit.jupiter.api.Test;
import view.SceneManager;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {

    @Test
    void storeOne() {
        // Arrange
        User user = new User("Vincent", "VincentPW");
        UserDAO userDAO = new UserDAO(TestDB.getDbAccess());
        int defaultUserId = -1;

        // Activate
        userDAO.storeOne(user);

        // Assert
        assertNotEquals(defaultUserId, user.getUserId());
    }

    @Test
    void updateOne() {
        // Arrange
        User user = new User("Laurens", "LaurensPW");
        UserDAO userDAO = new UserDAO(TestDB.getDbAccess());
        userDAO.storeOne(user);
        String newUserName = "Martinus";

        // Activate
        user.setUsername(newUserName);
        userDAO.updateOne(user);

        user = userDAO.getOneById(user.getUserId());

        // Assert
        assertEquals(newUserName, user.getUsername());
    }
}