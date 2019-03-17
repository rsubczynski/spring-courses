package com.lu2code.springdemo;

public class HappyFurtuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is your lucky day!";
	}

}
