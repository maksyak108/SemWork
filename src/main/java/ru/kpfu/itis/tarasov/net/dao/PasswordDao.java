package ru.kpfu.itis.tarasov.net.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kpfu.itis.tarasov.net.dao.impl.UserDaoImpl;
import ru.kpfu.itis.tarasov.net.model.User;
import ru.kpfu.itis.tarasov.net.util.PasswordUtil;
import ru.kpfu.itis.tarasov.net.util.PostgresConnectionUtil;

import java.sql.*;

public class PasswordDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);
    private final Connection connection = PostgresConnectionUtil.getConnection();

    public User getinfo(String email) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * from client WHERE mail = '" + email + "'";
            ResultSet resultSet = statement.executeQuery(sql);

            User user = null;
            while (resultSet.next()) {
                user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("mail"),
                        resultSet.getString("password")
                );
            }
            if(user == null){
                user = new User("DOESNTEXIST!", "DOESNTEXIST!", "DOESNTEXIST!");
            }
            return user;
        } catch (SQLException e) {
            LOGGER.warn("Failed execute get all query", e);
            return null;
        }
    }

    public void save(User user) {
        String sql = "INSERT into client (name, mail, password) VALUES (?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, PasswordUtil.encrypt(user.getPassword()));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.warn("Failed execute save query", e);
        }
    }

    public String getPassword(String email) {
        return getinfo(email).getPassword();
    }

    public String saveUser(User user){
        save(user);
        return "User " +  user.getName() + " saved";
    }
}