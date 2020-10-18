package com.company.controller;

//import com.company.model.Graphic;
import com.company.model.Company;
import com.company.model.Model;
import com.company.model.PostData;
import com.company.model.Product;

import javax.swing.*;
import java.util.ArrayList;

public class MainController {

    private Model model;
    public MainController(Model model) {
        this.model = model;
    }

    public String[][] getCompanies() {
  return convertCompanyData(model.getCompany());
    }

    public String[][] convertCompanyData(ArrayList<Company> companies) {
        String[][] data = new String[companies.size()][4];

        for ( int i = 0; i < companies.size(); i++) {
            data[i][0] = companies.get(i).getCompany_name();
            data[i][1] = Integer.toString(companies.get(i).getCompany_phone());
            data[i][2] = companies.get(i).getCompany_headman_name();
            data[i][3] = companies.get(i).getCompany_contact_name();
        }
        return data;
    }
    public String[] getColumnNamesCompanies() {
        return model.getColumnNamesCompany();
    }

    public String[][] getProductsByCompany(String companyName) {
        ArrayList<ArrayList<String>> data = model.getProductByCompanyData(companyName);
        String[][] productsByCompany = new String[data.size()][data.get(0).size()];

        for(int i=0; i<data.size(); i++){
            for(int j=0; j<data.get(0).size(); j++){
            productsByCompany[i][j] = data.get(i).get(j);
        }}
       return productsByCompany;
    }

    public String[] getColumnNamesProductByCompany() {
        return model.getColumnNamesProductByCompany();
    }

    public String[] getCompaniesName() {
        String[][] data = getCompanies();
        String[] companiesNames = new String[data.length];
        for (int i=0; i<data.length; i++){
            companiesNames[i] = data[i][0];
        }
        return companiesNames;
    }

    public String[] getProductsName() {
        String[][] data = getProducts();
        String[] productsNames = new String[data.length];
        for (int i=0; i<data.length; i++){
            productsNames[i] = data[i][1];
        }
        return productsNames;
    }

    private String[][] getProducts() {
        return convertProductData(model.getProducts());
    }

    private String[][] convertProductData(ArrayList<Product> products) {
        String[][] data = new String[products.size()][3];

        for ( int i = 0; i < products.size(); i++) {
            data[i][1] = products.get(i).getProduct_name();
            data[i][0] = Integer.toString(products.get(i).getId_product());
            data[i][2] = products.get(i).getProduct_type();
        }
        return data;
    }

    public String[][] getCompaniesByProduct(String product) {
        ArrayList<ArrayList<String>> data = model.getCompaniesByProduct(product);
        String[][] companiesByProduct = new String[data.size()][data.get(0).size()];

        for(int i=0; i<data.size(); i++){
            for(int j=0; j<data.get(0).size(); j++){
                companiesByProduct[i][j] = data.get(i).get(j);
            }}
        return companiesByProduct;
    }

    public String[] getColumnNamesCompaniesByProduct() {
        return model.getColumnNamesCompaniesByProduct();
    }

    public String[][] getCompaniesEdit() {

        return convertCompanyEdit(model.getCompany());
    }

    private String[][] convertCompanyEdit(ArrayList<Company> companies) {
        String[][] data = new String[companies.size()][8];

        for ( int i = 0; i < companies.size(); i++) {
            data[i][0] = Integer.toString(companies.get(i).getId_company());
            data[i][1] = companies.get(i).getCompany_name();
            data[i][2] = companies.get(i).getCompany_location();
            data[i][3] = Integer.toString(companies.get(i).getCompany_phone());
            data[i][4] = companies.get(i).getCompany_headman_name();
            data[i][5] = Integer.toString(companies.get(i).getCompany_marketing_phone());
            data[i][6] = Integer.toString(companies.get(i).getCompany_marketing_headman_phone());
            data[i][7] = companies.get(i).getCompany_contact_name();
        }

        return data;
    }

    public String[] getColumnNamesCompaniesEdit() {

        return model.getColumnNamesCompanyEdit();
    }

    public String[][] getProductsEdit() {

        return getProducts();
    }

    public String[] getColumnNamesProductsEdit() {
        return model.getColumnNamesProduct();
    }

    public void saveProducts(JTable table) {
        //System.out.println(table.getValueAt(0,0));
        ArrayList<Product> products = model.getProducts();
        for(int i=0; i<products.size(); i++){
            products.get(i).setId_product(Integer.parseInt((String) table.getValueAt( i,0)));
            products.get(i).setProduct_name((String) table.getValueAt( i,1));
            products.get(i).setProduct_type((String) table.getValueAt( i,2));
        }
        model.setProducts(products);
        for(int i =0; i<products.size(); i++) {
            PostData.postProduct(model, i);
        }
    }

