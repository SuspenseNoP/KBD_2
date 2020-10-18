package com.company.view;

import com.company.controller.MainController;

import javax.swing.*;
import java.awt.*;

public class ByeWindow extends JFrame {


    private JButton ByeButton;


    private MainController controller;

    public ByeWindow(MainController controller) {
        this.controller = controller;
    }

    public void init() {


        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(null);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        frame.setBounds(dimension.width / 2 - 100, dimension.height / 2 - 100, 200, 200);
        frame.setTitle("bye");

        panel.setBackground(Color.black);

        ByeButton = new JButton("Bye");
        ByeButton.setLocation(40, 50);
        ByeButton.setSize(100, 50);

        ByeButton.setBackground(Color.darkGray);
        ByeButton.setForeground(Color.LIGHT_GRAY);
        panel.add(ByeButton);


        ByeButton.addActionListener(e -> {

            frame.dispose();

        });


        frame.setVisible(true);
        frame.setContentPane(panel);
    }
}




