package com.lu2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		Coach coach = context.getBean("myCricketCoach", Coach.class);

		System.out.println(coach.getDailyWorkout());
		
		System.out.println(coach.getDailyFortune());

		System.out.println(coach.getTeam());

		System.out.println(coach.getEmailAdress());

		context.close();

	}

}
