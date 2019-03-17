package com.lu2code.springdemo;

import java.awt.List;
import java.util.ArrayList;
import java.util.Random;

public class DIFortuneServices implements FortuneService {
 
	@Override
	public String getFortune() {
		return getRandomFortune();
	}
	
	public String getRandomFortune() {
		ArrayList<String> fortuneList = new ArrayList<String>();
		fortuneList.add("Gogogo");
		fortuneList.add("Gogogo1");
		fortuneList.add("Gogogo3");
		
		return fortuneList.get(new Random().nextInt(fortuneList.size()-0)+0);
		
	}
}
