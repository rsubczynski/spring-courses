package com.lu2code.springdemo.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lu2code.springdemo.coach.Coach;
import com.lu2code.springdemo.coach.SwimCoach;

import configuration.SportConfig;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);

		System.out.println(theCoach.getDailyWorkout());

		System.out.println(theCoach.getDayliFortune());
		
		System.out.println(theCoach.getEmail());
		
		System.out.println(theCoach.getTeam());

		context.close();
	}

}
