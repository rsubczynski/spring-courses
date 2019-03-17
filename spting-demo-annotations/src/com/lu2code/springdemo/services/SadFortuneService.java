package com.lu2code.springdemo.services;

public class SadFortuneService implements FortuneServices {

	@Override
	public String getFortune() {
		return "Today is sad day";
	}

}
