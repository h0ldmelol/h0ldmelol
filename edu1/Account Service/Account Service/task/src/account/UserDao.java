package account;

import java.sql.*;

public class UserDao extends Exception {
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:file:../service_db";

    static final String USER = "sa";
    static final String PASS = "abc123";

    Connection connection;
    Statement statement;


}


