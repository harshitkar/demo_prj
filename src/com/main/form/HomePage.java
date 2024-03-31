/*
 * Created by JFormDesigner on Sun Mar 31 11:04:24 IST 2024
 */

package com.main.form;

import com.main.DAO.Notedao;
import com.main.DAO.UserGroupDAO;
import model.PersonalNote;

import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import javax.swing.*;


public class HomePage extends JFrame {

    private static JPanel mainPanel;

    String currentUsername;

    JScrollPane scrollPane;
    ArrayList<PersonalNote> personalNotesList;

    public HomePage(String _currentUsername) {
        currentUsername = _currentUsername;
        personalNotesList = new Notedao().loadNotes(currentUsername);
        initComponents();
        searchField.setFocusable(false);
        mainPanel = new JPanel(new GridLayout(0, 3, 10, 10));
        scrollPane = new JScrollPane(mainPanel);
        personalNoteGridPanel.add(scrollPane);
        setSize(new Dimension(935, 585));
        setLocationRelativeTo(getOwner());
        initComponents();
        System.out.println(personalNotesList.get(1).getTitle());
        personalNotesList.forEach(n -> {
            JPanel cardPanel = createCardPanel(n.getNoteID(), n.getTitle(), n.getContent(), n.getCreationDateTime(), n.getLastEditDateTime());
            mainPanel.add(cardPanel);
        });
    }

    private JPanel createCardPanel(int noteId, String title, String content, String creationDatetime, String lastEditDatetime) {

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
        JPanel infoPanel = new JPanel(new GridLayout(0, 3));
        infoPanel.add(creationLabel);
        infoPanel.add(lastEditLabel);
        panel.add(infoPanel, BorderLayout.SOUTH);
        panel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //ViewNote()
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Font font = titleLabel.getFont();
                Map attributes = font.getAttributes();
                attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                titleLabel.setFont(font.deriveFont(attributes));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
            }
        });
        return panel;
    }

    private void addNoteButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void deleteNoteButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void searchFieldMouseClicked(MouseEvent e) {
        searchField.setFocusable(true);
    }

    private void searchFieldKeyReleased(KeyEvent e) {
        String searchFieldText = searchField.getText().trim().toLowerCase();
        personalNoteGridPanel.removeAll();
        mainPanel = new JPanel(new GridLayout(0, 3, 10, 10));
        scrollPane = new JScrollPane(mainPanel);
        personalNoteGridPanel.add(scrollPane);
        personalNotesList.forEach(n -> {
            if(n.getTitle().toLowerCase(Locale.ROOT).contains(searchFieldText) || n.getContent().toLowerCase(Locale.ROOT).contains(searchFieldText)) {
                JPanel cardPanel = createCardPanel(n.getNoteID(), n.getTitle(), n.getContent(), n.getCreationDateTime(), n.getLastEditDateTime());
                mainPanel.add(cardPanel);
            }
        });
        personalNoteGridPanel.revalidate();
        personalNoteGridPanel.repaint();
    }

    private void joinGroupButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void createGroupButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Harsh Itkar
        personalNoteGridPanel = new JPanel();
        addNoteButton = new JButton();
        deleteNoteButton = new JButton();
        searchField = new JTextField();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== personalNoteGridPanel ========
        {
            personalNoteGridPanel.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new
            javax. swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax
            . swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java
            .awt .Font ("D\u0069alog" ,java .awt .Font .BOLD ,12 ), java. awt
            . Color. red) ,personalNoteGridPanel. getBorder( )) ); personalNoteGridPanel. addPropertyChangeListener (new java. beans.
            PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062order" .
            equals (e .getPropertyName () )) throw new RuntimeException( ); }} );
            personalNoteGridPanel.setLayout(new GridLayout(1, 1));
        }
        contentPane.add(personalNoteGridPanel);
        personalNoteGridPanel.setBounds(35, 140, 875, 280);

        //---- addNoteButton ----
        addNoteButton.setText("Add Note");
        addNoteButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                joinGroupButtonMouseClicked(e);
            }
        });
        contentPane.add(addNoteButton);
        addNoteButton.setBounds(725, 440, 145, 30);

        //---- deleteNoteButton ----
        deleteNoteButton.setText("Delete");
        deleteNoteButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                createGroupButtonMouseClicked(e);
            }
        });
        contentPane.add(deleteNoteButton);
        deleteNoteButton.setBounds(565, 440, 141, 30);

        //---- searchField ----
        searchField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                searchFieldMouseClicked(e);
                searchFieldMouseClicked(e);
            }
        });
        searchField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                searchFieldKeyReleased(e);
            }
        });
        contentPane.add(searchField);
        searchField.setBounds(35, 105, 875, 29);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Harsh Itkar
    private JPanel personalNoteGridPanel;
    private JButton addNoteButton;
    private JButton deleteNoteButton;
    private JTextField searchField;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
