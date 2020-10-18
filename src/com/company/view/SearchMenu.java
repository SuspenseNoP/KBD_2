package com.company.view;

import com.company.controller.MainController;

import javax.swing.*;
import java.awt.*;

public class SearchMenu {
    private MainController controller;



    public SearchMenu(MainController controller) {
        this.controller = controller;
    }

    public void init() {

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(null);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        frame.setBounds(dimension.width / 2 - 200, dimension.height / 2 - 250, 400, 500);
        frame.setTitle("Search Menu");

        panel.setBackground(Color.black);

        JButton ProductsByCompanyButton;

        ProductsByCompanyButton = new JButton("Products produced by company");
        ProductsByCompanyButton.setLocation(40, 50);
        ProductsByCompanyButton.setSize(300, 50);
        ProductsByCompanyButton.setBackground(Color.darkGray);
        ProductsByCompanyButton.setForeground(Color.LIGHT_GRAY);
        panel.add(ProductsByCompanyButton);


        ProductsByCompanyButton.addActionListener(e -> {

            frame.dispose();
            CompanyChoice companyChoice = new CompanyChoice(controller);
            companyChoice.init();

        });

        JButton CompaniesProductButton;
        CompaniesProductButton = new JButton("Companies produce product");
        CompaniesProductButton.setLocation(40, 150);
        CompaniesProductButton.setSize(300, 50);
        CompaniesProductButton.setBackground(Color.darkGray);
        CompaniesProductButton.setForeground(Color.LIGHT_GRAY);
        panel.add(CompaniesProductButton);

        CompaniesProductButton.addActionListener(e -> {

            frame.dispose();
            ProductChoice productChoice = new ProductChoice(controller);
            productChoice.init();

        });

        JButton AllCompaniesButton;
        AllCompaniesButton = new JButton("All Companies");
        AllCompaniesButton.setLocation(40, 250);
        AllCompaniesButton.setSize(300, 50);
        AllCompaniesButton.setBackground(Color.darkGray);
        AllCompaniesButton.setForeground(Color.LIGHT_GRAY);
        panel.add(AllCompaniesButton);

        AllCompaniesButton.addActionListener(e -> {

            frame.dispose();
            Companies  companies = new Companies(controller);
            companies.init();


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
            Menu menu = new Menu(controller);
            menu.init();

        });


        frame.setVisible(true);
        frame.setContentPane(panel);
    };
}
