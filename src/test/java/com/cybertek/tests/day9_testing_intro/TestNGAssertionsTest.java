package com.cybertek.tests.day9_testing_intro;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestNGAssertionsTest {
    //Assert -> a class in testng provides assertion
    //       -> method that does verification like compairing
    //

    @Test
    public void test1() {
        String expected = "one";
        String actual = "two";

        Assert.assertEquals(actual, expected);
//        Assert.assertEquals(1,1);
//        Assert.assertEquals(true,true);
    }
    @Test
    public void test2() {
        boolean expected = true;
        boolean actual = true;
        //the message "starting to compare"
        //this will print
        System.out.println("starting to compare");
        Assert.assertEquals(actual, expected);
        //the message "test 2 complete"
        //this should not print
        //if it prints out on your console it meant
        //you have a problem on your code
        System.out.println("test 2 complete");
    }
    @Test
    public void test3() {
        String expected = "one";
        String actual = "two";
        Assert.assertNotEquals(actual, expected);
//        Assert.assertNotEquals(1, 1);
    }
    @Test
    public void test4() {
//        String expected = "one";
//        String actual = "two";
//
//        Assert.assertTrue(expected.equals(actual));
//        //assertTrue

        int e = 100;
        int a = 200;

        Assert.assertTrue(a>e);

    }

    @Test
    public void test5() {
//        String expected = "https://www.google.com";
//        String actual = "https://www.google.com";
//        Assert.assertEquals(expected, actual);

        String expected1 = "java";
        String actual2 = "java - Google Search";
        Assert.assertTrue(actual2.contains(expected1));
        System.out.println("this test failed");
    }

}
