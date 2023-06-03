package com.aqi.zuobiji.Mapper;

import com.aqi.zuobiji.Entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserMapperTests {
    @Autowired
    private UserMapper userMapper;
    
    @Test
    public void findByUsernameTest(){
        User user = userMapper.findByUsername("admin");
        System.out.println(user);
    }
    
    
}
