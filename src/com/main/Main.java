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
        String currentUser = new DataBaseHelper().getCurrentUsername("user2@gmail.com");
        GroupListPage groupsPage = new GroupListPage(currentUser);
        groupsPage.setSize(935, 585);
        groupsPage.setResizable(false);
        groupsPage.setVisible(true);
    }
}