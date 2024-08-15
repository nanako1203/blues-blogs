package com.example.bluesblogs.service.impl;

import com.example.bluesblogs.mapper.UserMapper;
import com.example.bluesblogs.pojo.User;
import com.example.bluesblogs.service.UserService;
import com.example.bluesblogs.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author nanako
 * @Date 2024/8/14
 * @Description
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /*
     * 根据用户名查询用户*/
    @Override
    public User findByUsername(String username) {
        User user = userMapper.findByUsername(username);
        return user;
    }

    /*
     * 注册用户*/
    @Override
    public void register(String username, String password) {
//        加密
       String md5Password = Md5Util.getMD5String(password);
       userMapper.register(username, md5Password);

    }
}
