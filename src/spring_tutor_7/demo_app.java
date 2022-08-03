package spring_tutor_7;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_tutor_7.Coach;

public class demo_app {

    public static void main(String[] args){

        System.out.println("test");
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Coach firstCoach = ctx.getBean("tennisCoach", Coach.class);
        StationaryTraveller traveller = ctx.getBean("stationaryTraveller", StationaryTraveller.class);
        Coachum mycoachum = ctx.getBean("tirtCoach", Coachum.class);
        System.out.println(mycoachum.getName());


        System.out.println(firstCoach.getBirthdayWish());
        System.out.println(traveller.whereToStop());
        System.out.println(traveller.getWaitedHowLong());
        traveller.setTribe("cherokee");
        System.out.println(traveller.getTribe());



    }
}
