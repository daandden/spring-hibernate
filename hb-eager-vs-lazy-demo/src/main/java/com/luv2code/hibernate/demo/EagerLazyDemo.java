package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            // start a transaction
            session.beginTransaction();

            // get the instructor from db
            int theId = 5;
            Instructor tempInstructor = session.get(Instructor.class, theId);

            System.out.println("\n\nluv2code: Instructor: " + tempInstructor);

            System.out.println("\n\nluv2code: Courses: " + tempInstructor.getCourses());

            // commit transaction
            session.getTransaction().commit();
            // session.close();
            System.out.println("session.isOpen() = " + session.isOpen());
            // close the session

            System.out.println("\nluv2code: The session is now closed!\n");

            // option 1: call getter method while session is open

            // get courses for the instructor
            System.out.println("luv2code: Courses: " + tempInstructor.getCourses());

            System.out.println("luv2code: Done!");
        } finally {

            // add clean up code
            session.close();

            factory.close();
        }
    }

}





