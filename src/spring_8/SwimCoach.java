package spring_8;

public class SwimCoach implements Coach {

	private FortuneService fortuneService;

	public SwimCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}


	@Override
	public String getBirthdayWish() {
		return "hebele";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}




