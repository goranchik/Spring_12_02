package com.study.lab1.cache;

import com.study.lab1.dao.MockDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dsk14 on 16.02.2016.
 */
@Service
public abstract class AbstractCache {
    @Autowired
    MockDataSource dataSource;
}
