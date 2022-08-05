package spring_8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Scope("prototype")
@Component
public class TennisCoach implements Coach {

    private FortuneService fortuneService;
    private String condition;

    public TennisCoach() {
    }

    @Autowired
    public TennisCoach(@Qualifier("fileFortuneService") FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getBirthdayWish() {
        return "happy birthday mate";
    }

    @Override
    public String getDailyFortune() {
        return this.fortuneService.getFortune() ;
    }

    //define an init method
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("<< Tennis Coach >> --> my startup stuff");
    }

    @PreDestroy
    public void doMyFinisher(){
        System.out.println("<< Tennis Coach >> --> my destroy stuff");
    }

}
