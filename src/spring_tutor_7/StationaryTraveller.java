package spring_tutor_7;

import org.springframework.stereotype.Component;

@Component
public class StationaryTraveller {

    public String getWaitedHowLong() {
        return waitedHowLong;
    }

    private String waitedHowLong;

    public String getTribe() {
        return tribe;
    }

    public void setTribe(String tribe) {
        this.tribe = tribe;
    }

    private String tribe;



    public StationaryTraveller() {
        this.waitedHowLong = "5 milyon milyor yıl";
    }



    public String whereToStop(){
        return "Baghdad";
    }
}
