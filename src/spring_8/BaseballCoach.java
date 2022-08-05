package spring_8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {

    private FortuneService fortuneService;


    @Autowired
    @Qualifier("sadFortuneService")
    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getBirthdayWish() {
        return "hepi niv yir";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
