package com.demo.service;

import com.demo.dto.CustomerDto;
import com.demo.entity.Customer;

import java.util.List;

public interface CustomerService {
    /*
    ORM implementations
     */
//    String insert(CustomerDto customer);
//
//    String update(Integer customerId, String name,String email);
//
//    Integer delete(Integer customerId);
//
//    List<CustomerDto> getAll();


    /*
    Spring Data JPA implementations
     */
    String insert(CustomerDto customerDto);

    String update(CustomerDto customerDto,Integer customerId);

    Integer delete (Integer customerID);

    List<Customer> getall();
}
