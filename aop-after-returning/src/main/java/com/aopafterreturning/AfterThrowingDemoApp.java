package com.aopafterreturning;

import com.aopafterreturning.dao.AccountDAO;
import com.aopafterreturning.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterThrowingDemoApp {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
        try{
            List<Account> accounts = theAccountDAO.simulatingAfterThrowing(true);
            System.out.println(accounts);
        }
        catch (Exception ex){
            System.out.println("In main program .. caught an exception: "+ ex);
        }


    }


}
