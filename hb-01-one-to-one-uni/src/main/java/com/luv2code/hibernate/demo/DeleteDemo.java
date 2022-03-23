package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.enity.Instructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {

            // get instructor by primary key / id
            int theId = 2;
            Instructor tempIntstructor = session.get(Instructor.class, theId);

            System.out.println("Found instructor: " + tempIntstructor);

            // delete instructors
            if (tempIntstructor != null) {
                System.out.println("Deleting: " + tempIntstructor);

                // Note: will ALSO delete associated "details" object
                session.delete(tempIntstructor);
            }

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
