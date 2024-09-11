package gr.aueb.cf.schoolapp.dao;

import gr.aueb.cf.schoolapp.dao.exception.UserDAOException;
import gr.aueb.cf.schoolapp.model.User;
import gr.aueb.cf.schoolapp.security.SecUtil;
import gr.aueb.cf.schoolapp.service.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAOImpl implements IUserDAO {

    @Override
    public User insert(User user) throws UserDAOException {
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            // Extract model info
            String username = user.getUsername();
            String password = user.getPassword();

            ps.setString(1, username);
            ps.setString(2, SecUtil.hashPassword(password));

            ps.executeUpdate();
            // logging
            return user;    // TBD
        } catch (SQLException e) {
            e.printStackTrace();
            // logging
            throw new UserDAOException("Insert SQL error. User: " + user + " not inserted.");
        }
    }

    @Override
    public User getByUsername(String username) throws UserDAOException {
        return null;
    }

    @Override
    public boolean isUserValid(String username, String password) throws UserDAOException {
        return false;
    }

    @Override
    public boolean isEmailExists(String username) throws UserDAOException {
        return false;
    }
}
