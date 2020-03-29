package com.cybertek.tests.day11_select_actions;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecutorTests {
    WebDriver driver;
    Actions actions;
    JavascriptExecutor jse;
    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        actions = new Actions(driver);
        jse = (JavascriptExecutor) driver;
    }

    @AfterMethod
    public void afterMethod() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void scroll() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com");
        WebElement link = driver.findElement(By.linkText("Cybertek School"));
        jse.executeScript("arguments[0].scrollIntoView(true);", link);

        Thread.sleep(5000);
    }
    @Test
    public void sendKeysWithJS() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        WebElement input = driver.findElement(By.cssSelector("input[disabled"));
        Thread.sleep(3000);
        String text = "hi world";
        jse.executeScript("arguments[0].setAttribute('value', '" + text + "')", input);
        //arguments[0].setAttributes('value', 'Hi world')
    }
    @Test
    public void sendKeysWithJSAgain() {

    }
}
