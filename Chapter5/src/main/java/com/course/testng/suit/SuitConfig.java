package com.course.testng.suit;

import org.testng.annotations.*;

public class SuitConfig {
    @BeforeSuite
    public void BeforeSuit()
    {
        System.out.println("BeforeSui运行啦~");
    }
    @AfterSuite
    public void AfterSuit()
    {
        System.out.println("AfterSuit运行啦~");
    }
   @BeforeTest
    public void BeforeTest()
    {
        System.out.println("BeforeTest运行啦~");
    }
    @AfterTest
    public void AfterTest()
    {
        System.out.println("AfterTest运行啦~");
    }
    @BeforeClass
    public void BeforeClass()
    {
        System.out.println("BeforeClass运行啦~");
    }
    @AfterClass
    public void AfterClass()
    {
        System.out.println("AfterClass运行啦~");
    }

}
