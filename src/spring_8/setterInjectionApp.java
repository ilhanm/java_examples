package spring_8;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class setterInjectionApp {
    public static void main(String[] args){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring_8/appContext.xml");
        Coach myCoach = ctx.getBean("baseballCoach",Coach.class);
        System.out.println(myCoach.getDailyFortune());

    }
}
