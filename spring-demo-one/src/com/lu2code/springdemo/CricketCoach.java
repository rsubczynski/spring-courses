package com.lu2code.springdemo;

public class CricketCoach implements Coach {
	
	private String emailAddres;
	private String team;

	public CricketCoach() {
	}

	private FortuneService fortuneServices;

	public void setFortuneServices(FortuneService fortuneServices) {
		this.fortuneServices = fortuneServices;
	}
	
	public void setEmailAddres(String emailAddres) {
		this.emailAddres = emailAddres;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	@Override
	public String getDailyWorkout() {
		return "Cricket! go go go";
	}

	@Override
	public String getDailyFortune() {
		return fortuneServices.getFortune();
	}

	@Override
	public String getEmailAdress() {
		return emailAddres;
	}

	@Override
	public String getTeam() {
		return team;
	}

}
