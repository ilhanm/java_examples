package com.ilhan.hb_onetoone_uni.demo;


import com.ilhan.hb_onetoone_uni.demo.entity.Instructor;
import com.ilhan.hb_onetoone_uni.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // create objects
            Instructor tempInstructor = new Instructor("Chad","Darby","chad@lv2cd.com");

            InstructorDetail tempInstructorDetail = new InstructorDetail("youtube.com/chad","painting");

            //associate the objects
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            // start a transaction
            session.beginTransaction();

            //save the instructor
            // It will also save the instructorDetails because of the CascadeType.ALL
            session.save(tempInstructor);

            System.out.println("saved instructor: "+ tempInstructor);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }

}





