package com.fullstck.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fullstck.domain.USER_ROLE;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fullName;
    private String email;
    private Long phoneNumber;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private USER_ROLE role = USER_ROLE.ROLE_CUSTOMER;   //default role

    @Embedded
    private TwoFactorAuth twoFactorAuth = new TwoFactorAuth();
}
