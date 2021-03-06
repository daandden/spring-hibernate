package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.enity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetailDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            // get the instructor detail object
            int theId = 5;
            // InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
            //
            // // print the instructor detail
            // System.out.println("tempInstructorDetail: " + tempInstructorDetail);
            //
            // // print the associated instructor
            // System.out.println("the associated instructor: " + tempInstructorDetail.getInstructors());
            session.get(InstructorDetail.class, theId);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            factory.close();
        }
    }
}
