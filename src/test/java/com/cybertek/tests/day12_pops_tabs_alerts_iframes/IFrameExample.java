package com.cybertek.tests.day12_pops_tabs_alerts_iframes;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IFrameExample {
    WebDriver driver;
    Actions actions;
    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        actions = new Actions(driver);
    }

    @AfterMethod
    public void afterMethod() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/tinymce");
        //your telling your driver
        driver.switchTo().frame("mce_0_ifr");
        //to change frames

        WebElement textBox = driver.findElement(By.id("tinymce"));
        Thread.sleep(3000);
        textBox.clear();
        Thread.sleep(3000);
        textBox.sendKeys("great. thanks");
        //going back to the html outside your html

        //going to html i think
        driver.switchTo().defaultContent();
        System.out.println(driver.findElement(By.tagName("h3")).getText());

        //switch by webelement
        WebElement frame = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(frame);

        textBox = driver.findElement(By.id("tinymce"));
        Thread.sleep(3000);
        textBox.clear();
        textBox.sendKeys("great. thanks one time");

        //get out of frame but not html -> frame is a bit crazy
        driver.switchTo().parentFrame();
        System.out.println(driver.findElement(By.tagName("h3")).getText());

        //switch by index
        driver.switchTo().frame(0);

    }
}
