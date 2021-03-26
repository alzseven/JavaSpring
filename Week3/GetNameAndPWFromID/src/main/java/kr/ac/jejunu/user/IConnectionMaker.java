package kr.ac.jejunu.user;

import java.sql.Connection;
import java.sql.SQLException;

public interface IConnectionMaker {
    Connection getConnection() throws ClassNotFoundException, SQLException;
}