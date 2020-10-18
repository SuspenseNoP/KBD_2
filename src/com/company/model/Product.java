package com.company.model;

public class Product {
    private String product_type;
    private String product_name;
    private int id_product;

    public Product(int id_product, String product_name, String product_type){
        this.id_product = id_product;
        this.product_name = product_name;
        this.product_type = product_type;
    }


    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }


    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }



}
