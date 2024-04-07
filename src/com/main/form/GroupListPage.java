/*
 * Created by JFormDesigner on Sat Mar 30 09:02:04 IST 2024
 */

package com.main.form;

import java.awt.event.*;
import com.main.DAO.UserGroupDAO;
import com.main.createCardPanel;
import com.main.util.HintTextField;
import com.main.model.userGroup;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.*;

/**
 * @author haras
 */
public class GroupListPage extends JFrame {

    private static JPanel mainPanel;

    String currentUsername;

    JScrollPane scrollPane;

    ArrayList<userGroup> groupArrayList;

    public GroupListPage(String _currentUsername) {
        currentUsername = _currentUsername;
        groupArrayList = new UserGroupDAO().getGroupList(currentUsername);
        initComponents();
        searchField.setFocusable(false);
        mainPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        scrollPane = new JScrollPane(mainPanel);
        groupGridPanel.add(scrollPane);
        setLocationRelativeTo(getOwner());
        groupArrayList.forEach(n -> {
            createCardPanel createCardPanel = new createCardPanel(n.getGroupName(), n.getCreator(), n.getDateJoined(), n.getLastPostDate(), n.getGroupId(), currentUsername);
            JPanel cardPanel = createCardPanel.getThisPanel();
            mainPanel.add(cardPanel);
        });
    }

//    private JPanel createCardPanel(String groupName, String creator, int unseenCount, String dateJoined, String lastPostDate, String groupId, int getGroupMemberId) {
//        JPanel panel = new JPanel(new BorderLayout());
//        JPanel infoPanel = new JPanel(new GridLayout(3  , 1));
//        JPanel titlePanel = new JPanel(new GridLayout(1, 2));
//        JPanel lastEditPanel = new JPanel(new BorderLayout());
//        JTextArea titleLabel = new JTextArea(groupName);
//        titleLabel.setEditable(false);
//        titleLabel.setLineWrap(true);
//        titleLabel.setBackground(Color.decode("#f0f0f0"));
//        JLabel creationLabel = new JLabel();
//        JLabel UnseenLabel = new JLabel();
//        JLabel lastEditLabel = new JLabel();
//        JLabel dateJoinedLabel = new JLabel();
//        MouseListener myListener;
//        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
//        if(currentUsername.equals(creator)) {
//            creationLabel.setText("Created by: You");
//            dateJoinedLabel.setText("Created at: " + dateJoined);
//        } else {
//            creationLabel.setText("Created by: " + creator);
//            dateJoinedLabel.setText("Joined at: " + dateJoined);
//        }
//        if(unseenCount != 0) {
//            UnseenLabel.setText("Unseen posts: " + unseenCount);
//            infoPanel.add(UnseenLabel);
//        }
//        lastEditLabel.setText(lastPostDate);
//            lastEditPanel.add(lastEditLabel, BorderLayout.LINE_END);
//            titlePanel.add(titleLabel);
//            titlePanel.add(lastEditPanel);
//            infoPanel.add(creationLabel);
//            infoPanel.add(dateJoinedLabel);
//            myListener = new MouseListener() {
//                @Override
//                public void mouseClicked(MouseEvent e) {
//                    if((new UserGroupDAO().getRole(currentUsername, groupId).equals("member"))) {
//                        MemberGroupNotesListPage memberGroupNotesListPage = new MemberGroupNotesListPage(currentUsername, groupId);
//                        memberGroupNotesListPage.setVisible(true);
//                    } else {
//                        AdminGroupNotesListPage adminGroupNotesListPage = new AdminGroupNotesListPage(currentUsername, groupId);
//                        adminGroupNotesListPage.setVisible(true);
//                    }
//                }
//
//                @Override
//                public void mousePressed(MouseEvent e) {
//
//                }
//
//                @Override
//                public void mouseReleased(MouseEvent e) {
//
//                }
//
//                @Override
//                public void mouseEntered(MouseEvent e) {
//                    Font font = titleLabel.getFont();
//                    Map attributes = font.getAttributes();
//                    attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
//                    titleLabel.setFont(font.deriveFont(attributes));
//                }
//
//                @Override
//                public void mouseExited(MouseEvent e) {
//                    titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
//                }
//            };
//            panel.add(titlePanel, BorderLayout.NORTH);
//            panel.add(infoPanel, BorderLayout.SOUTH);
//            panel.addMouseListener(myListener);
//            return panel;
//        }

