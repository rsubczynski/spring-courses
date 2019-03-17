package com.lu2code.springdemo.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lu2code.springdemo.coach.Coach;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		 ClassPathXmlApplicationContext context =
				 new ClassPathXmlApplicationContext("applicationContext.xml");
		 
		 Coach theCoach = context.getBean("tennisCoach",Coach.class);
		 
		 System.out.println(theCoach.getDailyWorkout());
		 
		 System.out.println(theCoach.getDayliFortune());
		 
		 context.close();
	}

}
