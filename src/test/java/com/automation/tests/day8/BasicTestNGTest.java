package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.*;

public class BasicTestNGTest {

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
    }

    @AfterTest
    public void beforTest  (){
        System.out.println("After test");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("before Class");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }

    @AfterMethod
    public void aftermethod(){
        System.out.println("after method");
    }

    @BeforeMethod
    public void setup(){
        System.out.println("before method");
    }


    @Test
    public void test1(){
        System.out.println("test 1");
        String expected = "apple";
        String actual = "apple";
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void test2 (){
        System.out.println("test 2");
        int num1 = 5;
        int num2 = 10;
        // it calls hard assertion
        // if assertion fails, it stops the execution (due to exception)
        Assert.assertTrue(num1 < num2);
    }
}
