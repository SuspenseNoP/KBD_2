package com.company.model;

public class Company {
    private String company_name, company_location, company_contact_name, company_headman_name;


    private int id_company, company_phone, company_marketing_phone, company_marketing_headman_phone;

    public Company(int id_company, String company_name,String company_location, int company_phone,
                   String company_headman_name, int company_marketing_phone,
                   int company_marketing_headman_phone,String company_contact_name){
        this.id_company = id_company;
        this.company_name = company_name;
        this.company_location = company_location;
        this.company_phone = company_phone;
        this.company_headman_name = company_headman_name;
        this.company_marketing_phone = company_marketing_phone;
        this.company_marketing_headman_phone = company_marketing_headman_phone;
        this.company_contact_name = company_contact_name;
    }


    public int getCompany_marketing_headman_phone() {
        return company_marketing_headman_phone;
    }

    public void setCompany_marketing_headman_phone(int company_marketing_headman_phone) {
        this.company_marketing_headman_phone = company_marketing_headman_phone;
    }

    public int getCompany_marketing_phone() {
        return company_marketing_phone;
    }

    public void setCompany_marketing_phone(int company_marketing_phone) {
        this.company_marketing_phone = company_marketing_phone;
    }

    public String getCompany_contact_name() {
        return company_contact_name;
    }

    public void setCompany_contact_name(String company_contact_name) {
        this.company_contact_name = company_contact_name;
    }

    public void setCompany_location(String company_location) {
        this.company_location = company_location;
    }

    public String getCompany_headman_name() {
        return company_headman_name;
    }

    public void setCompany_headman_name(String company_headman_name) {
        this.company_headman_name = company_headman_name;
    }

    public int getCompany_phone() {
        return company_phone;
    }

    public void setCompany_phone(int company_phone) {
        this.company_phone = company_phone;
    }

    public String getCompany_location() {
        return company_location;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public int getId_company() {
        return id_company;
    }

    public void setId_company(int id_company) {
        this.id_company = id_company;
    }


}

