package com.demo.repository.Data_JPA;

import com.demo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    /*
    Query creation based on method name
     */
    List<Customer> findByEmailIdOrName(String emailId, String name);
    List<Customer> findByDateOfBirthBetween(LocalDate fromDate, LocalDate toDate);
    List<Customer> findByDateOfBirthAfter(LocalDate dateOfBirth);

    /*
    using query annotation
     */
    @Query("select c.name from Customer c where c.emailId=:emailId")
    String findNameByEmailID(@Param("emailId")String emailId);

    @Query("update Customer c set c.emailId=:emailId where c.customerId=:customerId")
    @Modifying
    @Transactional
    Integer updateEmailIdByName(@Param("emailId")String emailId,@Param("customerId")Integer customerId);


    @Query("delete from Customer c where c.emailId=:emailId")
    @Modifying
    @Transactional
    Integer deleteByEmailId(@Param("emailId")String emailId);

}