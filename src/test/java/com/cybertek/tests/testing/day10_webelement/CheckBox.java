package com.cybertek.tests.testing.day10_webelement;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckBox {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverFactory.getDriver("firefox");
        driver.get("http://practice.cybertekschool.com/checkboxes");
        String expectedTitle = "Practice";
        Assert.assertEquals(expectedTitle, driver.getTitle());

    }

    @AfterMethod
    public void afterMethod() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void test() {
        WebElement one = driver.findElement(By.xpath("//input[1]"));
        WebElement two = driver.findElement(By.xpath("//input[2]"));
        System.out.println("click one first");
        one.click();
        Assert.assertTrue(one.isSelected());
        System.out.println("i thought this won't work?");

    }
}
