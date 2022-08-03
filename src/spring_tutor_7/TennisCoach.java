package spring_tutor_7;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
    @Override
    public String getBirthdayWish() {
        return "happy birthday cunt";
    }
}
