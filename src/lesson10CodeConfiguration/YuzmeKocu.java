package lesson10CodeConfiguration;

public class YuzmeKocu implements Koc{

    FalServisi falServisi;

    YuzmeKocu(FalServisi falServisi){
        this.falServisi=falServisi;
    }

    @Override
    public String getDailyFortune() {
        return falServisi.getFortune();
    }

}
