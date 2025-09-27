package com.example.customer_relationship_manager.DTO;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CustomerResponse {
    private String firstName;
    private String lastName;
    private String emailId;
}
