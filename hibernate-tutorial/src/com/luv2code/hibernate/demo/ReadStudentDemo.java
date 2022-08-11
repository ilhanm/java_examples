package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();
        Student mainStudent = new Student("Mert", "A", "ilma@luv2code.com");

        try {
            // create a student object
            System.out.println("Creating new student object...");
            Student tempStudent = new Student("Ilhan", "M", "ima@luv2code.com");

            // start a transaction
            session.beginTransaction();
            System.out.println("Student id before session.save " + tempStudent.getId());
            // save the student object
            System.out.println("Saving the student...");
            System.out.println(tempStudent);
            session.save(tempStudent);
            session.save(mainStudent);

            // commit transaction
            session.getTransaction().commit();

            // MY NEW CODE

            // find out the student's id: primary key
            System.out.println("Saved student. Generated id: " + tempStudent.getId());

            // now get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve student based on the id: primary key
            System.out.println("\nGetting student with id: " + tempStudent.getId());

            Student myStudent = session.get(Student.class, tempStudent.getId());

            System.out.println("Get complete: " + myStudent);

            // commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
            System.out.println(mainStudent.getId());
            /*
            when we create object its id is 0,
             after we save this object to the session,
            it takes its new id from db(with the help of database auto_increment feature)
            * */
        }
    }

}