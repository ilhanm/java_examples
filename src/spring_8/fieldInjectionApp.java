package spring_8;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class fieldInjectionApp {

    public static void main(String[] args){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring_8/appContext.xml");
        Coach myCoach = ctx.getBean("swimmingCoach", Coach.class);
        System.out.println(myCoach.getBirthdayWish());
        System.out.println(myCoach.getDailyFortune());
    }

}
