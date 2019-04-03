package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class AfterFinalyDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		List<Account> theAccounts = null;

		try {
			boolean tripWire = false;
			theAccountDAO.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("\n\n Main Program... caught exception: " + e);
		}
		System.out.println("\n\n Main Program: AfterThrowingDemoApp");
		System.out.println("-----------------------------------------");
		System.out.println(theAccounts);

	
		System.out.println("\n");
	}

}
