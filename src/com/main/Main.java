package com.main;

import com.main.form.LoginPage;

import javax.swing.*;

public class Main extends JFrame {

    public static void main(String[] args) {
        LoginPage loginFrame = new LoginPage();
        loginFrame.setSize(384, 305);
        loginFrame.setResizable(false);
        loginFrame.setVisible(true);
    }
}