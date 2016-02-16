package com.study.lab1.cache;

import com.study.lab1.model.Account;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by dsk14 on 15.02.2016.
 */

@Service
public class AccountCache extends AbstractCache{

    private List<Account> accounts;

    @PostConstruct
    public void update() {
        accounts = dataSource.getAccounts();
    }

    public Account getAccount(long id) {
        for (Account account : accounts) {
            if (account.getId() == id) {
                return account;
            }
        }
        return null;
    }

}
