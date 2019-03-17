package com.lu2code.springdemo;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;

	TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
		System.out.println("TrackCoach: inside method constuctor");
	}

	@Override
	public String getDailyWorkout() {
		return "Run Forest Run";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	@Override
	public String getEmailAdress() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTeam() {
		// TODO Auto-generated method stub
		return null;
	}

	public void doMyStartStuff() {
		System.out.println("TrackCoach: inside method doMyStartStuff");
	}

	public void doMyCleanUpStuffYoYo() {
		System.out.println("TrackCoach: inside method doMyCleanUpStuffYoYo");
	}
}
