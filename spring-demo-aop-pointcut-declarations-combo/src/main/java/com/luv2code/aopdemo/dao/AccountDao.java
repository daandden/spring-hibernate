package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDao {

    private String name;
    private String serviceCode;

    public String addAccount(Account account, boolean vipFlag) {

        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
        return "";
    }

    public boolean doWork() {
        System.out.println(getClass() + " do work");
        return false;
    }

    public String getName() {
        System.out.println(getClass() + ": in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": inGetServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": in setServiceCode()");
        this.serviceCode = serviceCode;
    }
}
