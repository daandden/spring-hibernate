package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.enity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        // start a transaction
        Transaction transaction = session.beginTransaction();
        try {
            // query students
            List<Student> theStudents = session.createQuery("from Student", Student.class).getResultList();

            // display the students
            displayStudents(theStudents);

            // query students: lastName = 'Doe
            theStudents = session.createQuery("from Student s where s.lastName='Doe'", Student.class).getResultList();

            // display the students
            displayStudents(theStudents);

            // query students: lastName='Doe' OR firstName='Daffy'
            theStudents = session.createQuery("from Student s where s.lastName='Doe' or s.firstName='Daffy'", Student.class)
                                 .getResultList();

            // query students where email LIKE '%luv2code.com
            theStudents = session.createQuery("from Student s where"
                                              + " s. email LIKE '%luv2code.com'", Student.class).getResultList();

            displayStudents(theStudents);

            // display the students
            displayStudents(theStudents);
            
            // commit transaction
            transaction.commit();

            System.out.println("Done!");
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> theStudents) {
        theStudents.forEach(System.out::println);
    }
}
