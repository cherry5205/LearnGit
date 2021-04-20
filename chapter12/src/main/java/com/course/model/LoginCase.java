package com.course.model;

import lombok.Data;

@Data
public class LoginCase {
    private String id;
    private String name;
    private String password;
    private String expected;

    @Override
    public String toString() {
        return "LoginCase{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", expected='" + expected + '\'' +
                '}';
    }

    public LoginCase() {
    }

    public LoginCase(String id, String name, String password, String expected) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.expected = expected;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getExpected() {
        return expected;
    }

    public void setExpected(String expected) {
        this.expected = expected;
    }
}
