package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    // need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {

        // get the current hiberante session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query
        Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName",
                                                              Customer.class);
        // return the results
        return theQuery.getResultList();
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(theCustomer);
    }

    @Override
    public Customer getCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Customer.class, id);
    }

    @Override
    public void deleteCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();

        session.createQuery("delete from Customer where id=:id")
               .setParameter("id", id)
               .executeUpdate();
    }
}
