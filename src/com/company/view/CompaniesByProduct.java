package com.company.view;

import com.company.controller.MainController;

import javax.swing.*;
import java.awt.*;

public class CompaniesByProduct {
    private MainController controller;

    public CompaniesByProduct(MainController controller) {
        this.controller = controller;
    }

    public void init(String product) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();


        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        frame.setBounds(dimension.width / 2 - 250, dimension.height / 2 - 200,
                500, 600);
        frame.setTitle("Companies produce " + product);

        panel.setBackground(Color.black);


        JButton MainWindowButton = new JButton("To main window");
        panel.add(MainWindowButton);


        JTable table = new JTable(controller.getCompaniesByProduct(product), controller.getColumnNamesCompaniesByProduct());
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

        frame.setVisible(true);
        frame.setContentPane(panel);
    }
}
