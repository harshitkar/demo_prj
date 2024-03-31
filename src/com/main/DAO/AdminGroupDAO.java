package com.main.DAO;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AdminGroupDAO {
    PreparedStatement pst;
    ResultSet rs;
    Connection con;
    DataBaseConnector dataBaseConnector = new DataBaseConnector();

    public boolean deleteGroup(String groupId) {
        try{
            con = dataBaseConnector.connect();
            try {
                pst = con.prepareStatement("delete from `group` where groupId = ?;");
                pst.setString(1, groupId);
                pst.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e);
                return false;
            }
        } catch(HeadlessException ex){
            System.out.println(ex);
            return false;
        }finally {
            try {
                if(con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public boolean makeAdmin(String username, String groupId) {
        try{
            con = dataBaseConnector.connect();
            try {
                pst = con.prepareStatement("update `user_group` set role = `admin` where username = ? and groupId = ?;");
                pst.setString(1, username);
                pst.setString(2, groupId);
                pst.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e);
                return false;
            }
        } catch(HeadlessException ex){
            System.out.println(ex);
            return false;
        }finally {
            try {
                if(con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }


}
