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

public class ImplicitWaitExamples {
    /*
    WAITS AND SYNCHRONIZATION
                    Thread.sleep -> also known unconditional waiting, not selenium
                                 -> from Java
                                 -> pauses the execution of program
                                 -> it executes or waits for the full duration of a given time

                    Implicit Waits -> from selenium
                                   -> they are also conditional waits
                                   -> this kicks in automatically when we are trying to find element using findElement method

                               driver.manage().timeouts().implicitlyWait()(7, TimeUnit.SECONDS);
                                    -> when they are talking about implicit waits they are talking about this method
                                    -> this line of codes does a lot of good things
                                    -> when we set implicit wait to certain time, driver will not immediately throw
                                            exception when it cannot find element.
                                    -> it will keep trying to find the element for the duration given
                                    -> this is applies with NoSuchElementException
                                    -> this line of code can go to BeforeMethod, or at the start of your method it will still
                                            run  because it doesn't depends where we put this method.
                                            (while Thread.sleep will only run when it run that certain code)
                                    -> ONLY WORKS WITH FIND ELEMENT
                                    -> for the duration of time given, it will keep trying to find the element
                                    -> this method will return as soon as there are more than 0 items in the found collection, or will
                                            return an empty list if the timeout is reached


                    Difference between Implicit and Thread.sleep()
                        1.  this line of code can go to BeforeMethod, or at the start of your method it will still
                                            run  because it doesn't depends where we put this method.
                                            (while Thread.sleep will only run when it run that certain code)
                        2.  implicit wait stops waiting if the condition is fulfilled, that is if element matching that
                                            locator is found (while Thread.sleep will finish the time specified for
                                            the wait)

                    ***  Where to put implicit wait *****
                        -> this should be before we find the element...
                        -> if you put after you will going to get an error
                        -> put it in the beginning
                        -> safest is at the beginning of the method

                    How the implicit wait works for findElements method?

                        driver.findElements(By.tagNAme("input"))
                                -> this method will return as soon as there are more than 0 items in the found collection, or will
                                            return an empty list if the timeout is reached



                    Explicit Waits

                    Why we get NoSuchElementException:
                        (NoSuchElementException)
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
    public void test1() throws InterruptedException{
        driver.get("http:practice.cybertekschool.com/dynamic_loading/4");
        // you need to import timeunit inorder to use timeouts and implicitlywait
        //here  driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS); is being called
        //this is because we move it from here to  @BeforeMethod
        WebElement helloWorld = driver.findElement(By.cssSelector("#finish>h4"));
        Assert.assertTrue(helloWorld.isDisplayed());
        System.out.println(helloWorld.getText());
        driver.get("http:practice.cybertekschool.com/dynamic_loading/2");
        WebElement button = driver.findElement(By.tagName("button"));
        button.click();;
        helloWorld = driver.findElement(By.cssSelector("#finish>h4"));
        Assert.assertTrue(helloWorld.isDisplayed());
        System.out.println(helloWorld.getText());
    }
}
