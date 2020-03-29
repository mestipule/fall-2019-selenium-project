package com.cybertek.tests.day4.xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.cybertek.utilities.WebDriverFactory;

public class XpathPractice {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //locate user box and send something
        //use relative xpath

        driver.get("http://practice.cybertekschool.com/login");
        WebElement username = driver.findElement(By.xpath(("//input[@type='text']")));
        username.sendKeys("mestipule");
        driver.close();
    }
}
