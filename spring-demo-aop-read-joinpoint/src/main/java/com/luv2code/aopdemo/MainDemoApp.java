package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.Account;
import com.luv2code.aopdemo.dao.AccountDao;
import com.luv2code.aopdemo.dao.MembershipDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDao accountDao = context.getBean("accountDao", AccountDao.class);

        // get membership bean form spring container
        MembershipDao membershipDao = context.getBean("membershipDao", MembershipDao.class);


        // call the business method
        Account account = new Account();
        accountDao.addAccount(account, true);
        accountDao.doWork();

        // call the accountDao getter/setter methods
        accountDao.setName("foobar");
        accountDao.setServiceCode("silver");

        String name = accountDao.getName();
        String code = accountDao.getServiceCode();

        // call the membership business method
        membershipDao.addSillyAccount();
        membershipDao.goToSleep();

        // close the context
        context.close();

    }
}
