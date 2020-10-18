package com.company.view;

import com.company.controller.MainController;

import javax.swing.*;
import java.awt.*;

public class HiWindow extends JFrame {


    private JButton HiButton;


    private MainController controller;

    public HiWindow(MainController controller) {
        this.controller = controller;
    }

    public void init() {


        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(null);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        frame.setBounds(dimension.width / 2 - 100, dimension.height / 2 - 100, 200, 200);
        frame.setTitle("Hi!");

        panel.setBackground(Color.black);

        HiButton = new JButton("Hi");
        HiButton.setLocation(40, 50);
        HiButton.setSize(100, 50);

        HiButton.setBackground(Color.darkGray);
        HiButton.setForeground(Color.LIGHT_GRAY);
        panel.add(HiButton);


        HiButton.addActionListener(e -> {

            frame.dispose();
            Menu menu = new Menu(controller);
            menu.init();

        });


        frame.setVisible(true);
        frame.setContentPane(panel);
    }
}




