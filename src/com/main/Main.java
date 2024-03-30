package com.main;

import com.main.DAO.DataBaseHelper;
import com.main.form.GroupListPage;
import com.main.form.LoginPage;

import javax.swing.*;

public class Main extends JFrame {

    public static void main(String[] args) {
//        LoginPage loginFrame = new LoginPage();
//        loginFrame.setSize(384, 305);
//        loginFrame.setResizable(false);
//        loginFrame.setVisible(true);
        String email = "user4@gmail.com";
        String currentUsername = new DataBaseHelper().getCurrentUsername(email);
        GroupListPage groupsPage = new GroupListPage(currentUsername);
        groupsPage.setSize(935, 585);
        groupsPage.setResizable(false);
        groupsPage.setVisible(true);
    }
}