package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups="student")
public class GroupsOnClass1 {
    public void stu1() {
        System.out.println("GroupsOnClass1上的stu1执行啦~");
    }
    public void stu2()
    {
        System.out.println("GroupsOnClass1上的stu2执行啦~");
    }
}