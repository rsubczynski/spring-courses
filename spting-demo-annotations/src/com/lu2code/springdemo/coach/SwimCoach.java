package com.lu2code.springdemo.coach;

import org.springframework.beans.factory.annotation.Value;

import com.lu2code.springdemo.services.FortuneServices;

public class SwimCoach implements Coach {

	@Value("${foo.email}")
	String email;

	@Value("${foo.team}")
	String team;

	public String getTeam() {
		return team;
	}

	public String getEmail() {
		return email;
	}

	public FortuneServices getFortuneService() {
		return fortuneService;
	}

	private FortuneServices fortuneService;

	public SwimCoach(FortuneServices fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Swim 1000 meters as a warm up";
	}

	@Override
	public String getDayliFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
