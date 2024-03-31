/*
 * Created by JFormDesigner on Sat Mar 30 16:10:21 IST 2024
 */

package com.main.form;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author haras
 */
public class MemberGroupNotesListPage extends JFrame {
    String currentUsername;
    public MemberGroupNotesListPage(String _currentUsername, String groupId) {
        currentUsername = _currentUsername;
        initComponents();
    }

    private void joinGroupButtonMouseClicked(MouseEvent e) {
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

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Harsh Itkar
        groupGridPanel = new JPanel();
        joinGroupButton = new JButton();
        createGroupButton = new JButton();
        searchField = new JTextField();

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
