package spring_8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


//@Component
@Scope("prototype")
public class SwimmingCoach implements Coach{

    @Autowired
    @Qualifier("sadFortuneService")
    private FortuneService fortuneService;

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    @Override
    public String getBirthdayWish() {
        return "happy birthday fish";
    }


}
