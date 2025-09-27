package com.example.customer_relationship_manager.Service;

import com.example.customer_relationship_manager.DTO.CustomerRequest;
import com.example.customer_relationship_manager.DTO.CustomerResponse;
import com.example.customer_relationship_manager.DTO.CustomerUpdateRequest;
import com.example.customer_relationship_manager.Exception.UserAlreadyPresentException;
import com.example.customer_relationship_manager.Exception.UserIsNotPresentException;
import com.example.customer_relationship_manager.Model.Customer;
import com.example.customer_relationship_manager.Repository.CustomerRepository;
import com.example.customer_relationship_manager.Transformers.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public CustomerResponse addCustomer(CustomerRequest customerRequest) {
        Optional<Customer> customer = customerRepository.findByEmailId(customerRequest.getEmailId());
        if(customer.isPresent()){
            throw new UserAlreadyPresentException("User is Already present");
        }
        Customer newCustomer = CustomerTransformer.customerRequestToCustomer(customerRequest);
        return CustomerTransformer.cutomerToCustomerResponse(customerRepository.save(newCustomer));
    }

    public CustomerResponse updateCustomer(CustomerUpdateRequest customerUpdateRequest) {
        if(  customerUpdateRequest.getEmailId().equals(customerUpdateRequest.getPreviousEmailId())){
            Optional<Customer> optionalCustomer = customerRepository.findByEmailId(customerUpdateRequest.getPreviousEmailId());
            if(optionalCustomer.isEmpty()){
                throw new UserIsNotPresentException("User Does Not Exists");
            }
            Customer customer = optionalCustomer.get();
            customer.setFirstName(customerUpdateRequest.getFirstName());
            customer.setLastName(customerUpdateRequest.getLastName());
            customerRepository.save(customer);
            return CustomerTransformer.cutomerToCustomerResponse(customer);
        }
        Optional<Customer> optionalCustomer = customerRepository.findByEmailId(customerUpdateRequest.getPreviousEmailId());
        if(optionalCustomer.isEmpty()) {
            throw new UserIsNotPresentException("User Does Not Exists");
        }
        customerRepository.delete(optionalCustomer.get());

        Customer customer = CustomerTransformer.CustomerUpdateRequestToCustomer(customerUpdateRequest);
        return CustomerTransformer.cutomerToCustomerResponse(customerRepository.save(customer));
    }

    public CustomerResponse getCustomerByEmailId(String EmailId) {
        Optional<Customer> optionalCustomer = customerRepository.findByEmailId(EmailId);
        if(optionalCustomer.isEmpty()){
            throw new UserIsNotPresentException("User Does Not Exists");
        }
        Customer customer = optionalCustomer.get();
        return CustomerTransformer.cutomerToCustomerResponse(customer);
    }

    public void deleteCustomerByEmail(String emailId) {
        Optional<Customer> customer = customerRepository.findByEmailId(emailId);
        if(customer.isEmpty()){
            throw new UserIsNotPresentException("User Does Not Exists");
        }
        customerRepository.delete(customer.get());
    }
}
