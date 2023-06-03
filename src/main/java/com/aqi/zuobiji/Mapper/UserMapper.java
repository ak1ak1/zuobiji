package com.aqi.zuobiji.Mapper;

import com.aqi.zuobiji.Entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    /**
     * 通过账号查找用户
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    Integer updateRegisterTimeById(User user);

    /**
     * 添加用户
     * @return
     */
    Integer insertUserByUser(User user);

    /**
     * 通过id查询用户信息
     * @param id
     * @return
     */
    User findInfoByid(Integer id);
}
