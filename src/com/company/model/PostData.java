package com.company.model;

import java.sql.*;
import java.util.ArrayList;

public class PostData {
    // JDBC URL, username and password of MySQL server
    private static final String url = "jdbc:mysql://localhost:3306/product-company";
    private static final String user = "root";
    private static final String password = "246D531d";

    // JDBC variables for opening and managing connection
    private static Connection con;
    private static Statement stmt;
    //private static ResultSet rs;


    private static Model model;

    ArrayList<Company> companies = new ArrayList<>();
    ArrayList<Product> products = new ArrayList<>();
    ArrayList<PriceList> priceLists = new ArrayList<>();

    public PostData(Model model) {
        this.model = model;
    }


    public static void postProduct(Model model, int id) {
        String query = "update product set product_name = '" + model.getProducts().get(id).getProduct_name()+ "', product_type = '"+model.getProducts().get(id).getProduct_type()+"' where id_product ="+(id+1)+" ;";


        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            stmt.executeUpdate(query);


        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            //try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }
    }


    public static void postCompany(Model model, int id) {
        String query = "update company set company_name ='"+model.getCompany().get(id).getCompany_name()+
                                            "', company_location ='"+ model.getCompany().get(id).getCompany_location()+
                                            "', company_phone='"+ Integer.toString(model.getCompany().get(id).getCompany_phone())+
                                            "', company_headman_name='"+model.getCompany().get(id).getCompany_headman_name()+
                                            "', company_marketing_phone='"+Integer.toString(model.getCompany().get(id).getCompany_marketing_phone())+
                                            "', company_marketing_headman_phone='"+Integer.toString(model.getCompany().get(id).getCompany_marketing_headman_phone())+
                                            "', company_contact_name='"+model.getCompany().get(id).getCompany_contact_name()+
                                            "' where id_company ="+(id+1)+" ;";


        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            stmt.executeUpdate(query);


        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            //try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }

    }
}
