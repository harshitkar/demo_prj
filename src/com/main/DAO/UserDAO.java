package com.main.DAO;

import model.user_Group;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO {
    PreparedStatement pst;
    ResultSet rs;
    Connection con;
    DataBaseConnector dataBaseConnector = new DataBaseConnector();

    public Boolean auth(String email, String password) {
        String expectedPassword = "";
        try{
            con = dataBaseConnector.connect();
            rs = con.prepareStatement("SELECT * FROM user WHERE email = '" + email +"';").executeQuery();
            if(rs.next()){
                expectedPassword = rs.getString("password");
            }
            if(password.equals(expectedPassword)) {
                return true;
            }
        } catch(HeadlessException | SQLException ex){
            System.out.println(ex);
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
            con = dataBaseConnector.connect();
            try {
                con.prepareStatement("insert into user values('" + email +"', '" + username + "', '" + password + "', '" + "Harsh" + "');").executeUpdate();
            } catch (SQLException e) {
                return false;
            }
        } catch(HeadlessException ex){
            System.out.println(ex);
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
            con = dataBaseConnector.connect();
            pst = con.prepareStatement("SELECT * FROM user WHERE userName = '" + username +"';");
            rs = pst.executeQuery();
            if(!rs.next()){
                return true;
            }
        } catch(HeadlessException | SQLException ex){
            System.out.println(ex);
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
            con = dataBaseConnector.connect();
            pst = con.prepareStatement("SELECT * FROM user WHERE email = ?;");
            pst.setString(1, email);
            rs = pst.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch(HeadlessException | SQLException ex){
            System.out.println(ex);
        }finally {
            try {
                if(con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public String getCurrentUsername(String email) {
        try{
            con = dataBaseConnector.connect();
            pst = con.prepareStatement("SELECT * FROM user WHERE email = ?;");
            pst.setString(1, email);
            rs = pst.executeQuery();
            if(rs.next()){
                return rs.getString("username");
            }
        } catch(HeadlessException | SQLException ex){
            System.out.println(ex);
        }finally {
            try {
                if(con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
