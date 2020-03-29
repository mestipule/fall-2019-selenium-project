package com.cybertek.tests.day9_testing_intro;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class FirstTestNGTest {
    @Test
    //needs to get the one from org.testng.annotations
    public void test1() {
        System.out.println("test one");
    }
    @Ignore
    //this annotation will ignore the test2 method which
    //affect the rest of the code

    @Test
    public void test2() {
        System.out.println("test two");
    }

    //methods is always camelcase
    //but testNG can be different
    public void test3() {
        System.out.println("test three");
    }

}
