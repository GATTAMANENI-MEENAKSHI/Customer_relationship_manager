package com.example.customer_relationship_manager.Transformers;

import com.example.customer_relationship_manager.DTO.CustomerRequest;
import com.example.customer_relationship_manager.DTO.CustomerResponse;
import com.example.customer_relationship_manager.DTO.CustomerUpdateRequest;
import com.example.customer_relationship_manager.Model.Customer;

public class CustomerTransformer {
    public static Customer customerRequestToCustomer(CustomerRequest customerRequest){
        return Customer.builder()
                .firstName(customerRequest.getFirstName())
                .lastName(customerRequest.getLastName())
                .emailId(customerRequest.getEmailId())
                .build();
    }
    public static CustomerResponse cutomerToCustomerResponse(Customer customer ){
        return CustomerResponse.builder()
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .emailId(customer.getEmailId())
                .build();
    }
    public static Customer CustomerUpdateRequestToCustomer(CustomerUpdateRequest customerUpdateRequest){
        return Customer.builder()
                .firstName(customerUpdateRequest.getFirstName())
                .lastName(customerUpdateRequest.getLastName())
                .emailId(customerUpdateRequest.getEmailId())
                .build();
    }
}
