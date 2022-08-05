package lesson10CodeConfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan("javaCodeConfiguration")
public class SportConfig {
    // define bean for sad fortune service

    @Bean
    public FalServisi negativeFalService(){
        return new NegatifFalServisi();
    }

    //define bean for swim coach and inject dependency

    @Bean
    public Koc swimCoach(){
        YuzmeKocu yuzmeKocum = new YuzmeKocu(negativeFalService());
        return yuzmeKocum;
    }

}
