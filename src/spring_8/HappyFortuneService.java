package spring_8;

import org.springframework.stereotype.Component;

@Component("happyFortuneService")
public class HappyFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "You'll have a happy day.";
    }
}
