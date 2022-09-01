package com.aopafterreturning.aspect;

import com.aopafterreturning.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	@Before("com.aopafterreturning.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {

		System.out.println("\n=====>>> Executing @Before advice on method");

		// display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();

		System.out.println("Method: " + methodSig);

		// display method arguments

		// get args
		Object[] args = theJoinPoint.getArgs();

		// loop thru args
		for (Object tempArg : args) {
			System.out.println(tempArg);

			if (tempArg instanceof Account) {

				// downcast and print Account specific stuff
				Account theAccount = (Account) tempArg;

				System.out.println("account name: " + theAccount.getName());
				System.out.println("account level: " + theAccount.getLevel());

			}
		}
	}

	// add a new advice for AfterReturning on the findAccounts method
	@AfterReturning(pointcut = ("execution (* com.aopafterreturning.dao.AccountDAO.findAccounts(..))"),
	returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result){
		MethodSignature mySign = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("After AOP Method Signature: " +mySign);
		System.out.println("results before post-processing: " + result);
		makeFirstNameUppercaseAccounts(result);
		System.out.println("results after post-processing: " + result);
	}

	@AfterThrowing(pointcut = ("execution(* com.aopafterreturning.dao.AccountDAO.*(..))") , throwing = "ex")
	public void afterThrowingFindAccountsAdvice(Exception ex){
		System.out.println("Exception occurred: " + ex);
	}

	private void makeFirstNameUppercaseAccounts(List<Account> accounts) {
		for(Account account: accounts){
			String name = account.getName().toUpperCase();
			account.setName(name);
		}
	}


}










