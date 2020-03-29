package com.cybertek.tests.testing.day10_webelement;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButton {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod() {
         driver = WebDriverFactory.getDriver("firefox");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        String expectedTitle = "Practice";
        Assert.assertEquals(expectedTitle, driver.getTitle());

    }

    @AfterMethod
    public void afterMethod() {
//        driver.quit();
    }

    @Test
    public void test1(){

        /*
        go to http://practice.cybertekschool.com/
        verify that blue is selected
        red is not selected
         */

        WebElement blue = driver.findElement(By.id("blue"));
        //isSelected -> returns true if element is selected
        //verify is the radio button is selected
        Assert.assertTrue(blue.isSelected());
        WebElement red = driver.findElement(By.id("red"));
        Assert.assertTrue(red.isSelected());
    }

    @Test
    public void test() throws Exception {
        WebElement red = driver.findElement(By.id("red"));
        WebElement blue = driver.findElement(By.id("blue"));
        red.click();
        Thread.sleep(3000);
        Assert.assertTrue(blue.isSelected());
        /*
        chanined declaration:
        //div[@class='radio']//input[@id='yellow']
        preceding-sibling
        //label[@class='form-check-label']/preceding-sibling::input[@id='yellow']
        * */
    }
}
