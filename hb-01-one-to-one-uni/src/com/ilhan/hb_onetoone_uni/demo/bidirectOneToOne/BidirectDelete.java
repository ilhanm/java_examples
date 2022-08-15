package com.ilhan.hb_onetoone_uni.demo.bidirectOneToOne;

import com.ilhan.hb_onetoone_uni.demo.entity.Instructor;
import com.ilhan.hb_onetoone_uni.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BidirectDelete {
    public static void main(String[] args){

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Instructor.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();
            InstructorDetail myDetail = session.get(InstructorDetail.class,7);
            Instructor myInstructor = myDetail.getInstructor();
            System.out.println("My Details : " + myDetail);
            System.out.println("My Instructor : " + myInstructor);

            //now delete the instructor detail
            System.out.println("Deleting the instructor detail (cascade)");

            //break the link between instructor --> instructor_id if you want to keep instructor but delete details
            // instructor details den instructora giden linki kaldırırsan re-saved by cascade olmaz
            //javax.persistence.EntityNotFoundException: deleted object would be re-saved by cascade (remove deleted object from associations): [com.ilhan.hb_onetoone_uni.demo.entity.InstructorDetail#7]
            //myDetail.getInstructor().setInstructorDetail(null);


            session.delete(myDetail);

            session.getTransaction().commit();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally {
            session.close();
            factory.close();
        }


    }
}
