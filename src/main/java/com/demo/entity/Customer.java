package com.demo.entity;

import com.demo.dto.CustomerDto;
import com.demo.enumentity.CustomerType;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "customer_Details")
public class Customer {
    @Id
    private Integer customerId;
    private String emailId;
    private String name;
    private LocalDate dateOfBirth;
    @Enumerated(value = EnumType.STRING)
    private CustomerType customerType;

    public static CustomerDto prepareCustomerDTO(Customer customer){
        CustomerDto customerDto=new CustomerDto();
        customerDto.setCustomerId(customer.getCustomerId());
        customerDto.setEmailId(customer.getEmailId());
        customerDto.setName(customer.getName());
        customerDto.setDateOfBirth(customer.getDateOfBirth());
        customerDto.setCustomerType(customer.getCustomerType());
        return customerDto;
    }
}