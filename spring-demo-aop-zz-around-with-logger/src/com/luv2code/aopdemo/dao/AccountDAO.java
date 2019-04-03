package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;

	private String serviceCode;

	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass() + ": DOING MY BD WORK : ADDING AN ACCOUNT");
	}

	public List<Account> findAccounts(boolean tripWire) {

		if (tripWire) {
			throw new RuntimeException("No soup for you!");
		}
		List<Account> myAccounts = new ArrayList<>();
		myAccounts.add(new Account("Radek", "Pro"));
		myAccounts.add(new Account("Adam", "Junior"));
		myAccounts.add(new Account("Maciek", "Mid"));
		return myAccounts;
	}

	public boolean doWork() {
		System.out.println(getClass() + ": in doWork()");
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
		System.out.println(getClass() + ": setServiceCode()");

		this.serviceCode = serviceCode;
	}

}
