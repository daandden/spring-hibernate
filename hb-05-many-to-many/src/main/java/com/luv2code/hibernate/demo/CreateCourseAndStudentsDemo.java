package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudentsDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            // create a course
            Course tempCourse = new Course("Pacman - How To Score One Million Points");

            // save the course
            System.out.println("\nSaving the course ...");
            System.out.println("Saved the course: " + tempCourse);

            // create the students
            Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com");
            Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");
            Student tempStudent3 = new Student("Mary", "Public", "mary@luv2code.com");

            // add students to the course
            tempCourse.addStudent(tempStudent1);
            tempCourse.addStudent(tempStudent2);
            session.persist(tempCourse);
            tempCourse.getStudents().add(tempStudent3);
            session.merge(tempCourse);
            // save the students
            System.out.println("\nSaving students ...");
            // session.save(tempStudent1);
            // session.save(tempStudent2);
            System.out.println("Saved students: " + tempCourse.getStudents());

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            factory.close();
        }
    }

}





