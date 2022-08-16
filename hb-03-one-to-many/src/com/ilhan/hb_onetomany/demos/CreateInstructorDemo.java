package com.ilhan.hb_onetomany.demos;


import com.ilhan.hb_onetomany.entity.Course;
import com.ilhan.hb_onetomany.entity.Instructor;
import com.ilhan.hb_onetomany.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        // create session


        try {
            Session session = factory.getCurrentSession();
            // create objects
            Instructor tempInstructor = new Instructor("Jack","Grealish","greelish@123.com");

            InstructorDetail tempInstructorDetail = new InstructorDetail("youtube.com/baller","painting");

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





