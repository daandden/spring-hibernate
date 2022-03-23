package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.enity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {

            // create the objects
            Instructor tempInstructor = new Instructor("Chad", "Darby","darby@luv2code.com");

            InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code/youtube", "Luv 2 code !!!");

            tempInstructor.setInstructorDetail(tempInstructorDetail);

            System.out.println("Saving instructor: " + tempInstructor);
            session.save(tempInstructor);

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
