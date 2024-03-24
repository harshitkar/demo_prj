package com.main;

import java.awt.*;
import java.sql.*;

public class DataBaseHelper {

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    String database_url = "jdbc:mysql://localhost:3306/testdb";

    private Connection connect() {
        con=null;
        try {
            con= DriverManager.getConnection(database_url, "root", "MySQL@104");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return con;
    }

    public Boolean auth(String email, String password) {
        String expectedPassword = new String();
        try{
            String query = "SELECT * FROM users WHERE email = '" + email +"';";
            con = this.connect();
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            if(rs.next()){
                expectedPassword = rs.getString("password");
            }
            if(password.equals(expectedPassword)) {
                return true;
            }
        } catch(HeadlessException | SQLException ex){
            System.out.println("database error");
        }finally {
            try {
                if(con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean addUser(String username, String email, String password) {
        try{
            String query = "insert into users values('" + email +"', '" + username + "', '" + password + "');";
            con = this.connect();
            pst = con.prepareStatement(query);
            try {
                pst.executeUpdate();
            } catch (SQLException e) {
                return false;
            }
        } catch(HeadlessException | SQLException ex){
            System.out.println("database error");
        }finally {
            try {
                if(con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public boolean isUsernameAvailable(String username) {
        try{
            String query = "SELECT * FROM users WHERE name = '" + username +"';";
            con = this.connect();
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            if(!rs.next()){
                return true;
            }
        } catch(HeadlessException | SQLException ex){
            System.out.println("database error");
        }finally {
            try {
                if(con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean isEmailRegistered(String email) {
        try{
            String query = "SELECT * FROM users WHERE email = '" + email +"';";
            con = this.connect();
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch(HeadlessException | SQLException ex){
            System.out.println("database error");
        }finally {
            try {
                if(con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
