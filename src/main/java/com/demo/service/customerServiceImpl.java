package com.demo.service;

import com.demo.dto.CustomerDto;
import com.demo.entity.Customer;
import com.demo.repository.ORM.customerRepositoryORMImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class customerServiceImpl  implements CustomerService{

    @Autowired
    customerRepositoryORMImpl customerRepository;

    @Override
    public String insert(CustomerDto customer) {
        return customerRepository.insert(CustomerDto.prepareCustomer(customer));
    }

    @Override
    public String update(Integer customerId, String name, String email) {
        return customerRepository.update(customerId,name,email );
    }

    @Override
    public Integer delete(Integer customerId) {
        return customerRepository.delete(customerId);

    }

    @Override
    public List<CustomerDto> getAll() {
        List<CustomerDto>custDTO=new ArrayList<>();

        List<Customer>cust=customerRepository.getAll();

        for(Customer i:cust){
            CustomerDto dto=Customer.prepareCustomerDTO(i);
            custDTO.add(dto);
        }
        return custDTO;
    }
}
