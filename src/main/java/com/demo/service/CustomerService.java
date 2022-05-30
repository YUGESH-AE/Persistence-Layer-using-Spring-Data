package com.demo.service;

import com.demo.dto.CustomerDto;
import com.demo.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

    /*
    Pagination  and sorting
     */
    Page<Customer> findAll(Pageable page);
    List<Customer> findAll(Sort sort);

    /*
    Query based on method
     */

    List<Customer> findByEmailIdOrName(String emailId, String name);
    List<Customer> findByDateOfBirthBetween(LocalDate fromDate, LocalDate toDate);
    List<Customer> findByDateOfBirthAfter(LocalDate dateOfBirth);

    /*
    @Query Annotation
     */
    String findNameByEmailID(String emailId);
    Integer updateEmailIdByName(String emailId,Integer customerId);
    Integer deleteByEmailId(String emailId);

}
