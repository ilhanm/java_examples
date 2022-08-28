package com.aopdemo;

import com.aopdemo.dao.AccountDAO;
import com.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args){
        //read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        //get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
        Account accountFromSpringContainer = context.getBean("account", Account.class);
        //call the business method
        Account theAcc = new Account();
        theAcc.setLevel("expert");
        System.out.println("---------------");
        theAccountDAO.addAccount(theAcc);
        membershipDAO.addAccount();
        System.out.println("------Below Account obj is created from spring container-------");
        accountFromSpringContainer.accountInfo();
        //close the context
        context.close();
    }
}
