package com.main.util;

import com.main.model.userGroup;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class GroupListCellRenderer extends JPanel implements ListCellRenderer<userGroup> {
    private JLabel groupNameLabel;
    private JPanel rightPanel;
    private JLabel ageLabel;
    private JLabel iconLabel;


    public GroupListCellRenderer() {
        super(new BorderLayout());
        groupNameLabel = new JLabel();
        ageLabel = new JLabel();
        iconLabel = new JLabel();
        try {
            Image personImg = ImageIO.read(new URL("https://cdn2.iconfinder.com/data/icons/people-80/96/Picture1-512.png"));
            ImageIcon personIcon = new ImageIcon(personImg.getScaledInstance(20, 20, Image.SCALE_SMOOTH));
            iconLabel.setIcon(personIcon);
        } catch (IOException e) {
            e.printStackTrace();
        }

        add(iconLabel, BorderLayout.LINE_START);

        //Right panel will contain name and age, top and bottom respectively
        rightPanel = new JPanel(new BorderLayout());
        rightPanel.add(groupNameLabel, BorderLayout.PAGE_START);
        rightPanel.add(ageLabel, BorderLayout.PAGE_END);

        add(rightPanel, BorderLayout.CENTER);
        setOpaque(true); //for visible backgrounds
        rightPanel.setOpaque(true);//for visible backgrounds

    }

    @Override
    public Component getListCellRendererComponent(JList<? extends userGroup> list, userGroup value, int index, boolean isSelected,
                                                  boolean cellHasFocus) {
        groupNameLabel.setText(value.getGroupName());

        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
            rightPanel.setBackground(list.getSelectionBackground());
            rightPanel.setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
            rightPanel.setBackground(list.getBackground());
            rightPanel.setForeground(list.getForeground());
        }
        return this;
    }
}
