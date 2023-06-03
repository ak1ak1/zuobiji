package com.aqi.zuobiji.Entity;

import java.util.Date;
import java.util.Objects;

public class User extends BaseEntity{
    private Integer id;
    private String username;
    private String password;
    private String salt;
    private Integer type;
    private String avatar;


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", type=" + type +
                ", avatar='" + avatar + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(salt, user.salt) && Objects.equals(type, user.type) && Objects.equals(avatar, user.avatar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, username, password, salt, type, avatar);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public User(Integer isDelete, Date registerTime, Date createdTime, Integer createdUser, Date modifiedTime, Integer modifiedUser, Integer id, String accountNumber, String password, String salt, Integer type, String avatar) {
        super(isDelete, registerTime, createdTime, createdUser, modifiedTime, modifiedUser);
        this.id = id;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.type = type;
        this.avatar = avatar;
    }

    public User(Integer id, String username, String password, String salt, Integer type, String avatar) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.type = type;
        this.avatar = avatar;
    }

    public User() {
    }
}
