package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "teacher")
public class GroupsOnClass3 {
    public void tech1()
    {
        System.out.println("GroupsOnClass3中的tech1执行啦~");
    }
    public void tech2()
    {
        System.out.println("GroupsOnClass3中的tech2执行啦~");
    }
}
