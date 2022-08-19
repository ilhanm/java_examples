package hb_onetomany_extended.demos;


import hb_onetomany_extended.entity.Course;
import hb_onetomany_extended.entity.Instructor;
import hb_onetomany_extended.entity.InstructorDetail;
import hb_onetomany_extended.entity.Review;
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
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        // create session


        try {
            Session session = factory.getCurrentSession();
            // create objects
            Instructor tempInstructor = new Instructor("Ilhan","Alan","ilhan@123.com");

            InstructorDetail tempInstructorDetail = new InstructorDetail("youtube.com/test","coding");

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