    public void saveCompanies(JTable table) {
        ArrayList<Company> company = model.getCompany();
        for(int i=0; i<company.size(); i++){
            company.get(i).setId_company(Integer.parseInt((String) table.getValueAt( i,0)));
            company.get(i).setCompany_name((String) table.getValueAt( i,1));
            company.get(i).setCompany_location((String) table.getValueAt( i,2));
            company.get(i).setCompany_phone(Integer.parseInt((String) table.getValueAt( i,3)));
            company.get(i).setCompany_headman_name((String) table.getValueAt( i,4));
            company.get(i).setCompany_marketing_phone(Integer.parseInt((String) table.getValueAt( i,5)));
            company.get(i).setCompany_marketing_headman_phone(Integer.parseInt((String) table.getValueAt( i,6)));
            company.get(i).setCompany_contact_name((String) table.getValueAt( i,7));
        }
        model.setCompany(company);
        for(int i =0; i<company.size(); i++) {
            PostData.postCompany(model,i);
        }

    }

  /*  private double scale = 32;





    public void changeScale(double number) {
        if (scale * number <= 2048 & scale * number >= 8) {
            scale = (int) (scale * number);
        }
    }

    public double getScale() {
        return scale;
    }

    public void createNewFirstGraphic(int from, int to) {
        List<Graphic> data = model.getGraphics();

        ArrayList<Double> x = new ArrayList<>(), y = new ArrayList<>();
        int a = 0, length = 0;

        for (double i = from; i <= to; i += 0.1) {
            x.add((double) i);
            Double tempY = Math.pow(x.get(length), 3);
            y.add(tempY);
            length++;
        }

        Graphic newGraph = new Graphic(x, y, from, to, a, 1);
        if (data == null) {
            ArrayList<Graphic> temp = new ArrayList<>();
            temp.add(newGraph);
            data = temp;
        } else {
            if (data.size() < 5) {
                data.add(newGraph);
            }
        }

        model.setGraphics(data);
    }


    public void createNewSecondGraphic(int from, int to, int a) {
        List<Graphic> data = model.getGraphics();
        ArrayList<Double> x = new ArrayList<>(), y = new ArrayList<>();
        int length = 0;

        for (double i = from; i <= to; i += 0.1) {
            x.add((double) i);

            double[] mas = new double[50];
            double sum = 0;
            mas[0] = 0;
            for (int k = 1; k < 50; k++) {
                mas[k] = (Math.pow(-1, k)) * ((a * Math.pow(x.get(length), 2 * k + 1)) / Factorial.factorial(k));
                if (mas[k] - mas[k - 1] > 0.01) {
                    sum += mas[k];
                }
            }

            Double tempY = sum;
            y.add(tempY);
            length++;
        }

        Graphic newGraph = new Graphic(x, y, from, to, a, 2);
        if (data == null) {
            ArrayList<Graphic> temp = new ArrayList<>();
            temp.add(newGraph);
            data = temp;
        } else {
            if (data.size() < 5) {
                data.add(newGraph);
            }
        }
        model.setGraphics(data);
    }

    public ArrayList<Double> getX(int index) {
        ArrayList<Double> xs= new ArrayList<Double>(model.getGraphics().get(index).getX());
        return xs;
    }

    public int getNumOfGraphics() {
        List<Graphic> data = model.getGraphics();
        if (data == null) {
            return 0;
        } else {
            return data.size();
        }
    }

    public ArrayList<Double> getY(int index) {
        ArrayList<Double> ys= new ArrayList<Double>(model.getGraphics().get(index).getY());
        return ys;
    }

    public void deleteData() {
        ArrayList<Graphic> data = new ArrayList<>();
        model.setGraphics(data);
    }

    public int getFormula(int j) {
        return model.getGraphics().get(j).getType();
    }

    public int getFromX(int j) {
        return model.getGraphics().get(j).getxFrom();
    }

    public int getToX(int j) {
        return model.getGraphics().get(j).getxTo();
    }

    public int getA(int j) {
        return model.getGraphics().get(j).getA();
    }


    public String[] getColumns() {
        String[] columns = new String[getNumOfGraphics() + 1];
        columns[0] = "x";
        for (int i = 1; i < getNumOfGraphics() + 1; i++) {
            columns[i] = "y" + Integer.toString(i);
        }
        return columns;
    }

    public String[][] getData() {
        if (getNumOfGraphics() == 0) {
            return new String[0][1];
        } else {
            int[] numOfX = new int[getNumOfGraphics()];
            for (int i = 0; i < numOfX.length; i++) {
                numOfX[i] = (getToX(i) - getFromX(i)) * 10;
            }
            int max = 0;
            int indexMax = 0;


            for (int i = 0; i < numOfX.length; i++) {
                if (numOfX[i] > max) {
                    max = numOfX[i];
                    indexMax = i;
                }
            }

            String[][] data = new String[max][getNumOfGraphics() + 1];
            for (int j = 0; j < max; j++) {
                data[j][0] = String.valueOf((double) getX(indexMax).get(j));
            }
            for (int k = 0; k < getNumOfGraphics(); k++) {
                int step = 0;
                for (int r = 0; r < max; r++) {
                    long one = Math.round(getX(indexMax).get(r) * 10);
                    long two = Math.round(getX(k).get(0) * 10);
                    if (two >= one) {
                        step = r;
                    }
                }
                for (int m = 0; m < max; m++) {
                    if (m < step) {
                        data[m][k + 1] = "-";
                    }
                    if (m < getY(k).size() + step && m >= step) {

                        data[m][k + 1] = String.valueOf((double) getY(k).get(m - step));
                    } else {
                        data[m][k + 1] = "-";
                    }
                }
            }

            return data;
        }
    }*/
}
