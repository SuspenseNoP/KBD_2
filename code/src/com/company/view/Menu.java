package com.company.view;

import com.company.controller.MainController;

import javax.swing.*;
import java.awt.*;

public class Menu {
    private MainController controller;



    public Menu(MainController controller) {
        this.controller = controller;
    }

    public void init() {

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(null);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        frame.setBounds(dimension.width / 2 - 200, dimension.height / 2 - 250, 400, 500);
        frame.setTitle("Menu");

        panel.setBackground(Color.black);

        JButton EditProductButton;

        EditProductButton = new JButton("Edit Product Table");
        EditProductButton.setLocation(40, 50);
        EditProductButton.setSize(300, 50);
        EditProductButton.setBackground(Color.darkGray);
        EditProductButton.setForeground(Color.LIGHT_GRAY);
        panel.add(EditProductButton);


        EditProductButton.addActionListener(e -> {

            frame.dispose();
            ProductsEdit productsEdit = new ProductsEdit(controller);
            productsEdit.init();
        });

        JButton EditCompanyButton;
        EditCompanyButton = new JButton("Edit Company Table");
        EditCompanyButton.setLocation(40, 150);
        EditCompanyButton.setSize(300, 50);
        EditCompanyButton.setBackground(Color.darkGray);
        EditCompanyButton.setForeground(Color.LIGHT_GRAY);
        panel.add(EditCompanyButton);

        EditCompanyButton.addActionListener(e -> {

            frame.dispose();
            CompaniesEdit companiesEdit = new CompaniesEdit(controller);
            companiesEdit.init();


        });

        JButton SearchButton;
        SearchButton = new JButton("Search");
        SearchButton.setLocation(40, 250);
        SearchButton.setSize(300, 50);
        SearchButton.setBackground(Color.darkGray);
        SearchButton.setForeground(Color.LIGHT_GRAY);
        panel.add(SearchButton);

        SearchButton.addActionListener(e -> {

            frame.dispose();
            SearchMenu searchMenu = new SearchMenu(controller);
            searchMenu.init();

        });

        JButton ExitButton;
        ExitButton = new JButton("Exit");
        ExitButton.setLocation(40, 350);
        ExitButton.setSize(300, 50);
        ExitButton.setBackground(Color.darkGray);
        ExitButton.setForeground(Color.LIGHT_GRAY);
        panel.add(ExitButton);

        ExitButton.addActionListener(e -> {

            frame.dispose();
            ByeWindow byeWindow = new ByeWindow(controller);
            byeWindow.init();

        });


        frame.setVisible(true);
        frame.setContentPane(panel);
    };
}
