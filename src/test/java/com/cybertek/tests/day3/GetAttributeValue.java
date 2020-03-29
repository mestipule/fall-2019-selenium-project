package com.cybertek.tests.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttributeValue {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/login");
        driver.manage().window().maximize();
        //I want to ge the value of the type attributes value in username box
        //type = 'tet'  --> getAttribute("attribute name")

        //locat username box
        WebElement username = driver.findElement(By.name("username"));
        String valueOfType = username.getAttribute("type");//this is the attribute name
        System.out.println(valueOfType);
        //this will say text because this is the value of your attribute
    }
}
