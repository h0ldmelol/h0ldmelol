package account;

import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.Map;

@Component
public class UserDao extends Exception {
    static final String DB_URL = "jdbc:h2:file:../service_db";
    static final String USER = "sa";
    static final String PASS = "abc123";

    private static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Map<String, String> getUser(long userId) {
        Map<String, String> map = null;
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM user WHERE id=?");
            preparedStatement.setLong(1, userId);

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();

             map =  Map.of(
                    "id", Long.toString(resultSet.getLong("id")),
                    "name", resultSet.getString("name"),
                    "lastname", resultSet.getString("lastname"),
                    "email", resultSet.getString("email")
            );

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return map;
    }

    public void save(User user) {
        new User();
    }


}


