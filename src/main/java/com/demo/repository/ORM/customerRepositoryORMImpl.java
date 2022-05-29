package com.demo.repository.ORM;

import com.demo.entity.Customer;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import java.util.List;

@Repository
public class customerRepositoryORMImpl implements customerRepositoryORM {

    private EntityManagerFactory entityManagerFactory;

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }



    @Override
    public String insert(Customer customer) {
        EntityManager entityManager=
                this.entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.getTransaction().commit();

        return "Customer details successfully inserted into data base";
    }

    @Override
    public String update(Integer customerId, String name, String email) {
        EntityManager entityManager=
                this.entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Customer customer=entityManager.find(Customer.class,customerId);
        customer.setName(name);
        customer.setEmailId(email);
        entityManager.getTransaction().commit();

        return "record updated successfully";
    }

    @Override
    public Integer delete(Integer customerId) {
        EntityManager entityManager=
                this.entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        int result=0;
        try{
            Customer customer=entityManager.find(Customer.class,customerId);
            entityManager.remove(customer);
            result=1;
            entityManager.getTransaction().commit();
        }catch (DataAccessException e){
            entityManager.getTransaction().rollback();
        }
        return result;
    }

    @Override
    public List<Customer> getAll() {
        EntityManager entityManager=
                this.entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("Select c from Customer c");
        return (List<Customer>)query.getResultList();
    }
}
