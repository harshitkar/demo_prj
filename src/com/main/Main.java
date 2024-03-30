package com.main;

import com.main.DAO.DataBaseHelper;
import com.main.form.GroupListPage;

import javax.swing.*;

public class Main extends JFrame {

    public static void main(String[] args) {
//        LoginPage loginFrame = new LoginPage();
//        loginFrame.setSize(384, 305);
//        loginFrame.setResizable(false);
//        loginFrame.setVisible(true);
//        Group user1 = new Group("1", "Harsh");
//        Group user2 = new Group("2", "Kunal");
//        Group user3 = new Group("3", "Arya");
//        DefaultListModel<Group> model = new DefaultListModel<>();
//        model.addElement(user1);
//        model.addElement(user2);
//        model.addElement(user3);
        String currentUser = new DataBaseHelper().getCurrentUsername("user2@gmail.com");
        GroupListPage groupsPage = new GroupListPage(currentUser);
        groupsPage.setSize(935, 585);
        groupsPage.setResizable(false);
        groupsPage.setVisible(true);
    }
}