package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.enity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
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

            // delete the student
            // System.out.println("Deleting student: " + myStudent);
            // session.delete(myStudent);

            // delete student id
            System.out.println("Deleting student id= 2");
            // session.createQuery("delete from Student where id=2").executeUpdate();
            session.createNativeQuery("DELETE FROM student WHERE id=2").executeUpdate();
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
