package com.aqi.zuobiji.Service.Impl;

import com.aqi.zuobiji.Entity.User;
import com.aqi.zuobiji.Mapper.UserMapper;
import com.aqi.zuobiji.Service.UserService;
import com.aqi.zuobiji.Service.ex.ServiceException;
import com.aqi.zuobiji.Utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    
    @Override
    public Map<String, String> login(String username, String password) {
        /** 查找是否存在该用户*/
        User resultUser = userMapper.findByUsername(username);
        if (resultUser == null)
            throw new ServiceException("该账号不存在");
        Integer id = resultUser.getId();
        /** 验证密码*/
        String md5Password = getMd5Password(password, resultUser.getSalt());
        if (!md5Password.equals(resultUser.getPassword()))
            throw new ServiceException("密码错误");
        /** 验证密码成功后则登录成功，修改登录信息*/
        User user = new User(); //创建一个仅包含id、登陆时间的User对象，传回数据库更改
        user.setId(id);    //  登录者的ID
        user.setRegisterTime(new Date()); //登录时间
        Integer rows =  userMapper.updateRegisterTimeById(user);
        if (rows != 1)
            throw new ServiceException("登录信息更新失败");
        
        /** 生成token*/
        String token = JWTUtils.sign(id); //通过id生产token
        if (token == null)
            throw new ServiceException("token生成失败");
        /** 登录成功后，返回token和用户身份*/
        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        map.put("type",resultUser.getType().toString());
        return map;
    }

    
    @Override
    public void enroll(String username, String password, Integer type) {
        /** 查询该账号是否已被注册*/
        if(userMapper.findByUsername(username) != null)
            throw new ServiceException("用户已被注册");
        /** 获取随机盐值*/
        String salt = UUID.randomUUID().toString().toUpperCase();
        /** 将密码变为md5加密后的密码*/
        String md5Password = getMd5Password(password, salt);
        /** 补充用户信息*/
        User user = new User();
        Date date = new Date();
        user.setUsername(username);
        user.setPassword(md5Password);
        user.setSalt(salt);
        user.setType(type);
        user.setIsDelete(0);
        user.setCreatedTime(date);
        user.setCreatedUser(0);
        Integer rows = userMapper.insertUserByUser(user);
        if (rows != 1)
            throw new ServiceException("数据库新增用户失败");
    }

    @Override
    public User getUserInfo(String token) {
        Integer id;
        if (!JWTUtils.verify(token) || (id= JWTUtils.getUserId(token)) == null)
            throw new ServiceException("token验证失败");
        User user = userMapper.findInfoByid(id);
        return user;
    }


    public String getMd5Password(String password, String salt){
        return DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();
    }
}
