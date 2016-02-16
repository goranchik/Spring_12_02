package com.study.lab1.dao;

import com.study.lab1.cache.AccountCache;
import com.study.lab1.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDao {

    @Autowired
    private MockDataSource dataSource;

    @Autowired
    private AccountCache accountCache;

    public Account get(long id) {
        long start = System.currentTimeMillis();
        Account account = new Account();

        Account accountCopy = accountCache.getAccount(id);

        account.setId(accountCopy.getId());
        account.setBalance(accountCopy.getBalance());

        if (account == null) {
            account = dataSource.getAccount(id);
        }
        System.out.println("Getting account took : " + (System.currentTimeMillis() - start));
        return account;
    }

    public void update(Account account) {
        long start = System.currentTimeMillis();
        dataSource.updateAccount(account);
        System.out.println("Updating account cache");
        accountCache.update();
        System.out.println("Updating account took : " + (System.currentTimeMillis() - start));
    }
}
