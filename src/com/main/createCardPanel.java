package com.main;

import com.main.DAO.UserGroupDAO;
import com.main.form.AdminGroupNotesListPage;
import com.main.form.MemberGroupNotesListPage;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.util.Map;
import javax.swing.JPanel;


public class createCardPanel extends javax.swing.JPanel {


    public createCardPanel(String groupName, String creator, String dateJoined, String lastPostDate, String groupId,String currentUsername)
    {
        initComponents();
        titleLabel.setFocusable(false);
        titleLabel.setText(groupName);
        titleLabel.setEditable(false);
        titleLabel.setText(groupName);
        titleLabel.setLineWrap(true);
        MouseListener myListener;
        if(currentUsername.equals(creator)) {
            creationLabel.setText("Created by: You");
            dateJoinedLabel.setText("Created at: " + dateJoined);
        } else {
            creationLabel.setText("Created by: " + creator);
            dateJoinedLabel.setText("Joined at: " + dateJoined);
        }
        lastEditLabel.setText("Last Edit: " + lastPostDate);
        lastEditPanel.add(lastEditLabel, BorderLayout.LINE_END);
        titlePanel.add(titleLabel);
        titlePanel.add(lastEditPanel);
        infoPanel.add(creationLabel);
        infoPanel.add(dateJoinedLabel);
        myListener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if((new UserGroupDAO().getRole(currentUsername, groupId).equals("member"))) {
                    MemberGroupNotesListPage memberGroupNotesListPage = new MemberGroupNotesListPage(currentUsername, groupId);
                    memberGroupNotesListPage.setVisible(true);
                } else {
                    AdminGroupNotesListPage adminGroupNotesListPage = new AdminGroupNotesListPage(currentUsername, groupId);
                    adminGroupNotesListPage.setVisible(true);
                }
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
        this.add(titlePanel, BorderLayout.NORTH);
        this.add(infoPanel, BorderLayout.SOUTH);
        this.addMouseListener(myListener);


    }
    public JPanel getThisPanel() {
        return this;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        titlePanel = new javax.swing.JPanel();
        infoPanel = new javax.swing.JPanel();
        lastEditPanel = new javax.swing.JPanel();
        lastEditLabel = new javax.swing.JLabel();
        creationLabel = new javax.swing.JLabel();
        dateJoinedLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JTextArea();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        titlePanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
                titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        titlePanelLayout.setVerticalGroup(
                titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 64, Short.MAX_VALUE)
        );

        infoPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
                infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        infoPanelLayout.setVerticalGroup(
                infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 45, Short.MAX_VALUE)
        );

        lastEditPanel.setBackground(new java.awt.Color(255, 255, 255));

        lastEditLabel.setFont(new java.awt.Font("Yu Gothic Light", 0, 12)); // NOI18N
        lastEditLabel.setForeground(new java.awt.Color(102, 102, 102));
        lastEditLabel.setText("Last edit");

        javax.swing.GroupLayout lastEditPanelLayout = new javax.swing.GroupLayout(lastEditPanel);
        lastEditPanel.setLayout(lastEditPanelLayout);
        lastEditPanelLayout.setHorizontalGroup(
                lastEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(lastEditPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lastEditLabel)
                                .addContainerGap())
        );
        lastEditPanelLayout.setVerticalGroup(
                lastEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(lastEditPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lastEditLabel)
                                .addContainerGap(23, Short.MAX_VALUE))
        );

        creationLabel.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 12)); // NOI18N
        creationLabel.setForeground(new java.awt.Color(102, 102, 102));
        creationLabel.setText("Created by XYZ");

        dateJoinedLabel.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 12)); // NOI18N
        dateJoinedLabel.setForeground(new java.awt.Color(102, 102, 102));
        dateJoinedLabel.setText("Created at XYZ date");

        titleLabel.setColumns(20);
        titleLabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 36)); // NOI18N
        titleLabel.setRows(5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(creationLabel)
                                                        .addComponent(dateJoinedLabel))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lastEditPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(10, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lastEditPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(creationLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(dateJoinedLabel))))
        );
    }// </editor-fold>


    // Variables declaration - do not modify
    private javax.swing.JLabel creationLabel;
    private javax.swing.JLabel dateJoinedLabel;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lastEditLabel;
    private javax.swing.JPanel lastEditPanel;
    private javax.swing.JTextArea titleLabel;
    private javax.swing.JPanel titlePanel;
    // End of variables declaration
}