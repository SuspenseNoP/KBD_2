package com.company.model;

public class PriceList {
    private int id_product;
    private int id_company;
    private int price;

    public PriceList(int id_product, int price, int id_company){
        this.id_product = id_product;
        this.price=price;
        this.id_company=id_company;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }



    public int getId_company() {
        return id_company;
    }

    public void setId_company(int id_company) {
        this.id_company = id_company;
    }



    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }




}
