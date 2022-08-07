package lesson10CodeConfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("lesson10CodeConfiguration")
@PropertySource("classpath:lesson10CodeConfiguration/sport.properties")
public class SportConfig {
    // define bean for sad fortune service

//    @Bean
//    public FalServisi negativeFalService(){
//        return new NegatifFalServisi();
//    }
//
//    //define bean for swim coach and inject dependency
//
//    @Bean
//    public Koc yuzmeKocu(){
//        YuzmeKocu yuzmeKocum = new YuzmeKocu(negativeFalService());
//        return yuzmeKocum;
//    }

}
