package spring_8;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class setterInjectionApp {
    public static void main(String[] args){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring_8/appContext.xml");
        Coach myCoach = ctx.getBean("baseballCoach",Coach.class);
        Coach myOtherCoach = ctx.getBean("baseballCoach",Coach.class);
        System.out.println(myCoach.getDailyFortune());
        boolean result = (myCoach == myOtherCoach);
        System.out.println("is my two coach same(is using singleton): "+ result);
        System.out.println("memory location of myCoach: "+ myCoach );
        System.out.println("memory location of myOtherCoach: "+ myOtherCoach);

    }
}
