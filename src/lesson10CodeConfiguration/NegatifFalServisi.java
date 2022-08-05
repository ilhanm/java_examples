package lesson10CodeConfiguration;

public class NegatifFalServisi implements FalServisi{
    @Override
    public String getFortune() {
        return "şanssız bir gün olacak";
    }
}
