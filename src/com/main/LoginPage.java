/*
 * Created by JFormDesigner on Sun Mar 17 10:15:01 IST 2024
 */

package com.main;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

/**
 * @author haras
 */
public class LoginPage extends JFrame {
    public LoginPage() {
        initComponents();
    }

    private void ok(ActionEvent e) {
        try {
            String name = NameField.getText().trim();
            String email = EmailField.getText().trim();
            String password = PasswordField.getText().trim();
            CheckInternetConnectivity checkInternetConnectivity = new CheckInternetConnectivity();
                Class.forName("com.mysql.cj.jdbc.Driver");
                DataBaseHelper loginDataBaseHelper = new DataBaseHelper();
                Boolean isAuth = loginDataBaseHelper.auth(email, password);
                if (!isAuth) {
                    System.out.println("not successful");
                    NameField.setText("");
                    EmailField.setText("");
                    PasswordField.setText("");
                } else {
                    System.out.println("login successful");
                }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Harsh Itkar
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        NameField = new JTextField();
        EmailField = new JTextField();
        NameLabel = new JLabel();
        EmailLabel = new JLabel();
        buttonBar = new JPanel();
        okButton = new JButton();
        PasswordField = new JTextField();
        PasswordLabel = new JLabel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== dialogPane ========
        {
            dialogPane.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing.
            border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border. TitledBorder. CENTER
            , javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font
            .BOLD ,12 ), java. awt. Color. red) ,dialogPane. getBorder( )) ); dialogPane. addPropertyChangeListener (
            new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r"
            .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );
            dialogPane.setLayout(null);

            //======== contentPanel ========
            {
                contentPanel.setLayout(null);
                contentPanel.add(NameField);
                NameField.setBounds(95, 20, 230, 25);
                contentPanel.add(EmailField);
                EmailField.setBounds(95, 75, 230, 25);

                //---- NameLabel ----
                NameLabel.setText("Name");
                contentPanel.add(NameLabel);
                NameLabel.setBounds(20, 25, 60, NameLabel.getPreferredSize().height);

                //---- EmailLabel ----
                EmailLabel.setText("Email");
                contentPanel.add(EmailLabel);
                EmailLabel.setBounds(20, 80, 63, EmailLabel.getPreferredSize().height);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < contentPanel.getComponentCount(); i++) {
                        Rectangle bounds = contentPanel.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = contentPanel.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    contentPanel.setMinimumSize(preferredSize);
                    contentPanel.setPreferredSize(preferredSize);
                }
            }
            dialogPane.add(contentPanel);
            contentPanel.setBounds(0, 0, 398, contentPanel.getPreferredSize().height);

            //======== buttonBar ========
            {
                buttonBar.setLayout(null);

                //---- okButton ----
                okButton.setText("OK");
                okButton.addActionListener(e -> ok(e));
                buttonBar.add(okButton);
                okButton.setBounds(140, 10, 110, okButton.getPreferredSize().height);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < buttonBar.getComponentCount(); i++) {
                        Rectangle bounds = buttonBar.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = buttonBar.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    buttonBar.setMinimumSize(preferredSize);
                    buttonBar.setPreferredSize(preferredSize);
                }
            }
            dialogPane.add(buttonBar);
            buttonBar.setBounds(0, 217, 398, 53);
            dialogPane.add(PasswordField);
            PasswordField.setBounds(95, 125, 230, 25);

            //---- PasswordLabel ----
            PasswordLabel.setText("Password");
            dialogPane.add(PasswordLabel);
            PasswordLabel.setBounds(20, 130, 63, 13);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < dialogPane.getComponentCount(); i++) {
                    Rectangle bounds = dialogPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = dialogPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                dialogPane.setMinimumSize(preferredSize);
                dialogPane.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(dialogPane);
        dialogPane.setBounds(0, 0, dialogPane.getPreferredSize().width, 269);

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
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JTextField NameField;
    private JTextField EmailField;
    private JLabel NameLabel;
    private JLabel EmailLabel;
    private JPanel buttonBar;
    private JButton okButton;
    private JTextField PasswordField;
    private JLabel PasswordLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
