package com.example.customer_relationship_manager.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerUpdateRequest {
    private String firstName;
    private String lastName;
    private String emailId;
    private String previousEmailId;
}
