package com.course.testng;

import org.testng.annotations.*;

public class BasicAnnotation {
    @Test
    public void testCase1()
    {
        System.out.println("testCase1这是第一个测试用例");
    }
    @Test
    public void testCase2()
    {
        System.out.println("testCase2这是第二个测试用例");
    }
    @BeforeMethod
    public void beforeMethod()
    {
        System.out.println("beforeMethod这是在方法之前执行的");
    }
    @AfterMethod
    public void afterMethod()
    {
        System.out.println("afterMethod这是在方法之后执行的");
    }
    @BeforeClass
    public void beforeClass()
    {
        System.out.println("beforeClass这是在类运行之前执行的");
    }
    @AfterClass
    public void afterClass()
    {
        System.out.println("afterClass这是在类运行之后执行的");
    }
    @BeforeSuite
    public void beforeSuit()
    {
        System.out.println("beforeSuit这是在套件运行之前执行的");
    }
    @AfterSuite
    public void afterSuit()
    {
        System.out.println("afterSuit这是在套件运行之后执行的");
    }
}
