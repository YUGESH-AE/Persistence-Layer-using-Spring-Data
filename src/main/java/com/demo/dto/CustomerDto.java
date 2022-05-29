package com.demo.dto;

import com.demo.entity.Customer;
import com.demo.enumentity.CustomerType;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CustomerDto implements Serializable {
    private Integer customerId;
    private String emailId;
    private String name;
    private LocalDate dateOfBirth;
    private CustomerType customerType;

    public static Customer prepareCustomer(CustomerDto customerDto){
        Customer customer=new Customer();
        customer.setCustomerId(customerDto.getCustomerId());
        customer.setEmailId(customerDto.getEmailId());
        customer.setName(customerDto.getName());
        customer.setDateOfBirth(customerDto.getDateOfBirth());
        customer.setCustomerType(customerDto.getCustomerType());
        return customer;
    }
}