    private void createGroupButtonMouseClicked(MouseEvent e) {
        CreateGroupPage groupPrompt = new CreateGroupPage(currentUsername);
        groupPrompt.setSize(400, 200);
        setLocationRelativeTo(getOwner());
        groupPrompt.setVisible(true);
        this.dispose();
    }

    private void joinGroupButtonMouseClicked(MouseEvent e) {
        JoinGroupPage groupPrompt = new JoinGroupPage(currentUsername);
        groupPrompt.setSize(400, 200);
        setLocationRelativeTo(getOwner());
        groupPrompt.setVisible(true);
        this.dispose();
    }

    private void searchFieldMouseClicked(MouseEvent e) {
        searchField.setFocusable(true);
    }

    private void searchFieldKeyReleased(KeyEvent e) {
        String searchFieldText = searchField.getText().trim().toLowerCase();
        groupGridPanel.removeAll();
        mainPanel = new JPanel(new GridLayout(0, 3, 10, 10));
        scrollPane = new JScrollPane(mainPanel);
        groupGridPanel.add(scrollPane);
        groupArrayList.forEach(n -> {
            if(n.getGroupName().toLowerCase(Locale.ROOT).contains(searchFieldText) || n.getCreator().toLowerCase(Locale.ROOT).contains(searchFieldText)) {
                createCardPanel createCardPanel = new createCardPanel(n.getGroupName(), n.getCreator(), n.getDateJoined(), n.getLastPostDate(), n.getGroupId(), currentUsername);
                JPanel cardPanel = createCardPanel.getThisPanel();
                mainPanel.add(cardPanel);
            }
        });
        if(groupArrayList.size() != 9) {
            for(int i = groupArrayList.size(); i <= 9; i++) {
                JPanel voidPanel = new JPanel();
                mainPanel.add(voidPanel);
            }
        }
        groupGridPanel.revalidate();
        groupGridPanel.repaint();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Harsh Itkar
        groupGridPanel = new JPanel();
        joinGroupButton = new JButton();
        createGroupButton = new JButton();
        searchField = new HintTextField("Search by group Name or creator...");

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== groupGridPanel ========
        {
            groupGridPanel.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.
            swing.border.EmptyBorder(0,0,0,0), "JFor\u006dDesi\u0067ner \u0045valu\u0061tion",javax.swing.border
            .TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("Dia\u006cog"
            ,java.awt.Font.BOLD,12),java.awt.Color.red),groupGridPanel. getBorder
            ()));groupGridPanel. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java
            .beans.PropertyChangeEvent e){if("bord\u0065r".equals(e.getPropertyName()))throw new RuntimeException
            ();}});
            groupGridPanel.setLayout(new GridLayout(1, 1));
        }
        contentPane.add(groupGridPanel);
        groupGridPanel.setBounds(35, 140, 875, 280);

        //---- joinGroupButton ----
        joinGroupButton.setText("Join Group");
        joinGroupButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                joinGroupButtonMouseClicked(e);
            }
        });
        contentPane.add(joinGroupButton);
        joinGroupButton.setBounds(725, 440, 145, 30);

        //---- createGroupButton ----
        createGroupButton.setText("Create Group");
        createGroupButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                createGroupButtonMouseClicked(e);
            }
        });
        contentPane.add(createGroupButton);
        createGroupButton.setBounds(565, 440, 141, 30);

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
    private JButton joinGroupButton;
    private JButton createGroupButton;
    private JTextField searchField;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
