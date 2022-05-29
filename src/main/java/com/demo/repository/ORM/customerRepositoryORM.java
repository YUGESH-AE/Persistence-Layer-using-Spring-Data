package com.demo.repository.ORM;

import com.demo.entity.Customer;

import java.util.List;

public interface customerRepositoryORM {

    String insert(Customer customer);

    String update(Integer customerId, String name,String email);

    Integer delete(Integer customerId);

    List<Customer> getAll();
}
