package com.cybertek.tests.day9_testing_intro;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BeforeAndAfterTest {
    @BeforeMethod
    //execute before the m
    public void beforeMethod() {
        System.out.println("\tBefore Method");
    }
    @AfterMethod
    public void afterMethod() {
        System.out.println("\tAfter Method");
    }
    @Test
    public void test1() {
        System.out.println("this is test one");

    }
    @Test
    public void test2() {
        System.out.println("this is test two");
    }
}
