package spring_tutor_7;

import org.springframework.stereotype.Component;

//@Component
public class SadFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "feels bad man";
    }
}
