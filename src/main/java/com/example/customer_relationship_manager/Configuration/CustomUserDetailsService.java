package com.example.customer_relationship_manager.Configuration;

import com.example.customer_relationship_manager.Model.Owner;
import com.example.customer_relationship_manager.Repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    OwnerRepository ownerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Owner> person = ownerRepository.findByEmailId(username);
        if(person.isEmpty()) {
            throw new RuntimeException("Invalid username");
        }

        return new CustomUserDetails(person.get());
    }
}
