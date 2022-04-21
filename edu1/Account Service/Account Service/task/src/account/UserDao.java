package account;

import java.sql.*;

public class UserDao extends Exception {
    static final String DB_URL = "jdbc:h2:file:../service_db";

    static final String USER = "sa";
    static final String PASS = "abc123";

    String QUERY = "SELECT userId, name, lastname, email FROM user";;



    public void getUser() {
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY)) {

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}


