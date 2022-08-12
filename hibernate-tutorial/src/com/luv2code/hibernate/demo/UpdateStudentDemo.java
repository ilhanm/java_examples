package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaUpdate;
import java.util.ArrayList;
import java.util.List;

public class UpdateStudentDemo {

    public static void main(String[] args){

        //create sessionfactory

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory();

        try {
            int studentId = 1;

            // now get a new session and start transaction
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            // retrieve student based on the id: primary key
            System.out.println("\nGetting student with id: " + studentId);

            Student myStudent = session.get(Student.class, studentId);

            System.out.println("Updating student...");
            myStudent.setFirstName("Scooby Dooby");

            // commit the transaction
            session.getTransaction().commit();

            // NEW CODE

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            // update email for all students, for this we dont need to fetch specific row, we simply run sql
            System.out.println("Update email for all students");

            session.createQuery("update Student set email='bjorn@gmail.com' where  (id % 2) = 0 ")
                    .executeUpdate();

            // commit the transaction
            session.getTransaction().commit();


            System.out.println("Done!");
        }
        finally {
            sessionFactory.close();
        }



    }
}
