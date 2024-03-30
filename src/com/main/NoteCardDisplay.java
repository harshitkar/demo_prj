package com.main;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class NoteCardDisplay extends JFrame {
    private static JPanel mainPanel;
    private Connection connection;
    private static Statement statement;
    public static ResultSet resultSet;

    public NoteCardDisplay() {
        setTitle("Note Cards Display");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);

        mainPanel = new JPanel(new GridLayout(0, 3, 10, 10));
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        getContentPane().add(scrollPane);

        connectToDatabase();
        loadNotes();
    }

    private void connectToDatabase() {
        try {
            String url = "jdbc:mysql://localhost:3306/noteworthy";
            String user = "root";
            String password = "MySQL@104";
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static JPanel loadNotes() {
        try {
            resultSet = statement.executeQuery("SELECT * FROM PersonalNotes ORDER BY creation_datetime DESC LIMIT 9");
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String content = resultSet.getString("content");
                String creationDatetime = resultSet.getString("creation_datetime");
                String lastEditDatetime = resultSet.getString("last_edit_datetime");

                JPanel cardPanel = createCardPanel(title, content, creationDatetime, lastEditDatetime);
                mainPanel.add(cardPanel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static JPanel createCardPanel(String title, String content, String creationDatetime, String lastEditDatetime) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(titleLabel, BorderLayout.NORTH);

        JTextArea contentArea = new JTextArea(content);
        contentArea.setEditable(false);
        JScrollPane contentScrollPane = new JScrollPane(contentArea);
        panel.add(contentScrollPane, BorderLayout.CENTER);

        JLabel creationLabel = new JLabel("Created: " + creationDatetime);
        JLabel lastEditLabel = new JLabel("Last Edit: " + lastEditDatetime);
        JPanel infoPanel = new JPanel(new GridLayout(2, 1));
        infoPanel.add(creationLabel);
        infoPanel.add(lastEditLabel);
        panel.add(infoPanel, BorderLayout.SOUTH);
        panel.setSize(new Dimension(200, 100));
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new NoteCardDisplay().setVisible(true));
    }
}
