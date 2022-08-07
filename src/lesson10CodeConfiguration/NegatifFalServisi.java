package lesson10CodeConfiguration;

import org.springframework.stereotype.Component;

@Component
public class NegatifFalServisi implements FalServisi{
    @Override
    public String getFortune() {
        return "şanssız bir gün olacak";
    }
}
