package com.ilhan.hb_onetoone_uni.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Instructor.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            Instructor myInstructor = session.get(Instructor.class, 3);

            //will also delete details object because of CascadeType.ALL
            session.delete(myInstructor);
            session.getTransaction().commit();

        }
        finally {
            factory.close();
        }

    }

}
