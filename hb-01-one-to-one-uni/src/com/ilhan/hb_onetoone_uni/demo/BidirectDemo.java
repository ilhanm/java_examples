package com.ilhan.hb_onetoone_uni.demo;

import com.ilhan.hb_onetoone_uni.demo.entity.Instructor;
import com.ilhan.hb_onetoone_uni.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BidirectDemo {
    public static void main(String[] args){

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Instructor.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();
            InstructorDetail myDetail = session.get(InstructorDetail.class,1);
            Instructor myInstructor = myDetail.getInstructor();
            System.out.println("My Details : " + myDetail);
            System.out.println("My Instructor : " + myInstructor);
            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }


    }
}
