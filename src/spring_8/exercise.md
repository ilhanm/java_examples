chad-spring modul 8-9 birleşik
-
Annotation kullanarak 3 farklı şekilde injection yapılabiliyor.
Constructor injection
Setter injection
Field injection 

Bunların dependency lerini bağlamak için @Autowired kullanılıyor

    @Autowired
    public TennisCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

(fortuneService bir interface)
birden fazla fortuneService implementasyonu varsa (happyFortuneService, sadFortuneService etc)

@Qualifier("sadFortuneService") gibi spesifik implementasyon belirtilir.

Constructor injectionda parametre olarak içine verilir

    @Autowired
    public TennisCoach(@Qualifier("sadFortuneService") FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

Setter ve field injection için ise ilgili setter metodunun veya field tanımının üzerine 
annotation olarak vermek yeterlidir.

    @Autowired
    @Qualifier("sadFortuneService")
    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }
veya Field Injection için aşağıdaki gibi

    @Autowired
    @Qualifier("happyFortuneService")
    private FortuneService fortuneService;

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }