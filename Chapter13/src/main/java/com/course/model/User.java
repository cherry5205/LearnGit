package com.course.model;

import lombok.Data;


public class User {
    private String name;
    private int id;
    private String password;
    private int age;
    private String sex;
    private String permission;
    private String deleted;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", permission='" + permission + '\'' +
                ", deleted='" + deleted + '\'' +
                '}';
    }

    public User() {
    }

    public User(String name, int id, String password, int age, String sex, String permission, String isDelete) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.age = age;
        this.sex = sex;
        this.permission = permission;
        this.deleted = isDelete;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public void setDeleted(String isDelete) {
        this.deleted = isDelete;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public String getPermission() {
        return permission;
    }

    public String getDeleted() {
        return deleted;
    }
}
