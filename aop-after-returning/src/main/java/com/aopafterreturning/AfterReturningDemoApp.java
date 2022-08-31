package com.aopafterreturning;

import com.aopafterreturning.dao.AccountDAO;
import com.aopafterreturning.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturningDemoApp {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        List<Account> accounts = theAccountDAO.findAccounts();
        System.out.println(accounts);

    }


}
