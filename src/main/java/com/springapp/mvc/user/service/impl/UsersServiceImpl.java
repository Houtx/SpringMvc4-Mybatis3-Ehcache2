package com.springapp.mvc.user.service.impl;

import com.springapp.mvc.user.dao.UsersDao;
import com.springapp.mvc.user.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by HouTianxiang on 2017/8/3.
 */
@Service
@Transactional
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersDao userDao;

    @Override
    @Cacheable(value = "myCache",key = "#Username")
    public String getUserPwdByUsername(String Username) {
        return userDao.getUserPwdByUsername(Username);
    }
}
