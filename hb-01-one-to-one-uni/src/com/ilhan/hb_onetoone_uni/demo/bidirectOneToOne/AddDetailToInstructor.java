package com.ilhan.hb_onetoone_uni.demo.bidirectOneToOne;

import com.ilhan.hb_onetoone_uni.demo.entity.Instructor;
import com.ilhan.hb_onetoone_uni.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//if i have an instructor in my db and its detail_id is null, we can create a detail and attach it to the that instructor
public class AddDetailToInstructor {
    public static void main(String[] args){
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            session.beginTransaction();
            Instructor myInstructor = session.get(Instructor.class,8);
            InstructorDetail myDetails = new InstructorDetail("youtube.com/chester","chess");
            myInstructor.setInstructorDetail(myDetails);
            session.getTransaction().commit();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
            session.close();
            factory.close();
        }




    }
}
