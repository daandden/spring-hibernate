package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDao {

    public void addSillyAccount() {

        System.out.println(getClass().getSimpleName() + ": DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");

    }

    public void goToSleep() {
        System.out.println(getClass() + "go to sleep");
    }
}
