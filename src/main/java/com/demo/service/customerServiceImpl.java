package com.demo.service;

import com.demo.dto.CustomerDto;
import com.demo.entity.Customer;
import com.demo.repository.Data_JPA.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class customerServiceImpl  implements CustomerService{

//    @Autowired
//    customerRepositoryORMImpl customerRepository;

    /*
    Spring ORM Implementation
     */

//    @Override
//    public String insert(CustomerDto customer) {
//        return customerRepository.insert(CustomerDto.prepareCustomer(customer));
//    }
//
//    @Override
//    public String update(Integer customerId, String name, String email) {
//        return customerRepository.update(customerId,name,email );
//    }
//
//    @Override
//    public Integer delete(Integer customerId) {
//        return customerRepository.delete(customerId);
//
//    }
//
//    @Override
//    public List<CustomerDto> getAll() {
//        List<CustomerDto>custDTO=new ArrayList<>();
//
//        List<Customer>cust=customerRepository.getAll();
//
//        for(Customer i:cust){
//            CustomerDto dto=Customer.prepareCustomerDTO(i);
//            custDTO.add(dto);
//        }
//        return custDTO;
//    }

    /*
    Spring Data JPA Implementation
     */

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public String insert(CustomerDto customerDto) {
        customerRepository.save(CustomerDto.prepareCustomer(customerDto));
        return "Records Inserted successfully";
    }

    @Override
    public String update(CustomerDto customerDto, Integer customerId) {
        Optional<Customer>optionalCustomer=customerRepository.findById(customerId);
        boolean present = optionalCustomer.isPresent();
        if(!present){
            return "no customer exist";
        }
        Customer cust=optionalCustomer.get();
        cust.setCustomerId(customerDto.getCustomerId());
        cust.setName(customerDto.getName());
        cust.setEmailId(customerDto.getEmailId());
        cust.setDateOfBirth(customerDto.getDateOfBirth());
        cust.setCustomerType(customerDto.getCustomerType());
        customerRepository.save(cust);
        return "Records updated successfully";
    }

    @Override
    public Integer delete(Integer customerID) {
        int result=0;
        Optional<Customer>optionalCustomer=customerRepository.findById(customerID);
        if(!optionalCustomer.isPresent()){
            return result;
        }
        customerRepository.deleteById(customerID);
        result=1;
        return result;
    }

    @Override
    public List<Customer> getall() {
        return customerRepository.findAll();
    }

    @Override
    public Page<Customer> findAll(Pageable page) {

        return customerRepository.findAll(page);
    }

    @Override
    public List<Customer> findAll(Sort sort) {
        return customerRepository.findAll(sort);
    }





    @Override
    public List<Customer> findByEmailIdOrName(String emailId, String name) {
        return customerRepository.findByEmailIdOrName(emailId,name);
    }
    @Override
    public List<Customer> findByDateOfBirthBetween(LocalDate fromDate, LocalDate toDate) {
        return customerRepository.findByDateOfBirthBetween(fromDate,toDate);
    }

    @Override
    public List<Customer> findByDateOfBirthAfter(LocalDate dateOfBirth) {
        return customerRepository.findByDateOfBirthAfter(dateOfBirth);
    }

    @Override
    public String findNameByEmailID(String emailId) {
        return customerRepository.findNameByEmailID(emailId);
    }

    @Override
    public Integer updateEmailIdByName(String emailId, Integer customerId) {
        return customerRepository.updateEmailIdByName(emailId,customerId);
    }

    @Override
    public Integer deleteByEmailId(String emailId) {
        return customerRepository.deleteByEmailId(emailId);
    }

}
