package com.company;

import com.company.controller.MainController;
import com.company.model.GetData;
import com.company.model.Model;
import com.company.view.HiWindow;

public class Main {
    /*

    // JDBC URL, username and password of MySQL server
    private static final String url = "jdbc:mysql://localhost:3306/product-company";
    private static final String user = "root";
    private static final String password = "246D531d";

    // JDBC variables for opening and managing connection
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public static void main(String args[]) {
        String query = "select * from company";

        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                int count = rs.getInt(1);
                System.out.println("Total number of books in the table : " + count);
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try { con.close(); } catch(SQLException se) {  }
            try { stmt.close(); } catch(SQLException se) {}
            try { rs.close(); } catch(SQLException se) {  }
        }
    }
*/
    public static void main(String args[]) {
        Model model = new Model();
        GetData getData = new GetData(model);
        getData.readDatabase();
        MainController controller = new MainController(model);
        HiWindow hiWindow = new HiWindow(controller);
        hiWindow.init();
    }
}