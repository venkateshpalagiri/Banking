package com.venkatesh.banking.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name="accounts")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="account_holder_name")
    private String accountHolder;
    private double balance;
}
