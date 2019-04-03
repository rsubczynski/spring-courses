package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class AfterRetuningDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		//call method to find the accounts
		List<Account> theAccounts = theAccountDAO.findAccounts();
		
		System.out.println("\n\n Main Program: AfterReturningDemoApp");
		System.out.println("-----------------------------------------");
		System.out.println(theAccounts);
		
		System.out.println("\n");
	}

}

