package com.example.accounts.mapper;

import com.example.accounts.dto.CustomerDto;
import com.example.accounts.entity.Customers;

public class CustomerMapper {
    public static CustomerDto mapToCustomerDto(CustomerDto customerDto, Customers customers){
        customerDto.setName(customers.getName());
        customerDto.setEmail(customers.getEmail());
        customerDto.setContactNo(customers.getContactNo());
        return customerDto;
    }
    public static Customers mapToCustomer(Customers customers,CustomerDto customerDto){
        customers.setName(customerDto.getName());
        customers.setEmail(customerDto.getEmail());
        customers.setContactNo(customerDto.getContactNo());
        return customers;
    }
}
