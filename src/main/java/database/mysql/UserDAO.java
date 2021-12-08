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
        ArrayList<User> users = new ArrayList<>();
        String sql = "SELECT userId, username FROM User";

        try {
            setupPreparedStatement(sql);
            ResultSet resultSet = executeSelectStatement();
            while (resultSet.next()) {
                int userId = resultSet.getInt(1);
                String username = resultSet.getString(2);
                users.add(new User(userId, username));
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return users;
    }

    public User confirmUserIdentity(String username, String password) {
        String sql = "SELECT userId FROM User WHERE username = ? AND password = ?";

        try {
            setupPreparedStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = executeSelectStatement();
            if (resultSet.next()) {
                int userId = resultSet.getInt(1);
                return new User(userId, username);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null; // unable to validate user
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
        if (user.getUserId() != User.DEFAULT_USER_ID) {
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
        if (user.getUserId() == User.DEFAULT_USER_ID) {
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
