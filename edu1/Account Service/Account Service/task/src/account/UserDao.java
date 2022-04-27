package account;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;


@Component
public class UserDao extends Exception {
    private static JdbcTemplate jdbcTemplate;

    public User show(int id) {
        return jdbcTemplate.query("SELECT * FROM users WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(User.class))
                .stream().findAny().orElse(null);
    }


//    public void save(User user) {
//        jdbcTemplate.update("INSERT INTO users VALUES (?, ?, ?, ?)", user.getName(), user.getLastname(), user.getEmail(), user.getPassword());
//    }

//    public void update(int id, User updatedUser) {
//        jdbcTemplate.update("UPDATE users SET name=?, lastname=?, password=? WHERE id=?",
//                updatedUser.getName(), updatedUser.getLastname(), updatedUser.getPassword(), id);
//    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE * FROM users WHERE id=?", id);
    }


}


