package com.study.lab1.cache;

import com.study.lab1.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by dsk14 on 15.02.2016.
 */
@Service
public class UserCache extends AbstractCache{

    private List<User> users;

    @PostConstruct
    public void update() {
        users = dataSource.getUsers();
    }

    public User getUser(long id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

}
