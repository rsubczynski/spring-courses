package com.lu2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHelloApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context
		= new ClassPathXmlApplicationContext("applicationContext.xml");

		Coach theCoach = context.getBean("myCricketCoach", Coach.class);

		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());

		System.out.println(theCoach.getDailyFortune());

		context.close();
	}

}
