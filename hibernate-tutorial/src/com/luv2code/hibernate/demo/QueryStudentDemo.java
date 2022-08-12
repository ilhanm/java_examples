package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args){
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            List<Student> theStudents = session.createQuery("from Student s where s.email like 'daffy%' ").getResultList();

            displayStudents(theStudents);

            Student myStudent = session.get(Student.class, 6);
            myStudent.setFirstName("Mükremin");

            session.getTransaction().commit();
            System.out.println("done");

        }
        catch (Exception ex){
            System.out.println(ex);
        }

        
    }

    private static void displayStudents(List<Student> theStudents) {
        for(Student theStudent: theStudents){

            System.out.println(theStudent.getId() + " " + theStudent);

        }
    }
}
