package com.aopafterreturning.dao;


import com.aopafterreturning.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;
	
	public void addAccount(Account theAccount, boolean vipFlag) {
		
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT, isVip:  "+ vipFlag);
		
	}
	
	public boolean doWork() {
		
		System.out.println(getClass() + ": doWork()");
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
		System.out.println(getClass() + ": in getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": in setServiceCode()");
		this.serviceCode = serviceCode;
	}

	public List<Account> findAccounts(){
		List<Account> myAccounts = new ArrayList<>();
		//create sample accs
		Account temp1 = new Account("John", "Silver");
		Account temp2 = new Account("Adam", "Gold");
		//add these to the list
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		System.out.println("inside findAccounts method");
		return  myAccounts;
	}

	public List<Account> simulatingAfterThrowing(boolean foo){
		// @AfterThrowing used for when join-point method couldn't finish successfully and throwing an exception.
		System.out.println("Currently, we are in the simulatingAfterThrowing() method");
		if(foo){
		throw new RuntimeException("You shall not pass!!!");
		}
		else{
			List<Account> myAccs = new ArrayList<Account>(){{add(new Account("Mert","Çömez"));}};
			return myAccs;
		}
	}
	
	
	
}





