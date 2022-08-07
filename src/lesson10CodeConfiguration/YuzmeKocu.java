package lesson10CodeConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class YuzmeKocu implements Koc{

    FalServisi falServisi;

    @Override
    public String getTeam() {
        return team;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Value("${foo.team}")
    String team;

    @Value("${foo.email}")
    String email;



    YuzmeKocu(){
        System.out.println("dev");
    }

    @Autowired
    YuzmeKocu(FalServisi falServisi){
        this.falServisi=falServisi;
    }

    @Override
    public String getDailyFortune() {
        return falServisi.getFortune();
    }

}
