package com.lu2code.springdemo.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lu2code.springdemo.coach.Coach;

import configuration.SportConfig;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		 AnnotationConfigApplicationContext context =
				 new AnnotationConfigApplicationContext(SportConfig.class);
		 
		 Coach theCoach = context.getBean("tennisCoach",Coach.class);
		 
		 System.out.println(theCoach.getDailyWorkout());
		 
		 System.out.println(theCoach.getDayliFortune());
		 
		 context.close();
	}

}
