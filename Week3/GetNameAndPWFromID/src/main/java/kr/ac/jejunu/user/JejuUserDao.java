package kr.ac.jejunu.user;

import java.sql.*;

public class JejuUserDao extends UserDao{

    @Override
    protected Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
                "jdbc:mysql://localhost/jeju?" +
                        "characterEncoding=utf-8&serverTimezone=UTC"
                , "jeju", "jejupw"
        );
    }
}
