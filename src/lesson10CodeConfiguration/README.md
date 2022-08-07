Manuel olarak xml dosyasına tek tek bean yazarak configuration yaapmıştık
Daha sonra xml dosyasına component-scan ile birlikte paket ismini ekleyerek
de bir configuration yapmıştık. Burada her bir bean için @Component anotasyonu kullanıyorduk

XML içinde --> <context:component-scan base-package="mypath/spring_8"/>

Classlara eklediğimiz @Component sayesinde spring bunun bir component olduğunu öğrenip scan edebiliyordu

Java kodu ile de konfigürasyon yapmak mümkündür
SportConfig isimli java dosyası burada konfigürasyon dosyasıdır.

    @Configuration
    //@ComponentScan("path/javaCodeConfiguration")
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

@ComponentScan ile opsiyonel olarak path verebiliriz. Bu durumda o path içindeki tüm
componentleri okuyabiliriz.(@Component anotasyonuna sahip olanları)
Ya da ComponentScan kullanmadan tek tek componentleri kaydedebiliriz.(üstteki kodda @Bean anotasyonu ile gösterildiği gibi)

Tıpkı manuel olarak XML de <bean></bean> yazıp yaptığımız gibi. Bu durumda ise doğrudan kaydettiğimiz için
kaydettiğimiz classların içerisinde @Component anotasyonuna ihtiyaç duymayız
(çünkü onu ComponentScan bulabilsin diye yapıyorduk)

## properties file
#### How to inject values from properties file
STEP1: Property dosyasi yarat blabla.properties<br>
STEP2: Spring config dosyasi içerisinde bu properties file ı yükle <br>

    @PropertySource("classpath:lesson10CodeConfiguration/sport.properties")

STEP3: Property dosyasindan değerleri referans olarak göster.

    @Value("${foo.team}")
    String team;



Note:
if you use spring4.2 or lower than you might not get the property values<br>
instead of mymail@email.com you'll get --> ${foo.email}
<br> to solve this issue you should add this to your CONFIG FILE (SportConfig.java)

    // add support to resolve ${...} properties
    @Bean
    public static PropertySourcesPlaceholderConfigurer
                    propertySourcesPlaceHolderConfigurer() {
        
        return new PropertySourcesPlaceholderConfigurer();
    }
    


