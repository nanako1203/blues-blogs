package com.example.bluesblogs.service;

import com.example.bluesblogs.pojo.User;

/**
 * @Author nanako
 * @Date 2024/8/14
 * @Description
 */
public interface UserService {
    /*
    根据用户名注册用户
     */
    User findByUsername(String username);

    /*
    根据用户名注册
     */
    void register(String username, String password);
}
