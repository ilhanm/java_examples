package com.ilhan.hb_onetoone_uni.demo;

import com.ilhan.hb_onetoone_uni.demo.entity.Instructor;
import com.ilhan.hb_onetoone_uni.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetAndUpdateInstructor {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            Instructor myInstructor = session.get(Instructor.class,3);
            InstructorDetail myInsDetails = myInstructor.getInstructorDetail();
            myInsDetails.setHobby("Piano");
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }


}
