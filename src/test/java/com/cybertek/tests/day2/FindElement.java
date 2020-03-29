package com.cybertek.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElement {
    public static void main(String[] args) {
        //locator: id
        // choose id all the time
        //use id only use it if it's usefull name
        //go to cybertek okta login page

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://cybertekschool.okta.com/");
        driver.manage().window().maximize();
        WebElement emailBox = driver.findElement(By.id("okta-signin-username"));
        emailBox.sendKeys("mestipul@gmail.com");



















    }
}
