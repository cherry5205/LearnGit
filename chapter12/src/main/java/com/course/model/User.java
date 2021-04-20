package com.course.model;
import lombok.Data;
@Data
public class User {
    private int id;
    private String name;
    private String password;
    private int age;
    private String sex;
    private String permission;
    private String deleted;
    @Override
    public String toString()
    {
        return (
                "id:"+id+","+
                 "name:"+name+","+
                 "password:"+password+","+
                 "age:"+age+","+
                 "sex:"+sex+","+
                 "permission:"+permission+","+
                 "deleted:"+deleted+"}"
        );

    }

}
