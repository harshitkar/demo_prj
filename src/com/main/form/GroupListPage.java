/*
 * Created by JFormDesigner on Sat Mar 30 09:02:04 IST 2024
 */

package com.main.form;

import com.main.DAO.DataBaseHelper;
import model.user_Group;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;

/**
 * @author haras
 */
public class GroupListPage extends JFrame {

    private static JPanel mainPanel;

    String currentUsername;

    ArrayList<user_Group> groupArrayList;

    public GroupListPage(String _currentUsername) {
        currentUsername = _currentUsername;
        groupArrayList = new DataBaseHelper().getGroupList(currentUsername);
        initComponents();
        mainPanel = new JPanel(new GridLayout(0, 3, 10, 10));
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        groupGridPanel.add(scrollPane);
        setLocationRelativeTo(getOwner());
        System.out.println(groupArrayList.size());
        groupArrayList.forEach(n -> {
            JPanel cardPanel = createCardPanel(n.getGroupName(), n.getCreator(), n.getUnseenCount(), n.getDateJoined(), n.getLastPostDate(), n.getGroupId());
            mainPanel.add(cardPanel);
        });
    }

    private JPanel createCardPanel(String groupName, String creator, int unseenCount, String dateJoined, String lastPostDate, String groupId) {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel infoPanel = new JPanel(new GridLayout(2  , 1));
        JPanel titlePanel = new JPanel(new GridLayout(1, 2));
        JPanel lastEditPanel = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel(groupName);
        JLabel creationLabel = new JLabel();
        JLabel UnseenLabel = new JLabel();
        JLabel lastEditLabel = new JLabel();
        JLabel dateJoinedLabel = new JLabel();
        MouseListener myListener;
        myListener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //pass groupId to determine note id and open update note window
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        if(currentUsername.equals(creator)) {
            creationLabel.setText("Created by: You");
            dateJoinedLabel.setText("Created at: " + dateJoined);
        } else {
            creationLabel.setText("Created by: " + creator);
            dateJoinedLabel.setText("Joined at: " + dateJoined);
        }
        if(unseenCount != 0) {
            UnseenLabel.setText("Unseen posts: " + unseenCount);
        }
        lastEditLabel.setText(lastPostDate);
        lastEditPanel.add(lastEditLabel, BorderLayout.LINE_END);
        titlePanel.add(titleLabel);
        titlePanel.add(lastEditPanel);
        infoPanel.add(creationLabel);
        infoPanel.add(dateJoinedLabel);
        panel.add(titlePanel, BorderLayout.NORTH);
        panel.add(infoPanel, BorderLayout.SOUTH);
        panel.addMouseListener(myListener);
        return panel;
    }

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

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Harsh Itkar
        groupGridPanel = new JPanel();
        joinGroupButton = new JButton();
        createGroupButton = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== groupGridPanel ========
        {
            groupGridPanel. addPropertyChangeListener (new java. beans
            . PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062order" .equals (e .
            getPropertyName () )) throw new RuntimeException( ); }} );
            groupGridPanel.setLayout(new GridLayout(1, 1));
        }
        if(groupArrayList.size() == 0) {
            JLabel noGroupLabel = new JLabel();
            noGroupLabel.setText("You are not a member of any group yet");
            noGroupLabel.setSize(new Dimension(500, 100));
            contentPane.add(noGroupLabel);
            noGroupLabel.setBounds(35, 110, 500, 100);
        } else {
            contentPane.add(groupGridPanel);
            groupGridPanel.setBounds(35, 110, 850, 310);
        }


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
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
