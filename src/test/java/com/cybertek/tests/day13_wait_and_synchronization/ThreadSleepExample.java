package com.cybertek.tests.day13_wait_and_synchronization;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ThreadSleepExample {

     /*
                  WAITS AND SYNCHRONIZATION
                    Thread.sleep -> also known unconditional waiting, not selenium
                                 -> from Java
                                 -> pauses the execution of program
                                 -> it executes or waits for the full duration of a given time

                    Implicit Waits -> from selenium
                                   -> they are also conditional waits
                                   -> this kicks in automatically when we are trying to find element using findElement method

                    Explicit Waits

                    Why we get NoSuchElementException:
                        (NoSuchElemetException)
                        1.  Wrong locator
                        2.  Waits
                        3.  Iframe
        */



    WebDriver driver;
    @BeforeMethod
    public void setUp() throws InterruptedException{
        driver = WebDriverFactory.getDriver("chrome");
        //put it here so we can use it to different test methods
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        /*be careful what you put in here because it will be really implemented in all tests*/
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void test() throws InterruptedException{
        driver.get("http://practice.cybertekschool.com/dynamic_loading/4");

        // ---> Thread.sleep can be skip since we put implicit wait in the BeforeMethod
//        Thread.sleep(7000);
        //this is a cssSelector and taking the child with a tag h4

        WebElement helloWorld = driver.findElement(By.cssSelector("#finish>h4"));

        Assert.assertTrue(helloWorld.isDisplayed());
        System.out.println(helloWorld.getText());
    }

    @Test
    public void test1() {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/4");

        WebElement helloWorld = driver.findElement(By.cssSelector("#finish>h4"));
        Assert.assertTrue(helloWorld.isDisplayed());
        System.out.println(helloWorld.getText());
        driver.get("http:practice.cybertekschool.com/dynamic_loading/2");
        WebElement button = driver.findElement(By.tagName("button"));

    }
}
