package com.example.customer_relationship_manager.Service;

import com.example.customer_relationship_manager.Model.Owner;
import com.example.customer_relationship_manager.Repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OwnerService {

    @Autowired
    OwnerRepository ownerRepository;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String addPerson(Owner owner) {
        if(ownerRepository.findByEmailId(owner.getEmailId()).isPresent()){
            return "Owner with specified email is already registered";
        }
        owner.setPassword(passwordEncoder.encode(owner.getPassword()));
        ownerRepository.save(owner);
        return "Owner Added";
    }

    public String getOwnerByEmailId(String email) {
        Optional<Owner> optionalOwner= ownerRepository.findByEmailId(email);
        if(optionalOwner.isEmpty()){
            return "User with the specified email id doesn't exist";
        }
        return "User found";
    }

    public String forgotPassword(Owner owner) {
        Optional<Owner> optionalOwner= ownerRepository.findByEmailId(owner.getEmailId());
        if(optionalOwner.isEmpty()){
            return "There is no customer with this email id";
        }
        Owner newOwner = optionalOwner.get();
        newOwner.setPassword(passwordEncoder.encode(owner.getPassword()));
        ownerRepository.save(newOwner);
        return "password updated successfully";
    }
}
