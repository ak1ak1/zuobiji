package com.aqi.zuobiji.Service;

import com.aqi.zuobiji.Entity.User;

import java.util.Map;

public interface UserService {
    /**
     * 登录
     * @param username
     * @return
     */
    Map<String, String> login(String username, String password);

    /**
     * 用户注册
     * @param username
     * @param password
     * @return
     */
    void enroll(String username, String password, Integer type);

    /**
     * 获取用户信息（一般用于登录之后获取）
     * @param token
     * @return
     */
    User getUserInfo(String token);
}
