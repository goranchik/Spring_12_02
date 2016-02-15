package com.study.lab1.cache;

import com.study.lab1.dao.MockDataSource;
import com.study.lab1.model.Account;
import com.study.lab1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dsk14 on 15.02.2016.
 */
@Service
public class UserCache {

    @Autowired
    private MockDataSource dataSource;

    private List<User> users = dataSource.getUsers();

    public User getUser(long id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

}
