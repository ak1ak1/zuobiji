package com.aqi.zuobiji.Entity;

import java.util.Date;
import java.util.Objects;

public class BaseEntity {
    private Integer isDelete;
    private Date registerTime;
    private Date createdTime;
    private Integer createdUser;
    private Date modifiedTime;
    private Integer modifiedUser;

    @Override
    public String toString() {
        return "BaseEntity{" +
                "isDelete=" + isDelete +
                ", registerTime=" + registerTime +
                ", createdTime=" + createdTime +
                ", createdUser=" + createdUser +
                ", modifiedTime=" + modifiedTime +
                ", modifiedUser=" + modifiedUser +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity that = (BaseEntity) o;
        return Objects.equals(isDelete, that.isDelete) && Objects.equals(registerTime, that.registerTime) && Objects.equals(createdTime, that.createdTime) && Objects.equals(createdUser, that.createdUser) && Objects.equals(modifiedTime, that.modifiedTime) && Objects.equals(modifiedUser, that.modifiedUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isDelete, registerTime, createdTime, createdUser, modifiedTime, modifiedUser);
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Integer getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(Integer createdUser) {
        this.createdUser = createdUser;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Integer getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(Integer modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public BaseEntity(Integer isDelete, Date registerTime, Date createdTime, Integer createdUser, Date modifiedTime, Integer modifiedUser) {
        this.isDelete = isDelete;
        this.registerTime = registerTime;
        this.createdTime = createdTime;
        this.createdUser = createdUser;
        this.modifiedTime = modifiedTime;
        this.modifiedUser = modifiedUser;
    }

    public BaseEntity() {
    }
}
