package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            // // get the instructor detail object
            // int theId = 1000;
            // InstructorDetail tempInstructorDetail = session.createNativeQuery("SELECT * FROM instructor_detail WHERE id=:id", InstructorDetail.class)
            //                                                .setParameter("id", theId).uniqueResult();
            // // print the instructor detail
            // System.out.println("tempInstructorDetail: " + tempInstructorDetail);
            //
            // // print the associated instructor
            // System.out.println("the associated instructor: " + tempInstructorDetail.getInstructors());

            // @SuppressWarnings({"deprecation", "unchecked"}) List<InstructorDto> instructorDtos = session.createQuery("select i.firstName as firstName, i.lastName as lastName from Instructor i")
            //                                                                                             .unwrap(org.hibernate.query.Query.class)
            //                                                                                             .setResultTransformer(Transformers.aliasToBean(InstructorDto.class))
            //                                                                                             .getResultList();

            // @SuppressWarnings({"deprecation", "unchecked"}) List<InstructorDto> instructorDtos = session.createNativeQuery("SELECT i.first_name firstName, i.last_name AS lastName " + "FROM instructor i")
            //                                                                                             .setResultTransformer(Transformers.aliasToBean(InstructorDto.class))
            //                                                                                             .unwrap(org.hibernate.query.NativeQuery.class)
            //                                                                                             .getResultList();
            //
            // List<InstructorDto> instructorDtos = session.createQuery("select new com.luv2code.hibernate.demo.enity.InstructorDto(i.firstName, i.lastName) " + "from Instructor i", InstructorDto.class)
            //                                             .getResultList();

            // System.out.println(instructorDtos);

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
