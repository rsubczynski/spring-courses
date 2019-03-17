package com.lu2code.springdemo.coach;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.lu2code.springdemo.services.FortuneServices;

@Component
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneServices fortuneService;

	TennisCoach() {
		System.out.println(">> TennisCoach inside default constructor");
	}
	
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println(">> TennisCoach inside of doMyStartupStuff");
	}
	
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println(">> TennisCoach inside of doMyCleanupStuff");

	}

//	@Autowired
//	TennisCoach(FortuneServices fortuneService) {
//		this.fortuneService = fortuneService;
//	}

//	@Autowired
//	public void setFortuneServices(FortuneServices fortuneService) {
//		System.out.println(">> TennisCoach inside setFortuneServices()");
//		this.fortuneService = fortuneService;
//	}

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDayliFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
