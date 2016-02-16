package com.study.lab1.dao;

import com.study.lab1.cache.UserCache;
import com.study.lab1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDao {

    @Autowired
    private MockDataSource dataSource;

    @Autowired
    private UserCache userCache;

    public User getUser(long id) {
        long start = System.currentTimeMillis();
        User user = userCache.getUser(id);
        if (user == null) {
           user = dataSource.getUser(id);
        }
        System.out.println("getting user took : " + (System.currentTimeMillis() - start));
        return user;

    }

}
