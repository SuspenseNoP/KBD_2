package com.company.view;

import com.company.controller.MainController;

import javax.swing.*;
import java.awt.*;

public class ProductsEdit {
    private MainController controller;



    public ProductsEdit(MainController controller) {
        this.controller = controller;
    }

    public void init(){

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();


        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        frame.setBounds(dimension.width / 2 - 250, dimension.height / 2 - 200,
                500, 600);
        frame.setTitle("Products Edit");

        panel.setBackground(Color.black);


        JButton MainWindowButton = new JButton("To main window");
        panel.add(MainWindowButton);

        JButton SaveButton = new JButton("Save");
        panel.add(SaveButton);

        JTable table = new JTable(controller.getProductsEdit(), controller.getColumnNamesProductsEdit());
        table.setRowHeight(30);
        table.setShowVerticalLines(false);
        table.setShowHorizontalLines(false);
        JScrollPane pane = new JScrollPane(table);
        panel.add(pane);

        MainWindowButton.addActionListener(e -> {

            frame.dispose();
            Menu menu = new Menu(controller);
            menu.init();

        });

        SaveButton.addActionListener(e -> {

            controller.saveProducts(table);
            frame.dispose();
            Menu menu = new Menu(controller);
            menu.init();

        });

        frame.setVisible(true);
        frame.setContentPane(panel);
    };

}
