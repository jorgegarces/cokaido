package com.lifull.bankata.infrastructure;

import com.lifull.bankata.domain.transaction.Transaction;

public interface TransactionRepository {

    void save(Transaction transaction);
    String getStatement();

}
