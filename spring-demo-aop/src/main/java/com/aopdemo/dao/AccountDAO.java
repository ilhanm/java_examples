package com.aopdemo.dao;

import com.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
    public void addAccount(Account theAccount){
        System.out.println( getClass() + " Doing my DB WORK for "+ theAccount +" !");
    }
}