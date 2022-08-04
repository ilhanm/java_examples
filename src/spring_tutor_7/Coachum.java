package spring_tutor_7;

import org.springframework.stereotype.Component;

@Component("tirtCoach")
public class Coachum {

    private String Name;

    public Coachum(){
        Name = "coachum ilhan";
        System.out.println("inside coachum constructor");
    }


    public Coachum(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }
}
