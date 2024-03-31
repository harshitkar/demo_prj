package com.main;

import com.main.DAO.UserDAO;
import com.main.form.GroupListPage;
import com.main.form.HomePage;

import javax.swing.*;

public class Main extends JFrame {

    public static void main(String[] args) {
        //Login Page
//        LoginPage loginFrame = new LoginPage();
//        loginFrame.setSize(384, 305);
//        loginFrame.setResizable(false);
//        loginFrame.setVisible(true);

        //group Page
        String email = "user3@gmail.com";
        String currentUsername = new UserDAO().getCurrentUsername(email);
        GroupListPage groupsPage = new GroupListPage(currentUsername);
        groupsPage.setSize(935, 585);
        groupsPage.setResizable(false);
        groupsPage.setVisible(true);

        //Personal notes HomePage
//        String email = "user3@gmail.com";
//        String currentUsername = new UserDAO().getCurrentUsername(email);
//        HomePage homePage = new HomePage(currentUsername);
//        homePage.setSize(935, 585);
//        homePage.setVisible(true);
    }
}