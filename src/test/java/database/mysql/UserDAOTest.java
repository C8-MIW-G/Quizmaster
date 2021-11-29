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
        DBAccess dbAccess = new DBAccess("Quizmaster",
                "userQuizmaster", "userQuizmasterPW");
        dbAccess.openConnection();
        UserDAO userDAO = new UserDAO(dbAccess);
        int defaultUserId = -1;

        // Activate
        userDAO.storeOne(user);
        dbAccess.closeConnection();

        // Assert
        assertNotEquals(defaultUserId, user.getUserId());
    }

    @Test
    void updateOne() {
    }
}