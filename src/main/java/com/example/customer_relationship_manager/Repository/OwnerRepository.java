package com.example.customer_relationship_manager.Repository;

import com.example.customer_relationship_manager.Model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OwnerRepository extends JpaRepository<Owner,Integer> {
    Optional<Owner> findByEmailId(String emailId);
}
