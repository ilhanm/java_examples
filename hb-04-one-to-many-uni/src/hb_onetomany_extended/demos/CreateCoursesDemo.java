package hb_onetomany_extended.demos;

import hb_onetomany_extended.entity.Course;
import hb_onetomany_extended.entity.Instructor;
import hb_onetomany_extended.entity.InstructorDetail;
import hb_onetomany_extended.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesDemo {
    public static void main(String[] args){
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            session.beginTransaction();

            // get the instructor from db
            int theId = 1;
            Instructor tempInstructor = session.get(Instructor.class, theId);

            // create some courses
            Course tempCourse1 = new Course("Blocking");
            Course tempCourse2 = new Course("The Defending Masterclass");

            // add courses to instructor
            tempInstructor.add(tempCourse1); //add is helper method in instructor class
            tempInstructor.add(tempCourse2);

            // save the courses
            session.save(tempCourse1);
            session.save(tempCourse2);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        catch (Exception ex){
            System.out.println(ex);
        }
        finally {
            session.close();
            factory.close();
        }


    }
}
