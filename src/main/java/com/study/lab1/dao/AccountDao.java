package com.study.lab1.dao;

import com.study.lab1.model.Account;

public class AccountDao {
    private MockDataSource dataSource = new MockDataSource();

    public Account get(long id) {
        long start = System.currentTimeMillis();
        Account account = dataSource.getAccount(id);
        System.out.println("Getting account took : " + (System.currentTimeMillis() - start));
        return account;
    }

    public void update(Account account) {
        long start = System.currentTimeMillis();
        dataSource.updateAccount(account);
        System.out.println("Updating account took : " + (System.currentTimeMillis() - start));
    }
}
