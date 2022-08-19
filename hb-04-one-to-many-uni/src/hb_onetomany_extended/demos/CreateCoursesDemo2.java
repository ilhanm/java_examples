package hb_onetomany_extended.demos;

import hb_onetomany_extended.entity.Course;
import hb_onetomany_extended.entity.Instructor;
import hb_onetomany_extended.entity.InstructorDetail;
import hb_onetomany_extended.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;
/*
* Its the implementation of CreateCourseDemo.java but without using Instructor's add() helper method that we defined
* */
public class CreateCoursesDemo2 {
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
            Course tempCourse1 = new Course("Iviring ziviring");
            Course tempCourse2 = new Course("Türkçe");

            List<Course> courses = tempInstructor.getCourses();
            if (courses == null) {
                courses = new ArrayList<>();
                tempInstructor.setCourses(courses);
            }


            courses.add(tempCourse1);
            tempCourse1.setInstructor(tempInstructor);

            courses.add(tempCourse2);
            tempCourse2.setInstructor(tempInstructor);
            // save the courses
            session.save(tempCourse1);
            session.save(tempCourse2);
            System.out.println("tempCourse1: " + tempCourse1);
            System.out.println("tempCourse2: " + tempCourse2);
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
