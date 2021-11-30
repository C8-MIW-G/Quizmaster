package database.mysql;

import model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 *
 * Save and get User objects from the database
 */
public class UserDAO extends AbstractDAO implements GenericDAO<User> {

    public UserDAO(DBAccess dbAccess) {
        super(dbAccess);
    }

    @Override
    public ArrayList<User> getAll() {
        // TODO
        return null;
    }

    @Override
    public User getOneById(int id) {
        String sql = "SELECT username FROM User WHERE userId = ?;";

        try {
            setupPreparedStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = executeSelectStatement();
            if (resultSet.next()) {
                String username = resultSet.getString(1);
                return new User(id, username);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    @Override
    public void storeOne(User user) {
        if (user.getUserId() != -1) {
            updateOne(user);
            return;
        }

        String sql = "INSERT INTO User (username, password) VALUES (?, ?);";

        try {
            setupPreparedStatementWithKey(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            int userId = executeInsertStatementWithKey();
            user.setUserId(userId);
        } catch (SQLException sqlException) {
            System.err.println(sqlException);
        }
    }

    public void updateOne(User user) {
        if (user.getUserId() == -1) {
            throw new IllegalArgumentException("User object without id cannot be updated");
        }

        String sql = "UPDATE User SET username = ?, password = ? WHERE userId = ?;";

        try {
            setupPreparedStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setInt(3, user.getUserId());
            executeManipulateStatement();
        } catch (SQLException sqlException) {
            System.err.println(sqlException);
        }
    }
}
