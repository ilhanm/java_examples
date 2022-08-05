package lesson10CodeConfiguration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class codeConfigApp {

    public static void main(String[] args){
         //read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SportConfig.class);
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("javaCodeConfiguration/appCtx.xml");
        // get the bean from spring container
        Koc theCoach = context.getBean("swimCoach", Koc.class);
        // call method to get the daily fortune
        System.out.println(theCoach.getDailyFortune());

        // close the context
        context.close();
    }
}
