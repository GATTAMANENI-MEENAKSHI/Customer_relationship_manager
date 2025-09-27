package com.example.customer_relationship_manager.Repository;

import com.example.customer_relationship_manager.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    Optional<Customer> findByEmailId(String emailId);
    Optional<Customer> findByEmailIdAndFirstNameAndLastName(String emailId,String firstName,String lastName);
}
