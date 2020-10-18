package com.company.model;

import com.company.controller.MainController;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GetData {
    // JDBC URL, username and password of MySQL server
    private static final String url = "jdbc:mysql://localhost:3306/product-company";
    private static final String user = "root";
    private static final String password = "246D531d";

    // JDBC variables for opening and managing connection
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;


    private static Model model;

    ArrayList<Company> companies = new ArrayList<>();
    ArrayList<Product> products = new ArrayList<>();
    ArrayList<PriceList> priceLists = new ArrayList<>();

    public GetData(Model model) {
        this.model = model;
    }

    public static ArrayList<ArrayList<String>> companiesByProduct(String productName) {
        String query4 = "select product.product_name , company.company_name, company.company_location from company , product, pricelist where company.id_company = pricelist.id_company and product.id_product = pricelist.id_product and product.product_name = '"+ productName +"';";




        String[] columnNamesCompaniesByProduct = new String[] {"product_name", "company_name", "company_location"};
        model.setColumnNamesCompaniesByProduct(columnNamesCompaniesByProduct);

        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            rs = stmt.executeQuery(query4);


            ArrayList<ArrayList<String>> companiesList= new ArrayList<>();
            while (rs.next()) {
                ArrayList<String> temp = new ArrayList<>();
                temp.add(rs.getString(1));
                temp.add(rs.getString(2));
                temp.add(rs.getString(3));
                companiesList.add(temp);
            }
            return companiesList;
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }

        return null;
    }

    public void readDatabase() {
        String query = "select * from company;";


        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                Company company = new Company(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getString(8));
                companies.add(company);
                //System.out.println(company.getId_company()+company.getCompany_name()+company.getCompany_location()+company.getCompany_marketing_headman_phone()+company.getCompany_headman_name());
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }

        String query2 = "select * from product;";
        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            rs = stmt.executeQuery(query2);

            while (rs.next()) {
                Product product = new Product(rs.getInt(1),rs.getString(2),rs.getString(3));
                products.add(product);
                //System.out.println(product.getId_product()+ product.getProduct_name()+ product.getProduct_type());
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }


    String query3 = "select id_product, price, id_company from pricelist;";
        try {
        // opening database connection to MySQL server
        con = DriverManager.getConnection(url, user, password);

        // getting Statement object to execute query
        stmt = con.createStatement();

        // executing SELECT query
        rs = stmt.executeQuery(query3);

        while (rs.next()) {
            PriceList priceList = new PriceList(rs.getInt(1), rs.getInt(2), rs.getInt(3));
           priceLists.add(priceList);
            //System.out.println(priceList.getPrice());

        }

    } catch (SQLException sqlEx) {
        sqlEx.printStackTrace();
    } finally {
        try { con.close(); } catch(SQLException se) { /*can't do anything */ }
        try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
        try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
    }



        model.setCompany(companies);
        model.setProducts(products);
        model.setPriceLists(priceLists);



        String[] columnNamesCompany = new String[] {"company_name",
                "company_phone","company_headman_name",
                "company_contact_name"};

        model.setColumnNamesCompany(columnNamesCompany);

        String[] columnNamesProduct = new String[] {"id_product", "product_name", "product_type"};

        model.setColumnNamesProduct(columnNamesProduct);

        String[] columnNamesPriceList = new String[] {"id_product", "price", "id_company"};

        model.setColumnNamesPriceList(columnNamesPriceList);

}

    public static ArrayList<ArrayList<String>> productByCompany(String company){
    String query4 = "select company.company_name, product.product_name, pricelist.price from company , product, pricelist where company.id_company = pricelist.id_company and product.id_product = pricelist.id_product and company.company_name ='" + company +"'group by product.product_type;";

   // System.out.println("select company.company_name, product.product_name, pricelist.price from company , product, pricelist where company.id_company = pricelist.id_company and product.id_product = pricelist.id_product and company.company_name = '" + company +"' group by product.product_type;");


    String[] columnNamesProductByCompany = new String[] {"company_name", "product_name", "price"};
    model.setColumnNamesProductByCompany(columnNamesProductByCompany);

    try {
        // opening database connection to MySQL server
        con = DriverManager.getConnection(url, user, password);

        // getting Statement object to execute query
        stmt = con.createStatement();

        // executing SELECT query
        rs = stmt.executeQuery(query4);


ArrayList<ArrayList<String>> productsList= new ArrayList<>();
        while (rs.next()) {
            ArrayList<String> temp = new ArrayList<>();
            temp.add(rs.getString(1));
            temp.add(rs.getString(2));
            temp.add(rs.getString(3));
            productsList.add(temp);
        }
        return productsList;
    } catch (SQLException sqlEx) {
        sqlEx.printStackTrace();
    } finally {
        try { con.close(); } catch(SQLException se) { /*can't do anything */ }
        try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
        try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
    }

return null;
    }



}
