package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

		Account myAccount = new Account();
		boolean vipFlag = true;
		theAccountDAO.addAccount(myAccount, vipFlag);
		theAccountDAO.doWork();
		
		theAccountDAO.setName("radek");
		theAccountDAO.setServiceCode("01");
		theAccountDAO.getName();
		theAccountDAO.getServiceCode();
		
		theMembershipDAO.addSillyMember();
		theMembershipDAO.doToSleep();
		context.close();
	}

}
