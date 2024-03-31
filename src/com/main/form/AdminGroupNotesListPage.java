/*
 * Created by JFormDesigner on Sat Mar 30 16:09:54 IST 2024
 */

package com.main.form;

import com.main.DAO.GroupNotesDAO;
import com.main.DAO.UserGroupDAO;
import model.GroupNote;
import model.userGroup;

import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author haras
 */
public class AdminGroupNotesListPage extends JFrame {
    private static JPanel mainPanel;

    String currentUsername;

    JScrollPane scrollPane;

    ArrayList<GroupNote> groupNotesArrayList;

    public AdminGroupNotesListPage(String _currentUsername, String groupId) {
        currentUsername = _currentUsername;
        groupNotesArrayList = new GroupNotesDAO().getGroupNotesList(groupId);
        System.out.println("hi");
        initComponents();
        searchField.setFocusable(false);
        mainPanel = new JPanel(new GridLayout(0, 3, 10, 10));
        scrollPane = new JScrollPane(mainPanel);
        groupGridPanel.add(scrollPane);
        setLocationRelativeTo(getOwner());
        groupNotesArrayList.forEach(n -> {
            JPanel cardPanel = createCardPanel(n.getTitle(), n.getContent(), n.getCreation_datetime(), n.getLast_edit_datetime(), n.getCreated_by(), n.getLast_edited_by(), n.getStatus(), n.getGroupNoteId());
            mainPanel.add(cardPanel);
        });
    }

    private JPanel createCardPanel(String title, String content, String creation_datetime, String last_edit_datetime, String creator, String last_edited_by, String status, int groupNoteId) {
        JPanel panel = new JPanel(new GridLayout(3, 1));
        JPanel infoPanel = new JPanel(new GridLayout(2  , 1));
        JPanel titlePanel = new JPanel(new GridLayout(1, 2));
        JPanel lastEditPanel = new JPanel(new GridLayout(2,1));
        JTextArea titleLabel = new JTextArea(title);
        titleLabel.setEditable(false);
        titleLabel.setLineWrap(true);
        titleLabel.setBackground(Color.decode("#f0f0f0"));
        JTextArea contentLabel = new JTextArea(content);
        contentLabel.setEditable(false);
        contentLabel.setLineWrap(true);
        contentLabel.setBackground(Color.decode("#f0f0f0"));
        JLabel creationLabel = new JLabel();
        JLabel lastEditDatetimeLabel = new JLabel();
        JLabel lastEditedByLabel = new JLabel();
        JLabel creationDatetimeLabel = new JLabel();
        MouseListener myListener;
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        if(currentUsername.equals(creator)) {
            creationLabel.setText("Created by: You");
        } else {
            creationLabel.setText("Created by: " + creator);
        }

        creationDatetimeLabel.setText("Created at: " + creation_datetime);
        if(status.equals("unseen")) {
            titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
            lastEditDatetimeLabel.setFont(new Font("Arial", Font.BOLD, 14));
            creationLabel.setFont(new Font("Arial", Font.BOLD, 14));
        }
        lastEditDatetimeLabel.setText(last_edit_datetime);
        lastEditedByLabel.setText(last_edited_by);
        lastEditPanel.add(lastEditDatetimeLabel);
        lastEditPanel.add(lastEditedByLabel);
        titlePanel.add(titleLabel);
        titlePanel.add(lastEditPanel);
        infoPanel.add(creationLabel);
        infoPanel.add(creationDatetimeLabel);
        myListener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //ViewGroupNote()
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
        };
        panel.add(titlePanel, BorderLayout.NORTH);
        panel.add(infoPanel, BorderLayout.SOUTH);
        panel.addMouseListener(myListener);
        return panel;
    }

    private void MouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void createGroupButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void searchFieldMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void searchFieldKeyReleased(KeyEvent e) {
        // TODO add your code here
    }

    private void joinGroupButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Harsh Itkar
        groupGridPanel = new JPanel();
        searchField = new JTextField();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== groupGridPanel ========
        {
            groupGridPanel.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing
            . border. EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder
            . CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .
            awt .Font .BOLD ,12 ), java. awt. Color. red) ,groupGridPanel. getBorder( )) )
            ; groupGridPanel. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
            ) {if ("bord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} )
            ;
            groupGridPanel.setLayout(new GridLayout(1, 1));
        }
        contentPane.add(groupGridPanel);
        groupGridPanel.setBounds(35, 140, 875, 280);

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
    private JPanel groupGridPanel;
    private JTextField searchField;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
