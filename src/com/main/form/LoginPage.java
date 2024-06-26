/*
 * Created by JFormDesigner on Sun Mar 17 10:15:01 IST 2024
 */

package com.main.form;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.main.DAO.UserDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPage extends JFrame {

    boolean isEmailValid;

    public LoginPage() {
        this.isEmailValid = false;
        initComponents();
    }

    private void login() {
        try {
            String email = EmailField.getText().trim();
            String password = PasswordField.getText();
            if(email.isEmpty() || password.isEmpty()) {
                loginErrorLabel.setText("Enter email and password!");
                return;
            }
                Class.forName("com.mysql.cj.jdbc.Driver");
                UserDAO loginDataBaseHelper = new UserDAO();
                Boolean isAuth = loginDataBaseHelper.auth(email, password);
                if (!isAuth) {
                    loginErrorLabel.setText("Invalid email and password!");
                    EmailField.setText("");
                    PasswordField.setText("");
                    EmailField.grabFocus();
                } else {
                    GroupListPage groupsPage = new GroupListPage(loginDataBaseHelper.getCurrentUsername(email));
                    groupsPage.setSize(935, 585);
                    groupsPage.setResizable(false);
                    groupsPage.setVisible(true);
                    this.dispose();
                }
            } catch(Exception ex) {
                throw new RuntimeException(ex);
            }
    }

    private void ok(ActionEvent ignoredE) {
        if(isEmailValid)
            this.login();
    }

    private void signinLabelMouseMoved(MouseEvent ignoredE) {
        signinLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    private void EmailFieldMouseMoved(MouseEvent ignoredE) {
        EmailField.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    private void PasswordFieldMouseMoved(MouseEvent ignoredE) {
        PasswordField.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    private void EmailFieldKeyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_ENTER) {
            if(EmailField.getText().isEmpty()) {
                emailErrorLabel.setText("Enter an Email");
            } else if(EmailField.getText().contains("@")) {
                isEmailValid = true;
                PasswordField.grabFocus();
            } else {
                    emailErrorLabel.setText("Invalid email");
            }
        } else {
            loginErrorLabel.setText("");
            emailErrorLabel.setText("");
        }
    }

    private void PasswordFieldKeyPressed(KeyEvent e) {
        emailErrorLabel.setText("");
        if (e.getKeyCode()==KeyEvent.VK_ENTER && isEmailValid){
            this.login();

        } else if(!isEmailValid) {
            emailErrorLabel.setText("Enter valid email");
        }
    }

    private void signinLabelMousePressed() {
        SignupPage signinFrame = new SignupPage();
        signinFrame.setSize(370, 346);
        signinFrame.setResizable(false);
        signinFrame.setVisible(true);
        this.dispose();
    }

    private void EmailFieldMouseClicked() {
        // TODO add your code here
    }

    private void signinLabelMouseClicked() {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Harsh Itkar
        DefaultComponentFactory compFactory = DefaultComponentFactory.getInstance();
        // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
        // Generated using JFormDesigner Evaluation license - Harsh Itkar
        JPanel dialogPane = new JPanel();
        JPanel contentPanel = new JPanel();
        EmailField = new JTextField();
        JLabel emailLabel = new JLabel();
        JPanel buttonBar = new JPanel();
        signinLabel = new JLabel();
        JLabel qLabel = new JLabel();
        JButton okButton = new JButton();
        JLabel passwordLabel = new JLabel();
        PasswordField = new JPasswordField();
        loginErrorLabel = compFactory.createLabel("");
        emailErrorLabel = new JLabel();

        //======== this ========
        setBackground(new Color(0x1d1d1d));
        setForeground(Color.white);
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== dialogPane ========
        {
            dialogPane.setBackground(new Color(0x1d1d1d));
            dialogPane. addPropertyChangeListener (e-> {if ("border" .equals (e .getPropertyName () ))
            throw new RuntimeException( ); } );
            dialogPane.setLayout(null);

            //======== contentPanel ========
            {
                contentPanel.setBackground(new Color(0x1d1d1d));
                contentPanel.setLayout(null);

                //---- EmailField ----
                EmailField.setBackground(Color.gray);
                EmailField.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        EmailFieldMouseClicked();
                    }
                });
                EmailField.addMouseMotionListener(new MouseMotionAdapter() {
                    @Override
                    public void mouseMoved(MouseEvent e) {
                        EmailFieldMouseMoved(e);
                    }
                });
                EmailField.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        EmailFieldKeyPressed(e);
                        EmailFieldKeyPressed(e);
                    }
                });
                contentPanel.add(EmailField);
                EmailField.setBounds(95, 25, 230, 25);

                //---- EmailLabel ----
                emailLabel.setText("Email");
                emailLabel.setForeground(Color.white);
                contentPanel.add(emailLabel);
                emailLabel.setBounds(20, 30, 63, emailLabel.getPreferredSize().height);

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

            //======== buttonBar ========
            {
                buttonBar.setBackground(new Color(0x1d1d1d));
                buttonBar.setLayout(null);

                //---- signinLabel ----
                signinLabel.setText("Sign-in");
                signinLabel.setForeground(new Color(0xfae466));
                signinLabel.setFont(signinLabel.getFont().deriveFont(signinLabel.getFont().getSize() + 2f));
                signinLabel.addMouseMotionListener(new MouseMotionAdapter() {
                    @Override
                    public void mouseMoved(MouseEvent e) {
                        signinLabelMouseMoved(e);
                    }
                });
                signinLabel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        signinLabelMouseClicked();
                        signinLabelMouseClicked();
                        signinLabelMouseClicked();
                    }
                    @Override
                    public void mousePressed(MouseEvent e) {
                        signinLabelMousePressed();
                    }
                });
                buttonBar.add(signinLabel);
                signinLabel.setBounds(235, 35, 60, 20);

                //---- qLabel ----
                qLabel.setText("Don't have an account?");
                qLabel.setForeground(Color.white);
                buttonBar.add(qLabel);
                qLabel.setBounds(95, 40, 140, 15);

                //---- okButton ----
                okButton.setText("OK");
                okButton.setBackground(Color.gray);
                okButton.addActionListener(this::ok);
                buttonBar.add(okButton);
                okButton.setBounds(130, 0, 110, okButton.getPreferredSize().height);

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
            buttonBar.setBounds(0, 205, 370, 65);

            //---- PasswordLabel ----
            passwordLabel.setText("Password");
            passwordLabel.setForeground(Color.white);
            dialogPane.add(passwordLabel);
            passwordLabel.setBounds(20, 85, 63, 13);

            //---- PasswordField ----
            PasswordField.setBackground(Color.gray);
            PasswordField.addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    PasswordFieldMouseMoved(e);
                }
            });
            PasswordField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    PasswordFieldKeyPressed(e);
                }
            });
            dialogPane.add(PasswordField);
            PasswordField.setBounds(95, 80, 230, 24);

            //---- loginErrorLabel ----
            loginErrorLabel.setForeground(Color.red);
            dialogPane.add(loginErrorLabel);
            loginErrorLabel.setBounds(95, 120, 230, 20);

            //---- emailErrorLabel ----
            emailErrorLabel.setForeground(Color.red);
            dialogPane.add(emailErrorLabel);
            emailErrorLabel.setBounds(95, 55, 230, 20);

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
        dialogPane.setBounds(0, 0, 370, 269);

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

    private JTextField EmailField;
    private JLabel signinLabel;
    private JPasswordField PasswordField;
    private JLabel loginErrorLabel;
    private JLabel emailErrorLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
