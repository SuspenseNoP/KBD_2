package com.company.model;

import java.util.ArrayList;

public class Model {

    private ArrayList<Product> products;

    public String[] getColumnNamesCompaniesByProduct() {
        return columnNamesCompaniesByProduct;
    }

    private String[] columnNamesCompaniesByProduct;

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }



    private ArrayList<Company> company;

    public ArrayList<Company> getCompany() {
        return company;
    }

    public void setCompany(ArrayList<Company> company) {
        this.company = company;
    }


    private ArrayList<PriceList> priceLists;


    public ArrayList<PriceList> getPriceLists() {
        return priceLists;
    }

    public void setPriceLists(ArrayList<PriceList> priceLists) {
        this.priceLists = priceLists;
    }







    private String[] columnNamesProduct = {"id_product", "product_name","product_type"};

    public String[] getColumnNamesProduct() {
        return columnNamesProduct;
    }

    public void setColumnNamesProduct(String[] columnNamesProduct) {
        this.columnNamesProduct = columnNamesProduct;
    }

    public String[] getColumnNamesCompanyEdit() {
        return columnNamesCompanyEdit;
    }

    public void setColumnNamesCompanyEdit(String[] columnNamesCompanyEdit) {
        this.columnNamesCompanyEdit = columnNamesCompanyEdit;
    }

    private String[] columnNamesCompanyEdit = {"id_company", "company_name","company_location", "company_phone", "company_headman_name","company_marketing_phone", "company_marketing_headman_phone", "company_contact_name"};

    private String[] columnNamesCompany;
    public String[] getColumnNamesCompany() {
        return columnNamesCompany;
    }

    public void setColumnNamesCompany(String[] columnNamesCompany) {
        this.columnNamesCompany = columnNamesCompany;
    }



    private String[] columnNamesPriceList = {"num", "id_product","price", "id_company"};

    public String[] getColumnNamesPriceList() {
        return columnNamesPriceList;
    }

    public void setColumnNamesPriceList(String[] columnNamesPriceList) {
        this.columnNamesPriceList = columnNamesPriceList;
    }

    public void setProductByCompany(ArrayList<ArrayList<String>> productByCompany) {
        this.productByCompany = productByCompany;
    }

    private ArrayList<ArrayList<String>> productByCompany;

    public void setColumnNamesProductByCompany(String[] columnNamesProductByCompany) {
        this.columnNamesProductByCompany = columnNamesProductByCompany;
    }

    private String[] columnNamesProductByCompany;

    public ArrayList<ArrayList<String>> getProductCompanies() {
        return productCompanies;
    }

    public void setProductCompanies(ArrayList<ArrayList<String>> productCompanies) {
        this.productCompanies = productCompanies;
    }

    private ArrayList<ArrayList<String>> productCompanies;

    public void setCompaniesByProduct(ArrayList<ArrayList<String>> companiesByProduct) {
        this.companiesByProduct = companiesByProduct;
    }

    private ArrayList<ArrayList<String>> companiesByProduct;

    public ArrayList<ArrayList<String>> getProductByCompanyData(String companyName) {
        productByCompany = GetData.productByCompany(companyName);
        return productByCompany;
    }

    public String[] getColumnNamesProductByCompany() {
        return columnNamesProductByCompany;
    }

    public ArrayList<ArrayList<String>> getCompaniesByProduct(String productName) {
       companiesByProduct = GetData.companiesByProduct(productName);
        return companiesByProduct;
    }

    public void setColumnNamesCompaniesByProduct(String[] columnNamesCompaniesByProduct) {
        this.columnNamesCompaniesByProduct = columnNamesCompaniesByProduct;
    }


    //private List<Graphic> graphics;

    /*public List<Graphic> getGraphics() {
        return graphics;
    }

    public void setGraphics(List<Graphic> graphics) {
        this.graphics = graphics;
    }*/
}
