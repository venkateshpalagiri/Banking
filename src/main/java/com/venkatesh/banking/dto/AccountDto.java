package com.venkatesh.banking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;


@Data

@AllArgsConstructor

public class AccountDto {
    @Id
    private Long id;
    private String accountHolder;
    private double balance;
}
