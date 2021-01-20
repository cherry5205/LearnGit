package com.course.testng.groups;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsOnMethod {
    @Test(groups = {"server"})
    public void test1()
    {
        System.out.println("这是服务端组的test1");
    }
    @Test(groups={"server"})
    public void test2()
    {
        System.out.println("这是服务端组的test2");
    }
    @Test(groups = {"client"})
    public void test3()
    {
        System.out.println("这是客户端组的test3");
    }
    @Test(groups = {"client"})
    public void test4()
        {
        System.out.println("这是客户端组的test4");
    }
    @BeforeGroups("server")
    public void beforeGroupsOnServer()
    {
        System.out.println("这是在服务端组执行前执行的~");
    }
    @AfterGroups("server")
    public void afterGroupsOnServer()
    {
        System.out.println("这是在服务端组执行之后执行的~");
    }
    @BeforeGroups("client")
    public void beforeGroupsOnClient()
    {
        System.out.println("这是在客户端组执行之前执行的~");
    }
    @AfterGroups("client")
    public void AfterGroupsOnClient()
    {
    System.out.println("这是在客户端级执行之后执行的~");
    }


}
