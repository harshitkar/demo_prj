package com.main;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;

public class homePage {
    private JButton okButton;
    private JPanel dialogPane;

    public static void main(String[] args) {
        UIManager.put("InternalFrame.activeTitleBackground", new ColorUIResource(Color.black ));
        UIManager.put("InternalFrame.activeTitleForeground", new ColorUIResource(Color.WHITE));
        UIManager.put("InternalFrame.titleFont", new Font("Dialog", Font.PLAIN, 11));
        LoginPage frame = new LoginPage();
        frame.setSize(384,305);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}