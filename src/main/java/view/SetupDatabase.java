package view;

import database.mysql.SQLFileRunner;
import database.mysql.UserDAO;
import model.User;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Dit is wat het programma doet.
 */
public class SetupDatabase {

    public static void main(String[] args) {
        resetDatabase();
        createUsers();
    }

    public static void resetDatabase() {
        Main.getDbAccess().openConnection();
        SQLFileRunner.resetDatabase(Main.getDbAccess());
        Main.getDbAccess().closeConnection();
    }

    public static void createUsers() {
        Main.getDbAccess().openConnection();
        UserDAO userDAO = new UserDAO(Main.getDbAccess());

        userDAO.storeOne(new User("Merle", "MerlePW"));
        userDAO.storeOne(new User("Louise", "LouisePW"));
        userDAO.storeOne(new User("Laurens", "LaurensPW"));
        userDAO.storeOne(new User("Elisabeth", "ElisabethPW"));

        Main.getDbAccess().closeConnection();
    }


}
