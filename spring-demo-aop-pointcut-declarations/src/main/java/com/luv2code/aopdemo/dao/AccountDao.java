package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDao {

    public String addAccount(Account account, boolean vipFlag) {

        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
        return "";
    }

    public boolean doWork() {
        System.out.println(getClass() + " do work");
        return false;
    }

}
