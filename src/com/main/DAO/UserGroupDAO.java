package com.main.DAO;

import model.user_Group;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class UserGroupDAO {

    PreparedStatement pst;
    ResultSet rs;
    Connection con;
    DataBaseConnector dataBaseConnector = new DataBaseConnector();

    public ArrayList<user_Group> getGroupList(String currentUsername) {
        ArrayList<user_Group> model = new ArrayList<>();
        try{
            con = dataBaseConnector.connect();
            String sql = "SELECT `group`.groupId, `group`.groupName, `user_group`.role, `user_group`.dateJoined " +
                    "FROM noteworthy.`group` " +
                    "INNER JOIN noteworthy.user_group ON `group`.groupId = user_group.groupId " +
                    "WHERE user_group.username = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, currentUsername);
            rs = pst.executeQuery();
            while(rs.next()){
                String groupId = rs.getString("groupId");
                String groupName = rs.getString("groupName");
                String dateJoined = rs.getString("dateJoined");
                user_Group newGroup = new user_Group(groupId, groupName, dateJoined);
                model.add(newGroup);
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
        return model;
    }


    public boolean isGroupIdAvailable(String groupId) {
        try{
            con = dataBaseConnector.connect();
            try {
                String s = "SELECT * FROM `group` WHERE `group`.`groupId` = ?;";
                pst = con.prepareStatement(s);
                pst.setString(1, groupId);
                rs = pst.executeQuery();
                if(!rs.next()) {
                    return true;
                }
            } catch (SQLException e) {
                System.out.println(e);
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
        return false;
    }

    public boolean createGroup(String groupId, String groupName, String currentUsername) {
        try{
            con = dataBaseConnector.connect();
            try {
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String mysqlDateTime = now.format(formatter);
                pst = con.prepareStatement("insert into `group` values(?, ?);");
                pst.setString(1, groupId);
                pst.setString(2, groupName);
                pst.executeUpdate();
                pst = con.prepareStatement("insert into `user_group` values(?, ?, ?, ?);");
                pst.setString(1, currentUsername);
                pst.setString(2, groupId);
                pst.setString(3, "creator");
                pst.setString(4, mysqlDateTime);
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

    public boolean joinGroup(String currentUsername, String groupId) {
        try{
            con = dataBaseConnector.connect();
            try {
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String mysqlDateTime = now.format(formatter);
                pst = con.prepareStatement("select * from `user_group` where `groupId` = ? and `username` = ?;");
                pst.setString(1, groupId);
                pst.setString(2, currentUsername);
                rs = pst.executeQuery();
                if(!rs.next()) {
                    pst = con.prepareStatement("insert into `user_group` values(?, ?, ?, ?);");
                    pst.setString(1, currentUsername);
                    pst.setString(2, groupId);
                    pst.setString(3, "member");
                    pst.setString(4, mysqlDateTime);
                    pst.executeUpdate();
                    return true;
                }
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
        return false;
    }

    public String getCreator(String groupId) {
        try{
            con = dataBaseConnector.connect();
            pst = con.prepareStatement("SELECT `username` FROM `user_group` WHERE `groupId` = ? and role = 'creator';");
            pst.setString(1, groupId);
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

    public DefaultListModel<String> getGetGroupAdminList(String groupId) {
        DefaultListModel<String> model = new DefaultListModel<>();
        try{
            con = dataBaseConnector.connect();
            pst = con.prepareStatement("select `username` from `user_group` where groupId = ? and role = 'admin';");
            pst.setString(1, groupId);
            rs = pst.executeQuery();
            while(rs.next()){
                model.addElement(rs.getString("username"));
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
        return model;
    }

    public DefaultListModel<String> getGroupMemberList(String groupId) {
        DefaultListModel<String> model = new DefaultListModel<>();
        try{
            con = dataBaseConnector.connect();
            pst = con.prepareStatement("select `username` from `user_group` where groupId = ? and role = 'member';");
            pst.setString(1, groupId);
            rs = pst.executeQuery();
            while(rs.next()){
                model.addElement(rs.getString("username"));
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
        return model;
    }

    public int getUnseenCount(String groupId) {
        return 0;
    }

    public String getLastPostDate(String groupId) {
        return "30-03-2024 00:00:00";
    }

    public String getRole(String currentUsername, String groupId) {
        return "member";
    }
}
