package com.cybertek.tests.testing.day10_webelement;

import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderOfTests {
    String title;
    @Test(priority = 3)
    public void login()  {
        System.out.println("opening the browser");
        System.out.println("capturing title");
    }
    @Test(priority = 1)
    public void assertTitle() {
        System.out.println("verifying the title");
        Assert.assertEquals(title, "cbt");
    }
//    }
//    @Test(priority = 55)
//    public void verifyOtherThings()  {
//        System.out.println("verify sth else");
//    }
}
