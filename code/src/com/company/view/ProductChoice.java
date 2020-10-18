package com.company.view;

import com.company.controller.MainController;

import javax.swing.*;
import java.awt.*;

public class ProductChoice {
    private JButton submitButton;


    private MainController controller;

    public ProductChoice(MainController controller) {
        this.controller = controller;
    }

    public void init() {


        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(null);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        frame.setBounds(dimension.width / 2 - 100, dimension.height / 2 - 100, 250, 200);
        frame.setTitle("Products");

        panel.setBackground(Color.black);

        submitButton = new JButton("Submit");
        submitButton.setLocation(20, 80);
        submitButton.setSize(200, 30);

        submitButton.setBackground(Color.darkGray);
        submitButton.setForeground(Color.LIGHT_GRAY);
        panel.add(submitButton);

        String[] products = controller.getProductsName();

        JComboBox searchList = new JComboBox(products);
        searchList.setLocation(20, 20);
        searchList.setSize(200, 30);
        panel.add(searchList);


        submitButton.addActionListener(e -> {

            System.out.println((String)searchList.getSelectedItem());

            frame.dispose();

            CompaniesByProduct companiesByProduct = new CompaniesByProduct(controller);
            companiesByProduct.init((String)searchList.getSelectedItem());

        });


        frame.setVisible(true);
        frame.setContentPane(panel);
    }
}
