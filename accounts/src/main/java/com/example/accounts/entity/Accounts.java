package com.example.accounts.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter@Setter@ToString@AllArgsConstructor@NoArgsConstructor
public class Accounts extends BaseEntity{

    private Integer customerId;

    @Id
    private Integer accountNo;
    private String accountType;
    private String branchAddress;
}
