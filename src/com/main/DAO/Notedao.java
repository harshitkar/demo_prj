package com.main.DAO;

import model.PersonalNote;

import java.sql.*;
import java.util.ArrayList;

public class Notedao {
    private Connection connection;
    public static ResultSet resultSet;
    DataBaseConnector dataBaseConnector;

    public Notedao() {
        dataBaseConnector = new DataBaseConnector();
        connection = dataBaseConnector.connect();
    }


    public ArrayList<PersonalNote> loadNotes(String currentUsername) {
        ArrayList<PersonalNote> personalNotesList = new ArrayList<>();
        try {
            String sql = "SELECT `personalnotes`.note_id, `personalnotes`.title," +
                    " `personalnotes`.content, `personalnotes`.creation_datetime," +
                    " `personalnotes`.last_edit_datetime FROM `personalnotes` " +
                    "inner join `personalnotes_user` on " +
                    "`personalnotes_user`.note_id = `personalnotes`.note_id  " +
                    "where `personalnotes_user`.username = ? " +
                    "ORDER BY `personalnotes`.creation_datetime DESC LIMIT 9;";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, currentUsername);
            resultSet = pst.executeQuery();
            while (resultSet.next()) {
                int noteId = resultSet.getInt("note_id");
                String title = resultSet.getString("title");
                String content = resultSet.getString("content");
                String creationDatetime = resultSet.getString("creation_datetime");
                String lastEditDatetime = resultSet.getString("last_edit_datetime");

                PersonalNote note = new PersonalNote();
                note.setNoteID(noteId);
                note.setTitle(title);
                note.setContent(content);
                note.setCreationDateTime(creationDatetime);
                note.setLastEditDateTime(lastEditDatetime);

                personalNotesList.add(note);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personalNotesList;
    }

    public int insert(String title, String content, String currentUsername) {
        int noteId = -1;
        try {
            String sql = "INSERT INTO `personalnotes` (title, content, creation_datetime, last_edit_datetime) VALUES (?, ?, NOW(), NOW())";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, content);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    noteId = generatedKeys.getInt(1);
                    System.out.println("Note inserted with ID: " + noteId);
                }
            }
            sql = "insert into `presonalnotes_user`(note_id, username) values(?, ?);";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, noteId);
            pst.setString(2, currentUsername);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return noteId;
    }

    public void update(PersonalNote note) {
        try {
            // Prepare the SQL statement to update an existing note
            String sql = "UPDATE PersonalNotes SET title = ?, content = ?, last_edit_datetime = NOW() WHERE note_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Set the parameters for the prepared statement
            preparedStatement.setString(1, note.getTitle());
            preparedStatement.setString(2, note.getContent());
            preparedStatement.setInt(3, note.getNoteID());

            // Execute the update statement
            int rowsAffected = preparedStatement.executeUpdate();

            // Check if the update was successful
            if (rowsAffected > 0) {
                System.out.println("Note updated successfully.");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean deleteNote(int noteId) {
        try {
            String sql = "DELETE FROM PersonalNotes WHERE note_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, noteId);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Note deleted successfully.");
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public PersonalNote getNoteById(int noteId) {
        PersonalNote note = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/notewothy", "username", "password");
            String sql = "SELECT * FROM `personalnotes` WHERE `note_id` = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, noteId);
            rs = stmt.executeQuery();

            if (rs.next()) {
                note = new PersonalNote();
                note.setNoteID(rs.getInt("note_id"));
                note.setTitle(rs.getString("title"));
                note.setContent(rs.getString("content"));
                note.setCreationDateTime(rs.getString("creation_datetime"));
                note.setLastEditDateTime(rs.getString("last_edit_datetime"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return note;
    }
}