package com.course.testng.depend;

import org.testng.annotations.Test;
public class DependTestOnGroups {
    @Test(groups = "server")
    public void test1()
    {
        System.out.println("DependTestOnGroups中的sever组test1执行");
    }
    @Test(groups = "server")
    public void test2()
    {
        System.out.println("DependTestOnGroups中的server组test2执行");
        throw new RuntimeException();

    }
    @Test(groups = "client")
    public void test3()
    {
        System.out.println("DependTestOnGroups中的client组test3执行");
    }
    @Test(groups = "client")
    public void test4()
    {
        System.out.println("DependTestOnGroups中的client组test4执行");
    }
    @Test(dependsOnGroups = {"server"})
    public void test5()
    {
        System.out.println("DependTestOnGroups中的test5执行");
    }
}
