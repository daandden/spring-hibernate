package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.enity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        Session session = factory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try (session) {
            Student student = new Student("vu", "nguyen", "vunguyen@gmail.com", LocalDate.of(2000, 12, 12));
            session.save(student);

            Student newStudent = session.get(Student.class, student.getId());
            System.out.println(newStudent.getDateOfBirth().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }
}
