package com.example.customer_relationship_manager.Controller;

import com.example.customer_relationship_manager.DTO.CustomerRequest;
import com.example.customer_relationship_manager.DTO.CustomerResponse;
import com.example.customer_relationship_manager.DTO.CustomerUpdateRequest;
import com.example.customer_relationship_manager.Model.Customer;
import com.example.customer_relationship_manager.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "https://crm-frontend-production-f09c.up.railway.app")
@RestController
@RequestMapping("/Customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @GetMapping("/get")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/getbyid/{id}")
    public CustomerResponse getAllCustomers(@PathVariable("id") String EmailId){
        return customerService.getCustomerByEmailId(EmailId);
    }

    @PostMapping("/add")
    public CustomerResponse addCustomer(@RequestBody CustomerRequest customerRequest){
        System.out.println("customer: "+customerRequest.getFirstName()+" "+customerRequest.getLastName()+" "+customerRequest.getEmailId());
        return customerService.addCustomer(customerRequest);
    }

    @PutMapping("/update")
    public CustomerResponse updateCustomer(@RequestBody CustomerUpdateRequest customerUpdateRequest){
        return customerService.updateCustomer(customerUpdateRequest);
    }

    @DeleteMapping("/delete/{emailId}")
    public void deleteCustomer(@PathVariable String emailId){
        customerService.deleteCustomerByEmail(emailId);
    }
}
