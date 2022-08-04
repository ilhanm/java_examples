package spring_8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    private FortuneService fortuneService;
    private String condition;

    public TennisCoach() {
    }

    @Autowired
    public TennisCoach(@Qualifier("sadFortuneService") FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getBirthdayWish() {
        return "happy birthday cunt";
    }

    @Override
    public String getDailyFortune() {
        return this.fortuneService.getFortune() ;
    }

}
