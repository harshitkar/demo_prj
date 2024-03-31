package com.main.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnector {
    Connection con;
    String database_url = "jdbc:mysql://localhost:3306/noteworthy";
    public Connection connect() {
        con=null;
        try {
            con= DriverManager.getConnection(database_url, "root", "MySQL@104");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return con;
    }
}
