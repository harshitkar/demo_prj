package com.main;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseHelper {

    PreparedStatement pst;
    ResultSet rs;
    Connection con;
    DataBaseConnector dataBaseConnector = new DataBaseConnector();

    public Boolean auth(String email, String password) {
        String expectedPassword = "";
        try{
            String query = "SELECT * FROM users WHERE email = '" + email +"';";
            con = dataBaseConnector.connect();
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
            con = dataBaseConnector.connect();
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

    public boolean isEmailRegistered(String email) {
        try{
            String query = "SELECT * FROM users WHERE email = '" + email +"';";
            con = dataBaseConnector.connect();
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
