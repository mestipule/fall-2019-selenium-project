package com.cybertek.tests.day4.xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttribute {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement submitBttn = driver.findElement(By.id("form_submit"));
        System.out.println(submitBttn.getAttribute("type"));
        System.out.println(submitBttn.getAttribute("class"));

        /* asiya's code
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dynamic_loading");
// TODO linktext
        //locate Example 1
        WebElement exemple1 = driver.findElement(By.linkText("Example 1: Element on page that is hidden and become visible after trigger"));
//        System.out.println(exemple1.getAttribute("href"));
// TODO partiallinktext
        WebElement example2 = driver.findElement(By.partialLinkText("2:"));
*/


    }
}
