package com.course.testng.parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest {
    @Test(dataProvider = "param")
    public void testDataProvider(String name,int age)
    {
        System.out.println("name = "+name +"; age = "+age);
    }
    @DataProvider(name = "param")
    public Object[][] ProviderData()
    {
        Object[][] result = new Object[][]{{"zhangsan", 20},
                {"lisi",30}};
        return result;
    }
    @Test(dataProvider = "data")
    public void test1(String name ,int age)
    {
        System.out.println("test1的name = "+name+"; age = "+age);
    }
    @Test(dataProvider = "data")
    public void test2(String name,int age)
    {
        System.out.println("test2的name = "+name+"; age = "+age);
    }
    @DataProvider(name = "data")
    public Object[][] providerDataTest(Method method)
    {
        Object[][] result = null;
        if(method.getName().equals("test1"))
        {
            result = new Object[][]{{"wangwu",30},{"zhaoliu",50}};
        }
        else if (method.getName().equals("test2"))
        {
            result = new Object[][]{{"lili",15},{"lucy",60}};
        }
        return result;
    }
}
