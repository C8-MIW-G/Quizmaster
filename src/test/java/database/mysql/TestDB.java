package database.mysql;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 *
 * helper functions for accessing the database
 */
public class TestDB {

    private static DBAccess dbAccess = null;

    public static void main(String[] args) {
        resetDatabase();
        getDbAccess().closeConnection();
    }

    public static DBAccess getDbAccess() {
        if (dbAccess == null) {
            dbAccess = new DBAccess("QuizmasterTest",
                    "userQuizmasterTest", "userQuizmasterPW");
            dbAccess.openConnection();
        }
        return dbAccess;
    }

    public static void resetDatabase() {
        SQLFileRunner.resetDatabase(getDbAccess(), "QuizmasterTest");
    }


}
