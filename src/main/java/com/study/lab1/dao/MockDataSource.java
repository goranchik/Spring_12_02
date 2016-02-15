package com.study.lab1.dao;

import com.study.lab1.model.Account;
import com.study.lab1.model.User;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class MockDataSource {
    private List<Account> accounts = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    // create some mock data in data source.
    public MockDataSource() {
        for (int i = 1; i < 5; i++) {
            double balance = new BigDecimal(1000 * Math.random())
                    .setScale(2, RoundingMode.UP).doubleValue();
            accounts.add(new Account(i, balance));
            users.add(new User(i));
        }
    }

    public void updateAccount(Account account) {
        Account accountToUpdate = null;//
        for (Account account1 : accounts) {
            if (account1.getId() == account.getId()){
                accountToUpdate = account1;
            }
        }
        // = accounts.stream().filter(i -> i.getId() == account.getId()).findAny().orElse(null);
        if (accountToUpdate != null) {
            accountToUpdate.setBalance(account.getBalance());
        }
    }

    public Account getAccount(long id) {
        try {
            // call to datasource take some time :) maybe we should optimize?
            Thread.sleep(generateTimeout());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (Account account : accounts) {
            if (account.getId() == id){
                return copy(account);
            }
        }
        //Account account = accounts.stream().filter(i -> i.getId() == id).findAny().orElse(null);
        //return copy(account);
        return null;
    }

    public User getUser(long id) {
        try {
            // call to datasource take some time :) maybe we should optimize?
            Thread.sleep(generateTimeout());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (User user : users) {
            if (user.getId() == id) {
                return copy(user);
            }
        }
        return null;
    }

    // to prevent direct data source changes
    private Account copy(Account accountToCopy) {
        if (accountToCopy == null) {
            return null;
        }
        Account account = new Account();
        account.setId(accountToCopy.getId());
        account.setBalance(accountToCopy.getBalance());
        return account;
    }

    // to prevent direct data source changes
    private User copy(User userToCopy) {
        if (userToCopy == null) {
            return null;
        }

        return new User(userToCopy.getId());
    }

    private int generateTimeout(){
        return (int) (1000 * Math.random());
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public List<User> getUsers() {
        return users;
    }
}
