package com.demo.service;

import com.demo.dto.CustomerDto;

import java.util.List;

public interface CustomerService {

    String insert(CustomerDto customer);

    String update(Integer customerId, String name,String email);

    Integer delete(Integer customerId);

    List<CustomerDto> getAll();
}
