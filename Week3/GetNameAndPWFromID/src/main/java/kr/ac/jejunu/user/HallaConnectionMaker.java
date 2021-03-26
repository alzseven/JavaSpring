package kr.ac.jejunu.user;

import java.sql.*;

public class HallaConnectionMaker implements IConnectionMaker {
    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
                "jdbc:mysql://localhost/halla?" +
                        "characterEncoding=utf-8&serverTimezone=UTC"
                , "halla", "hallapw"
        );
    }
}
