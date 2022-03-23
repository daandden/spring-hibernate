package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.enity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        // create sesssion
        Session session = factory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            int studentId = 1;

            // now get a new session and start transaction
            session = factory.getCurrentSession();

            // retrieve student based on the id: primary key
            System.out.println("\nGetting student with id: " + studentId);

            Student myStudent = session.get(Student.class, studentId);

            System.out.println("Updating student...");
            myStudent.setFirstName("Scooby");

            // commit the transaction
            transaction.commit();

            // NEW CODE
            session = factory.getCurrentSession();
            transaction = session.beginTransaction();

            System.out.println("Update email for all students");

            session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();

            // commit the transaction
            transaction.commit();

            System.out.println("Done!");
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            factory.close();
        }
    }
}
