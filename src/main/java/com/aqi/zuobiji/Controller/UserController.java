package com.aqi.zuobiji.Controller;

import com.aqi.zuobiji.Entity.User;
import com.aqi.zuobiji.Service.UserService;
import com.aqi.zuobiji.Service.ex.ServiceException;
import com.aqi.zuobiji.Utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController extends BaseController{
    
    @Autowired
    private UserService userService;
    
    @RequestMapping("login")
    public JsonResult Login(String username, String password){
        System.err.println(username);
        Map<String, String> map =userService.login(username,password);
        return new JsonResult(200, "登陆成功", map);
    }
    
    @RequestMapping("enroll")
    public JsonResult enroll(String username, String password, Integer type){
        userService.enroll(username, password, type);
        return new JsonResult(200, "注册成功");
    }
    
    @RequestMapping("get_user_info")
    public JsonResult getUserInfo(@RequestHeader("Authorization") String token){
        User user = userService.getUserInfo(token);
        User userReturn = new User();
        userReturn.setUsername(user.getUsername());
        userReturn.setType(user.getType());
        userReturn.setAvatar(user.getAvatar());
        Map<String, User> map = new HashMap<>();
        map.put("user",userReturn);
        return new JsonResult(OK, "获取用户信息成功", map);
    }
    
}
