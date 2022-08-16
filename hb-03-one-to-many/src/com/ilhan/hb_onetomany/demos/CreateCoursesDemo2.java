package com.ilhan.hb_onetomany.demos;

import com.ilhan.hb_onetomany.entity.Course;
import com.ilhan.hb_onetomany.entity.Instructor;
import com.ilhan.hb_onetomany.entity.InstructorDetail;
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
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            session.beginTransaction();

            // get the instructor from db
            int theId = 2;
            Instructor tempInstructor = session.get(Instructor.class, theId);

            // create some courses
            Course tempCourse1 = new Course("Soccer 101");
            Course tempCourse2 = new Course("How to dribbling?");

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
