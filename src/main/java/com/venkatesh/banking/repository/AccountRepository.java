package com.venkatesh.banking.repository;

import com.venkatesh.banking.entity.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account,Long> {
}
