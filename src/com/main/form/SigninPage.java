/*
 * Created by JFormDesigner on Sun Mar 24 09:21:23 IST 2024
 */

package com.main.form;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.main.DataBaseHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author haras
 */
public class SigninPage extends JFrame {

    boolean isEmailValid;
    
    boolean isUsernameValid;

    String currentUserEmail;

    public SigninPage() {
        isEmailValid = false;
        isUsernameValid = false;
        currentUserEmail = null;
        initComponents();
    }

    private void signin() {
        String username = usernameField.getText().trim();
        String email = emailField.getText().trim();
        String password = passwordField.getText();
        if(email.isEmpty() || password.isEmpty()) {
            confirmSigninErrorLabel.setText("Enter all details");
            return;
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(Exception ex) {
            throw new RuntimeException(ex);
        }
        DataBaseHelper DataBaseHelper = new DataBaseHelper();
        if (DataBaseHelper.addUser(username, email, password)) {
            System.out.println("Signin successful");
        } else {
            confirmSigninErrorLabel.setText("Unable to create an account");
        }
    }

    public boolean isAlphanumeric(String str)
    {
        char[] charArray = str.toCharArray();
        for(char c:charArray)
        {
            if (!Character.isLetterOrDigit(c))
                return false;
        }
        return true;
    }

    private void EmailFieldMouseMoved() {
        emailField.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    private void EmailFieldKeyReleased(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_ENTER){
            if(emailField.getText().contains("@")) {
                isEmailValid = true;
                passwordField.grabFocus();
            } else {
                emailErrorLabel.setText("Invalid email");
            }
        } else {
            signinErrorLabel.setText("");
            emailErrorLabel.setText("");

        }
    }

    private void signinLabelMouseMoved() {
        signinLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    private void ok(ActionEvent e) {
        if(isEmailValid && isUsernameValid)
            this.signin();
    }

    private void PasswordFieldMouseMoved() {
        passwordField.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    private void PasswordFieldKeyPressed(KeyEvent e) {
        emailErrorLabel.setText("");
        if (e.getKeyCode()==KeyEvent.VK_ENTER && isEmailValid){
            confirmPasswordField.grabFocus();
        } else if(!isEmailValid) {
            emailErrorLabel.setText("Enter valid email");
        } else if (!isUsernameValid) {
            usernameErrorLabel.setText("Enter valid username");
        }
    }

    private void emailFieldKeyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_ENTER) {
            if(emailField.getText().isEmpty()) {
                emailErrorLabel.setText("Enter an Email");
            } else if(emailField.getText().contains("@")) {
                isEmailValid = true;
                passwordField.grabFocus();
            } else {
                emailErrorLabel.setText("Invalid email");
            }
        } else {
            signinErrorLabel.setText("");
            emailErrorLabel.setText("");
        }
    }

    private void signinLabelMousePressed() {
        LoginPage loginPage = new LoginPage();
        loginPage.setSize(384, 305);
        loginPage.setResizable(false);
        loginPage.setVisible(true);
        this.dispose();
    }

    private void EmailFieldMouseClicked() {
        emailField.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    private void confirmPasswordFieldKeyPressed(KeyEvent e) {
        confirmSigninErrorLabel.setText("");
        if(e.getKeyCode()==KeyEvent.VK_ENTER) {
            if(confirmPasswordField.getText().equals(passwordField.getText())) {
                this.signin();
            } else {
                confirmSigninErrorLabel.setText("Password doesn't match");
                confirmPasswordField.setText("");
            }
        }
    }

    private void usernameFieldFocusLost() {
        emailErrorLabel.setText("");
        usernameValidLabel.setText("");
    }

    private void confirmPasswordFieldMouseMoved(

    ) {
        confirmPasswordField.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    private void emailFieldMouseMoved() {
        emailField.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    private void usernameFieldMouseMoved() {
        usernameField.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    private void usernameFieldKeyReleased(KeyEvent e) {
        usernameErrorLabel.setText("");
        usernameValidLabel.setText("");
        if(!usernameField.getText().isEmpty()) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                if (isUsernameValid) {
                    emailField.grabFocus();
                } else {
                    usernameErrorLabel.setText("Enter username");
                }
            } else {
                if (!isAlphanumeric(usernameField.getText())) {
                    isUsernameValid = false;
                    usernameErrorLabel.setText("username should be alphanumeric");
                } else {
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                    DataBaseHelper dataBaseHelper = new DataBaseHelper();
                    isUsernameValid = dataBaseHelper.isUsernameAvailable(usernameField.getText());
                    if (isUsernameValid) {
                        usernameValidLabel.setText("Username Available");
                    } else {
                        usernameErrorLabel.setText("Username not available");
                    }
                }
            }
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Harsh Itkar
        DefaultComponentFactory compFactory = DefaultComponentFactory.getInstance();
        // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
        // Generated using JFormDesigner Evaluation license - Harsh Itkar
        JPanel dialogPane = new JPanel();
        JPanel contentPanel = new JPanel();
        emailErrorLabel = compFactory.createLabel("");
        JLabel usernameLabel = new JLabel();
        usernameField = new JTextField();
        usernameErrorLabel = new JLabel();
        JLabel emailLabel = new JLabel();
        emailField = new JTextField();
        JLabel passwordLabel = new JLabel();
        passwordField = new JPasswordField();
        signinErrorLabel = compFactory.createLabel("");
        usernameValidLabel = new JLabel();
        JLabel passwordLabel2 = new JLabel();
        confirmPasswordField = new JPasswordField();
        confirmSigninErrorLabel = compFactory.createLabel("");
        JLabel passwordLabel3 = new JLabel();
        JPanel buttonBar = new JPanel();
        signinLabel = new JLabel();
        JLabel qLabel = new JLabel();
        JButton okButton = new JButton();

        //======== this ========
        setBackground(new Color(0x1d1d1d));
        setForeground(Color.white);
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== dialogPane ========
        {
            dialogPane.setBackground(new Color(0x1d1d1d));
            dialogPane. addPropertyChangeListener (e-> {if ("border" .equals (e .getPropertyName () )) throw new RuntimeException( ); } );
            dialogPane.setLayout(null);

            //======== contentPanel ========
            {
                contentPanel.setBackground(new Color(0x1d1d1d));
                contentPanel.setLayout(null);

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
            contentPanel.setBounds(0, 0, 370, contentPanel.getPreferredSize().height);

            //---- emailErrorLabel ----
            emailErrorLabel.setForeground(Color.red);
            dialogPane.add(emailErrorLabel);
            emailErrorLabel.setBounds(95, 110, 230, 20);

            //---- usernameLabel ----
            usernameLabel.setText("Username");
            usernameLabel.setForeground(Color.white);
            dialogPane.add(usernameLabel);
            usernameLabel.setBounds(20, 30, 63, usernameLabel.getPreferredSize().height);

            //---- usernameField ----
            usernameField.setBackground(Color.gray);
            usernameField.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    EmailFieldMouseClicked();
                }
            });
            usernameField.addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    EmailFieldMouseMoved();
                    usernameFieldMouseMoved();
                }
            });
            usernameField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    EmailFieldKeyReleased(e);
                }
                @Override
                public void keyReleased(KeyEvent e) {
                    usernameFieldKeyReleased(e);
                }
                });
            usernameField.addFocusListener(new FocusAdapter() {
                @Override
                public void focusLost(FocusEvent e) {
                    usernameFieldFocusLost();
                }
            });
            dialogPane.add(usernameField);
            usernameField.setBounds(95, 25, 230, 25);

            //---- usernameErrorLabel ----
            usernameErrorLabel.setForeground(Color.red);
            dialogPane.add(usernameErrorLabel);
            usernameErrorLabel.setBounds(95, 55, 230, 20);

            //---- emailLabel ----
            emailLabel.setText("Email");
            emailLabel.setForeground(Color.white);
            dialogPane.add(emailLabel);
            emailLabel.setBounds(20, 85, 63, emailLabel.getPreferredSize().height);

            //---- emailField ----
            emailField.setBackground(Color.gray);
            emailField.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    EmailFieldMouseClicked();
                }
            });
            emailField.addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    EmailFieldMouseMoved();
                    emailFieldMouseMoved();
                }
            });
            emailField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    EmailFieldKeyReleased(e);
                    emailFieldKeyPressed(e);
                }
            });
            emailField.addFocusListener(new FocusAdapter() {
                @Override
                public void focusLost(FocusEvent e) {
                    usernameFieldFocusLost();
                }
            });
            dialogPane.add(emailField);
            emailField.setBounds(95, 80, 230, 25);

            //---- passwordLabel ----
            passwordLabel.setText("Password");
            passwordLabel.setForeground(Color.white);
            dialogPane.add(passwordLabel);
            passwordLabel.setBounds(20, 140, 63, passwordLabel.getPreferredSize().height);

            //---- passwordField ----
            passwordField.setBackground(Color.gray);
            passwordField.addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    PasswordFieldMouseMoved();
                }
            });
            passwordField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    PasswordFieldKeyPressed(e);
                }
            });
            passwordField.addFocusListener(new FocusAdapter() {
                @Override
                public void focusLost(FocusEvent e) {
                    usernameFieldFocusLost();
                }
            });
            dialogPane.add(passwordField);
            passwordField.setBounds(95, 135, 230, 24);

            //---- signinErrorLabel ----
            signinErrorLabel.setForeground(Color.red);
            dialogPane.add(signinErrorLabel);
            signinErrorLabel.setBounds(95, 165, 230, 20);

            //---- usernameValidLabel ----
            usernameValidLabel.setForeground(Color.green);
            dialogPane.add(usernameValidLabel);
            usernameValidLabel.setBounds(95, 55, 230, 20);

            //---- passwordLabel2 ----
            passwordLabel2.setText("Confirm");
            passwordLabel2.setForeground(Color.white);
            dialogPane.add(passwordLabel2);
            passwordLabel2.setBounds(20, 190, 63, 13);

            //---- confirmPasswordField ----
            confirmPasswordField.setBackground(Color.gray);
            confirmPasswordField.addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    PasswordFieldMouseMoved();
                    confirmPasswordFieldMouseMoved();
                    confirmPasswordFieldMouseMoved();
                    confirmPasswordFieldMouseMoved();
                }
            });
            confirmPasswordField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    PasswordFieldKeyPressed(e);
                    confirmPasswordFieldKeyPressed(e);
                }
            });
            confirmPasswordField.addFocusListener(new FocusAdapter() {
                @Override
                public void focusLost(FocusEvent e) {
                    usernameFieldFocusLost();
                }
            });
            dialogPane.add(confirmPasswordField);
            confirmPasswordField.setBounds(95, 190, 230, 24);

            //---- confirmSigninErrorLabel ----
            confirmSigninErrorLabel.setForeground(Color.red);
            dialogPane.add(confirmSigninErrorLabel);
            confirmSigninErrorLabel.setBounds(95, 220, 230, 20);

            //---- passwordLabel3 ----
            passwordLabel3.setText("Password");
            passwordLabel3.setForeground(Color.white);
            dialogPane.add(passwordLabel3);
            passwordLabel3.setBounds(20, 205, 63, passwordLabel3.getPreferredSize().height);

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
        dialogPane.setBounds(0, 0, 370, 245);

        //======== buttonBar ========
        {
            buttonBar.setBackground(new Color(0x1d1d1d));
            buttonBar.setLayout(null);

            //---- signinLabel ----
            signinLabel.setText("Login");
            signinLabel.setForeground(new Color(0xfae466));
            signinLabel.setFont(signinLabel.getFont().deriveFont(signinLabel.getFont().getSize() + 2f));
            signinLabel.setBackground(new Color(0x1d1d1d));
            signinLabel.addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    signinLabelMouseMoved();
                }
            });
            signinLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    signinLabelMousePressed();
                }
            });
            buttonBar.add(signinLabel);
            signinLabel.setBounds(235, 35, 60, 20);

            //---- qLabel ----
            qLabel.setText("Already have an account?");
            qLabel.setForeground(Color.white);
            buttonBar.add(qLabel);
            qLabel.setBounds(85, 40, 150, 15);

            //---- okButton ----
            okButton.setText("OK");
            okButton.setBackground(Color.gray);
            okButton.addActionListener(this::ok);
            buttonBar.add(okButton);
            okButton.setBounds(130, 10, 110, okButton.getPreferredSize().height);

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
        contentPane.add(buttonBar);
        buttonBar.setBounds(0, 245, 370, 65);

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

    private JLabel emailErrorLabel;
    private JTextField usernameField;
    private JLabel usernameErrorLabel;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JLabel signinErrorLabel;
    private JLabel usernameValidLabel;
    private JPasswordField confirmPasswordField;
    private JLabel confirmSigninErrorLabel;
    private JLabel signinLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
