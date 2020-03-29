package com.cybertek.tests.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;

public class EbaySearch {
    public static void main(String[] args) throws InterruptedException {
        /*
        Task:
            Go to amazon  https://www.amazon.com/
            then - Go to Ebay   https://www.ebay.com/
            Enter a search term
            Click on search button
            Verify title contains search term
        */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com/");
        Thread.sleep(3000);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.ebay.com/");
        Thread.sleep(3000);
        WebElement nameAttr = driver.findElement(By.name("_nkw"));
        nameAttr.sendKeys("necklace" + Keys.ENTER);
        //Keys.Enter is using the keyboard to click enter....we don't need the .click()
//        Thread.sleep(3000);
//        driver.findElement(By.id("gh-btn")).click();
//        Thread.sleep(3000);

        driver.close();
    }
}
