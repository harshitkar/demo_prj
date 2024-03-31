package com.main.DAO;

import model.GroupNote;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GroupNotesDAO {

    PreparedStatement pst;
    ResultSet rs;
    Connection con;
    DataBaseConnector dataBaseConnector = new DataBaseConnector();

    public boolean addGroupNote(String groupId, String currentUsername, String title, String content) {
        try{
            con = dataBaseConnector.connect();
            try {
                pst = con.prepareStatement("INSERT INTO `groupnotes` (title, content, creation_datetime, last_edit_datetime, created_by, last_edited_by) VALUES (?, ?, NOW(), NOW(), ?, ?);");
                pst.setString(1, title);
                pst.setString(2, content);
                pst.setString(3, currentUsername);
                pst.setString(4, currentUsername);
                pst.executeUpdate();
                pst = con.prepareStatement("SELECT LAST_INSERT_ID();");
                rs = pst.executeQuery();
                rs.next();
                pst = con.prepareStatement("INSERT INTO `groupnotes_user_group` (groupMemberId, groupNoteId, status) VALUES (?, ?, 'seen');");
                pst.setString(1, groupId);
                pst.setInt(2, rs.getInt("LAST_INSERT_ID()"));
                pst.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e);
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

    public boolean updateGroupNote(int groupNoteId, String currentUsername, String title, String content) {
        try{
            con = dataBaseConnector.connect();
            try {
                pst = con.prepareStatement("update `groupnotes` set title = ?, content = ?, last_edit_datetime = NOW(), last_edited_by = ? where `groupNoteId` = ?;");
                pst.setString(1, title);
                pst.setString(2, content);
                pst.setString(3, currentUsername);
                pst.setInt(4, groupNoteId);
                pst.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e);
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

    public ArrayList<GroupNote> getGroupNotesList(String groupId) {
        ArrayList<GroupNote> model = new ArrayList<>();
        try{
            con = dataBaseConnector.connect();
            String sql = "SELECT `groupnotes_group`.groupId, `groupnotes_user_group`.groupNoteId, `groupnotes_user_group`.status " +
                    "`groupnotes`.title, `groupnotes`.content `groupnotes`.creation_datetime, " +
                    "`groupnotes`.last_edit_datetime, `groupnotes`.created_by, `groupnotes`.last_edited_by " +
                    "FROM noteworthy.`groupnotes_user_group` " +
                    "INNER JOIN noteworthy.`groupnotes` ON `groupnotes_user_group`.groupNoteId = `groupnotes`.groupNoteId " +
                    "INNER JOIN noteworthy.`user_group` ON `user_group`.groupMemberId = `groupnotes_user_group`.groupMemberId " +
                    "WHERE `user_group`.groupId = ?;";
            pst = con.prepareStatement(sql);
            pst.setString(1, groupId);
            rs = pst.executeQuery();
            while(rs.next()){
                int groupNoteId = rs.getInt("groupNoteId");
                String title = rs.getString("title");
                String content = rs.getString("content");
                String creation_datetime = rs.getString("creation_datetime");
                String last_edit_datetime = rs.getString("last_edit_datetime");
                String created_by = rs.getString("created_by");
                String last_edited_by = rs.getString("last_edited_by");
                String status = rs.getString("status");
                model.add(new GroupNote(groupNoteId, title, content, creation_datetime, last_edit_datetime, created_by, last_edited_by, status));
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

    public boolean deleteGroupNote(String groupNoteId) {
        try{
            con = dataBaseConnector.connect();
            try {
                pst = con.prepareStatement("delete from `groupnotes` where groupNoteId = ?;");
                pst.setString(1, groupNoteId);
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
