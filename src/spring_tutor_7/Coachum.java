package spring_tutor_7;

import org.springframework.stereotype.Component;

@Component("tirtCoach")
public class Coachum {

    private String Name;

    public Coachum(){
        Name = "coachum ilhan";
    }


    public Coachum(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }
}
