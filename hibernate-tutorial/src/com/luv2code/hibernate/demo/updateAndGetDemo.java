package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class updateAndGetDemo {
    public static void main(String[] args){
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            Student myStudent = session.get(Student.class, 6);
            System.out.println("before update: "+ myStudent);
            myStudent.setFirstName("Mahmut");
            session.getTransaction().commit();
            session.close();

            session.beginTransaction();
            Student myStd = session.get(Student.class, 6);
            System.out.println("after update: "+ myStudent);
            session.getTransaction().commit();

        }
        finally {

        }
    }
}
